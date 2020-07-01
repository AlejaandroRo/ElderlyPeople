package es.uji.ei1027.elderly.controller;

import es.uji.ei1027.elderly.dao.CasCommiteeDao;
import es.uji.ei1027.elderly.dao.SocialWorkerDao;
import es.uji.ei1027.elderly.model.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/casCommitee")
public class CasCommiteeController {
    private CasCommiteeDao casCommiteeDao;

    @Autowired
    public void setSocialWorkerDao(SocialWorkerDao socialWorkerDao) {
        this.casCommiteeDao = casCommiteeDao;
    }

    @RequestMapping(value="/menuPrincipal")
    public String showMenuPrincipal() {
        return "casCommitee/paginaPrincipal";
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
        if (user.getTypeOfUser() != "casCommitee") {
            return "redirect:/";
        }

        return "casCommitee/mainPage";
    }
}
