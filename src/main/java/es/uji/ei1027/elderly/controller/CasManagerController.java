package es.uji.ei1027.elderly.controller;

import es.uji.ei1027.elderly.dao.CasManagerDao;
import es.uji.ei1027.elderly.dao.SocialWorkerDao;
import es.uji.ei1027.elderly.model.CasManager;
import es.uji.ei1027.elderly.model.Elderly;
import es.uji.ei1027.elderly.model.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/casManager")
public class CasManagerController {
    private CasManagerDao casManagerDao;

    @Autowired
    public void setSocialWorkerDao(SocialWorkerDao socialWorkerDao) {
        this.casManagerDao = casManagerDao;
    }

    @RequestMapping(value="/menuPrincipal")
    public String showMenuPrincipal() {
        return "casManager/menuPrincipal";
    }

    @RequestMapping("/mainPage")
    public String mainPage(HttpSession session, Model model) {
        UserDetails user = (UserDetails) session.getAttribute("user");
        if (user == null)
        {
            model.addAttribute("user", new UserDetails());
            return "login";
        }

        /*CasManager casManager = casManagerDao.getCasManagerByUserName(user.getUsername());
        model.addAttribute("user", casManager);*/
        return "casManager/mainPage";
    }
}
