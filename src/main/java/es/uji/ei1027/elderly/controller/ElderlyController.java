package es.uji.ei1027.elderly.controller;

import es.uji.ei1027.elderly.dao.ElderlyDao;
import es.uji.ei1027.elderly.model.Elderly;
import es.uji.ei1027.elderly.model.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/elderly")
public class ElderlyController {

    private ElderlyDao elderlyDao;

    @Autowired
    public void setElderlyDao(ElderlyDao elderlyDao) {
        this.elderlyDao=elderlyDao;
    }

    @RequestMapping(value="/add")
    public String addElderly(Model model) {
        model.addAttribute("elderly", new Elderly());
        return "elderly/add";
    }

    @RequestMapping(value="/add", method= RequestMethod.POST)
    public String processAddSubmit(@ModelAttribute("elderly") Elderly elderly,
                                   BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "elderly/add";
        elderlyDao.addElderly(elderly);
        return "redirect:list";
    }

    @RequestMapping(value="/update/{dni}", method = RequestMethod.GET)
    public String editElderly(Model model, @PathVariable String dni) {
        model.addAttribute("elderly", elderlyDao.getElderlyByDni(dni));
        return "elderly/update";
    }

    @RequestMapping(value="/update", method = RequestMethod.POST)
    public String processUpdateSubmit(
            @ModelAttribute("elderly") Elderly elderly,
            BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "elderly/update";
        elderlyDao.updateElderly(elderly);
        return "redirect:list";
    }

    @RequestMapping(value="/delete/{dni}")
    public String processDelete(@PathVariable String dni) {
        elderlyDao.deleteElderly(dni);
        return "redirect:../list";
    }

    @RequestMapping("/list")
    public String listElderlies(Model model) {
        model.addAttribute("elderlies", elderlyDao.getElderlies());
        return "elderly/list";
    }

    @RequestMapping("/cas/list")
    public String listCasElderlies(Model model) {
        model.addAttribute("elderlies", elderlyDao.getElderlies());
        return "elderly/casList";
    }

    @RequestMapping("/aboutUs")
    public String aboutUs() {
        return "us/aboutUs";
    }
    @RequestMapping("/addOrPhone/{dni}")
    public String getAddOrPhone(Model model, @PathVariable String dni){
        model.addAttribute("dni", dni);
        return "elderly/addOrPhone";
    }

    @RequestMapping("/phone")
    public String getPhone(){
        return "elderly/phone";
    }

    @RequestMapping("/mainPage")
    public String mainPage(HttpSession session, Model model) {
        UserDetails user = (UserDetails) session.getAttribute("user");
        if (user == null)
        {
            model.addAttribute("user", new UserDetails());
            return "login";
        }

        if (user.getTypeOfUser() != "elderly") {
            return "redirect:/";
        }

        Elderly elderly = elderlyDao.getElderlyByUserName(user.getUsername());
        model.addAttribute("user", elderly);
        return "elderly/mainPage";
    }

}
