package es.uji.ei1027.elderly.controller;

import javax.servlet.http.HttpSession;

import es.uji.ei1027.elderly.dao.ElderlyDao;
import es.uji.ei1027.elderly.model.Elderly;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import es.uji.ei1027.elderly.dao.UserDao;
import es.uji.ei1027.elderly.model.UserDetails;

import static sun.misc.Version.print;

@Controller
@RequestMapping("/user")
public class UserController {
    private UserDao userDao;

    @Autowired
    public void setSociDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @RequestMapping("/list")
    public String listSocis(HttpSession session, Model model) {
        if (session.getAttribute("user") == null)
        {
            ElderlyDao elderlyDao = new ElderlyDao();
            Elderly elderly = elderlyDao.getElderlyByName("user");
            elderly.toString();
            model.addAttribute("user", new UserDetails());
            session.setAttribute("nextUrl", "request/list/" + elderly.getDni());
            return "login";
        }
        model.addAttribute("users", userDao.listAllUsers());
        return "user/list";
    }
}
