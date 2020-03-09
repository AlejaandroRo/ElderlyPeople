package es.uji.ei1027.elderly.controller;

import es.uji.ei1027.elderly.dao.VolunteerDao;
import es.uji.ei1027.elderly.model.Volunteer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/volunteer")
public class VolunteerController {
    private VolunteerDao volunteerDao;

    @Autowired
    public void setVolunteerDao(VolunteerDao volunteerDao) {
        this.volunteerDao = volunteerDao;
    }

    @RequestMapping(value="/delete/{userV}")
    public String processDelete(@PathVariable String userV) {
        volunteerDao.deleteVolunteer(userV);
        return "redirect:../list";
    }

    @RequestMapping("/list")
    public String listVolunteers(Model model) {
        model.addAttribute("volunteers", volunteerDao.getVolunteers());
        return "volunteer/list";
    }
}
