package es.uji.ei1027.elderly.controller;

import es.uji.ei1027.elderly.dao.SocialWorkerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/casManager")
public class CasManagerController {
    private SocialWorkerDao socialWorkerDao;

    @Autowired
    public void setSocialWorkerDao(SocialWorkerDao socialWorkerDao) {
        this.socialWorkerDao = socialWorkerDao;
    }

    @RequestMapping(value="/menuPrincipal")
    public String showMenuPrincipal() {
        return "casManager/menuPrincipal";
    }
}
