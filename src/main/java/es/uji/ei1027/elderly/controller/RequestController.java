package es.uji.ei1027.elderly.controller;

import es.uji.ei1027.elderly.dao.ElderlyDao;
import es.uji.ei1027.elderly.dao.RequestDao;
import es.uji.ei1027.elderly.model.Elderly;
import es.uji.ei1027.elderly.model.Request;
import es.uji.ei1027.elderly.model.UserDetails;
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

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/request")
public class RequestController {
    private RequestDao requestDao;

    @Autowired
    public void setRequestDao(RequestDao requestDao) {
        this.requestDao=requestDao;
    }

    @RequestMapping(value="/add")
    public String addRequest(Model model) {
        model.addAttribute("request", new Request());
        return "request/add";
    }

    @RequestMapping(value="/add", method= RequestMethod.POST)
    public String processAddSubmit(@ModelAttribute("request") Request request,
                                   BindingResult bindingResult) {
        RequestValidator requestValidator = new RequestValidator();
        requestValidator.validate(request, bindingResult);
        if (bindingResult.hasErrors())
            return "request/add";
        String dni = request.getDniElderly();
        requestDao.addRequest(request);
        return "redirect:list/" + dni;
    }

    @RequestMapping(value="/update/{number}", method = RequestMethod.GET)
    public String editRequest(Model model, @PathVariable int number) {
        model.addAttribute("request", requestDao.getRequestByNumber(number));
        return "request/update";
    }

    @RequestMapping(value="/update", method = RequestMethod.POST)
    public String processUpdateSubmit(
            @ModelAttribute("request") Request request,
            BindingResult bindingResult) {
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
        model.addAttribute("requests", requestDao.getRequestsByElderly(dniElderly));
        return "request/list";
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
        List<String> valors = Arrays.asList("Comida a domicilio", "Servicio sanitario", "Limpieza");
        if(request.getServiceType().equals("") || request.getServiceType().equals("No seleccionado")) {
            errors.rejectValue("serviceType", "obligatorio", "Debe elegir un tipo de servicio");
        }
        if (request.getDniElderly().equals("")) {
            errors.rejectValue("dniElderly", "obligatorio", "Debe que introducir su DNI");
        }
//        Request requestRepetida = requestDao.getRequestByType(request.getServiceType());
//        if (requestRepetida != null) {
//            errors.rejectValue("serviceType1", "obligatorio", "No puede volvler a contratar un servicio que ya tiene contradado");
//        }
    }
}

