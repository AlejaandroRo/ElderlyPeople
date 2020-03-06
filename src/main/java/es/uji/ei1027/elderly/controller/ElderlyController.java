package es.uji.ei1027.elderly.controller;

import es.uji.ei1027.elderly.dao.ElderlyDao;
import es.uji.ei1027.elderly.model.Elderly;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ElderlyController {
    @RequestMapping("/elderly")
    public String provaWeb(Model model) {
        String message = "Provant la Web Elderly People";
        model.addAttribute("message", message);
        return "elderly";
    }

    @Autowired
    ElderlyDao elderlyDao;

    @RequestMapping("/provaElderly")
    public String provaUnElderly(Model model) {
        Elderly elderly = elderlyDao.getElderly("Daniel Navarro");
        model.addAttribute("message", elderly.toString());
        return "elderly";
    }
}
