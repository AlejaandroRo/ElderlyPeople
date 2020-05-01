package es.uji.ei1027.elderly.controller;

import es.uji.ei1027.elderly.model.UserDetails;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

class UserValidator implements Validator {
    @Override
    public boolean supports(Class<?> cls) {
        return UserDetails.class.isAssignableFrom(cls);
    }
    @Override
    public void validate(Object obj, Errors errors) {
        // Exercici: Afegeix codi per comprovar que
        // l'usuari i la contrasenya no estiguen buits
        // ...
        UserDetails user = (UserDetails) obj;
        if (user.getUsername().trim().equals(""))
            errors.rejectValue("username", "obligatori",
                    "Cal introduir un valor.");
        if (user.getPassword().trim().equals(""))
            errors.rejectValue("password", "obligatori",
                    "Cal introduir un valor.");
    }
}
