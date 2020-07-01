package es.uji.ei1027.elderly.controller;

import es.uji.ei1027.elderly.dao.ElderlyDao;
import es.uji.ei1027.elderly.dao.RequestDao;
import es.uji.ei1027.elderly.model.*;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.*;

@Controller
@RequestMapping("/request")
public class RequestController {
    private RequestDao requestDao;

    @Autowired
    public void setRequestDao(RequestDao requestDao) {
        this.requestDao=requestDao;
    }

    @RequestMapping(value="/add/{dniElderly}")
    public String addRequest(Model model, @PathVariable String dniElderly) {
        Request request = new Request();
        request.setDniElderly(dniElderly);
        List<Request> requestsByElderly;
        requestsByElderly = requestDao.getRequestsByElderly(request.getDniElderly());

        List<Request> accepted = new ArrayList<Request>();
        List<Request> pending = new ArrayList<Request>();
        List<Request> rejected = new ArrayList<Request>();

        for (Request req: requestsByElderly) {
            if (req.getServiceType().equals(request.getServiceType())) {
                throw new ElderlyException("Service type " + req.getServiceType() + " already exists, try again another service", "ServiceDuplicado");
            }
        }
        model.addAttribute("request", request);
        return "request/add";
    }

    @RequestMapping(value="/add", method= RequestMethod.POST)
    public String processAddSubmit(@ModelAttribute("request") Request request,
                                   BindingResult bindingResult) {
        RequestValidator requestValidator = new RequestValidator();
        requestValidator.validate(request, bindingResult);
        Aviso aviso = new Aviso();
        if (bindingResult.hasErrors())
            return "request/add";
        List<Request> requestsByElderly = requestDao.getRequestsByElderly(request.getDniElderly());
        for (Request req: requestsByElderly) {
            if (req.getServiceType().equals(request.getServiceType())) {
                throw new ElderlyException("Service type " + req.getServiceType() + " already exists, try again another service", "ServiceDuplicado");
            }
        }
        String dni = request.getDniElderly();
        requestDao.addRequest(request);
        aviso.notificarTodoHaIdoBien();
        aviso.notificarCorreoRequest(request);
        return "redirect:list/" + dni;
    }

    @RequestMapping(value="/update/{number}", method = RequestMethod.GET)
    public String editRequest(Model model, @PathVariable int number) {
        model.addAttribute("request", requestDao.getRequestByNumber(number));
        return "request/update";
    }

    @RequestMapping(value="/cas/update/{number}", method = RequestMethod.GET)
    public String evaluateRequest(Model model, @PathVariable int number) {
        Request request = requestDao.getRequestByNumber(number);
        List<Contract> listContract = requestDao.getContractByType(request.getServiceType());
        //request.setState("Accepted");
        model.addAttribute("request", requestDao.getRequestByNumber(number));
        model.addAttribute("listContract", listContract);
        return "request/casUpdate";
    }

    @RequestMapping(value="/cas/update", method = RequestMethod.POST)
    public String processUpdateAndSubmit(@ModelAttribute("request") Request request, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "request/cas/update";
        requestDao.updateRequest(request);
        return "redirect:list";
    }

    @RequestMapping(value="/update", method = RequestMethod.POST)
    public String processUpdateSubmit(@ModelAttribute("request") Request request, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "request/update";
        requestDao.updateRequest(request);
        return "redirect:list";
    }

    @RequestMapping(value="/delete/{dniElderly}/{number}")
    public String processDelete(@PathVariable String dniElderly, @PathVariable int number) {
        requestDao.deleteRequest(number);
        return "redirect:../../list/" + dniElderly;
    }

    @RequestMapping("/list")
    public String listRequests(Model model) {
        model.addAttribute("requests", requestDao.getRequests());
        return "request/list";
    }

    @RequestMapping(value="/list/{dniElderly}", method = RequestMethod.GET)
    public String editRequest(Model model, @PathVariable String dniElderly) {
        List<Request> requestsByElderly;
        requestsByElderly = requestDao.getRequestsByElderly(dniElderly);

        List<Request> accepted = new ArrayList<Request>();
        List<Request> pending = new ArrayList<Request>();
        List<Request> rejected = new ArrayList<Request>();

        for (Request request: requestsByElderly) {
            if (request.getState().equals("Accepted"))
                accepted.add(request);
            else if (request.getState().equals("Pending"))
                pending.add(request);
            else rejected.add(request);
        }

        model.addAttribute("accepted", accepted);
        model.addAttribute("pending", pending);
        model.addAttribute("rejected", rejected);
        model.addAttribute("dniElderly", dniElderly);
        return "request/list";
    }

    @RequestMapping(value="/cas/list/{dniElderly}", method = RequestMethod.GET)
    public String evaluateRequest(Model model, @PathVariable String dniElderly) {
        List<Request> requestsByElderly;
        requestsByElderly = requestDao.getRequestsByElderly(dniElderly);

        List<Request> accepted = new ArrayList<Request>();
        List<Request> pending = new ArrayList<Request>();
        List<Request> rejected = new ArrayList<Request>();

        for (Request request: requestsByElderly) {
            if (request.getState().equals("Accepted"))
                accepted.add(request);
            else if (request.getState().equals("Pending"))
                pending.add(request);
            else rejected.add(request);
        }

        model.addAttribute("accepted", accepted);
        model.addAttribute("pending", pending);
        model.addAttribute("rejected", rejected);
        model.addAttribute("dniElderly", dniElderly);
        return "request/casList";
    }
}


@Controller
@RequestMapping("/request")
class RequestValidator implements Validator {
    private RequestDao requestDao;

    @Autowired
    public void setRequestDao(RequestDao requestDao) {
        this.requestDao=requestDao;
    }

    @Override
    public boolean supports(Class<?> cls) {
        return Request.class.isAssignableFrom(cls);
    }
    @Override
    public void validate(Object obj, Errors errors) {
        Request request = (Request) obj;
        List<String> valors = Arrays.asList("Catering", "Basic health care", "Housekeeping services");
        if(request.getServiceType().equals("") || request.getServiceType().equals("Not selected")) {
            errors.rejectValue("serviceType", "obligatorio", "A type of service must be selected");
        }

//        if (request.getDniElderly().equals("")) {
//            errors.rejectValue("dniElderly", "obligatorio", "Debe que introducir su DNI");
//        }
        //Request r = requestDao.getRequestByType("Comida a domicilio");
//        List<Request> requestsRepetidos = requestDao.getRequestsByElderly(request.getDniElderly());
//        for (int i=0; i<requestsRepetidos.size(); i++) {
//            if (requestsRepetidos.get(i).getServiceType().equals("Comida a domicilio")) {
//        System.out.println(ra.get(0));
  //      if (ra.get(0).getServiceType().equals("Comida a domicilio")) {
//            errors.rejectValue("serviceType", "obligatorio", "No puede volver a contratar un servicio que ya tiene contradado");
             //   }
           // }
        }
        //if (requestRepetida != null &&
//        }
   // }
}

