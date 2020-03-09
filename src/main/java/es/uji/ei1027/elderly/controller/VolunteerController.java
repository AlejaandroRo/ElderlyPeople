package es.uji.ei1027.elderly.controller;

import es.uji.ei1027.elderly.dao.VolunteerDao;
import es.uji.ei1027.elderly.model.Volunteer;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

public class VolunteerController {
    private VolunteerDao volunteerDao;

    public void setVolunteerDao(VolunteerDao volunteerDao) {
        this.volunteerDao = volunteerDao;
    }

    @RequestMapping("/list")
    public String listSocialWorkers(Model model) {
        model.addAttribute("volunteers", volunteerDao.getVolunteers());
        return "volunteer/list";
    }
}
