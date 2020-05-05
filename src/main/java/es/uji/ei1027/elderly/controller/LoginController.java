package es.uji.ei1027.elderly.controller;

import javax.servlet.http.HttpSession;

import es.uji.ei1027.elderly.dao.ElderlyDao;
import es.uji.ei1027.elderly.model.Elderly;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import es.uji.ei1027.elderly.dao.UserDao;
import es.uji.ei1027.elderly.model.UserDetails;

class UserValidator implements Validator {
    @Override
    public boolean supports(Class<?> cls) {
        return UserDetails.class.isAssignableFrom(cls);
    }
    @Override
    public void validate(Object obj, Errors errors) {
        UserDetails userDetails = (UserDetails)obj;
        if(userDetails.getUsername().equals("")) {
            errors.rejectValue("username", "obligatorio", "Debes introducir un nombre de usuario");
        }
        if (userDetails.getPassword().equals("")) {
            errors.rejectValue("password", "obligatoria", "Tienes que introducir una contraseña");
        }
    }
}

@Controller
public class LoginController {
    @Autowired
    private UserDao userDao;

    @RequestMapping("/login")
    public String login(Model model) {
        model.addAttribute("user", new UserDetails());
        return "login";
    }

    @RequestMapping(value="/login", method=RequestMethod.POST)
    public String checkLogin(@ModelAttribute("user") UserDetails user,
                             BindingResult bindingResult, HttpSession session) {
        UserValidator userValidator = new UserValidator();
        userValidator.validate(user, bindingResult);
        if (bindingResult.hasErrors()) {
            return "login";
        }
        // Comprova que el login siga correcte
        // intentant carregar les dades de l'usuari
        user = userDao.loadUserByUsername(user.getUsername(), user.getPassword());
        if (user == null) {
            bindingResult.rejectValue("password", "badpw", "Contrasenya incorrecta");
            return "login";
        }
        // Autenticats correctament.
        // Guardem les dades de l'usuari autenticat a la sessió
        session.setAttribute("user", user);
        String nextUrl = (String) session.getAttribute("nextUrl");
        session.removeAttribute("nextUrl");
        // Torna a la pàgina principal
        //elderlyDao = new ElderlyDao();
        //elderlyDao.getElderlyByName("bob");
        //Elderly elderly = elderlyDao.getElderlyByName("bob");
        return "elderly/inicio";
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
}
