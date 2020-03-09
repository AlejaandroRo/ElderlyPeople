package es.uji.ei1027.elderly.controller;

import es.uji.ei1027.elderly.dao.ElderlyDao;
import es.uji.ei1027.elderly.model.Elderly;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/elderly")
public class ElderlyController {

    private ElderlyDao elderlyDao;

    @Autowired
    public void setElderlyDao(ElderlyDao elderlyDao) {
        this.elderlyDao = elderlyDao;
    }

    @RequestMapping("/list")
    public String listElderlies(Model model) {
        model.addAttribute("elderlies", elderlyDao.getElderlies());
        return "elderly/list";
    }
}
