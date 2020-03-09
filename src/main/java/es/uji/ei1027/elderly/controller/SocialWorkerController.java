package es.uji.ei1027.elderly.controller;

import es.uji.ei1027.elderly.dao.ElderlyDao;
import es.uji.ei1027.elderly.dao.SocialWorkerDao;
import es.uji.ei1027.elderly.model.Elderly;
import es.uji.ei1027.elderly.model.SocialWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/socialWorker")
public class SocialWorkerController {

    private SocialWorkerDao socialWorkerDao;

    @Autowired
    public void setSocialWorkerDao(SocialWorkerDao socialWorkerDao) {
        this.socialWorkerDao = socialWorkerDao;
    }

    @RequestMapping(value="/add")
    public String addSocialWorker(Model model) {
        model.addAttribute("socialWorker", new SocialWorker());
        return "socialWorker/add";
    }

    @RequestMapping(value="/add", method= RequestMethod.POST)
    public String processAddSubmit(@ModelAttribute("socialWorker") SocialWorker socialWorker,
                                   BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "socialWorker/add";
        socialWorkerDao.addSocialWorker(socialWorker);
        return "redirect:list";
    }

    @RequestMapping(value="/delete/{userCAS}")
    public String processDelete(@PathVariable String userCAS) {
        socialWorkerDao.deleteSocialWorker(userCAS);
        return "redirect:../list";
    }

    @RequestMapping("/list")
    public String listSocialWorkers(Model model) {
        model.addAttribute("socialWorkers", socialWorkerDao.getSocialWorkers());
        return "socialWorker/list";
    }
}
