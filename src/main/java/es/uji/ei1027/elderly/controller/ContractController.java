package es.uji.ei1027.elderly.controller;

import es.uji.ei1027.elderly.dao.CompanyDao;
import es.uji.ei1027.elderly.dao.ContractDao;
import es.uji.ei1027.elderly.model.Company;
import es.uji.ei1027.elderly.model.Contract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/contract")
public class ContractController {

    private ContractDao contractDao;

    @Autowired
    public void setCompanyDao(ContractDao contractDao) {
        this.contractDao=contractDao;
    }

    @RequestMapping(value="/add")
    public String addContract(Model model) {
        model.addAttribute("contract", new Contract());
        return "contract/add";
    }

    @RequestMapping(value="/add", method=RequestMethod.POST)
    public String processAddSubmit(@ModelAttribute("contract") Contract contract, BindingResult bindingResult) {
        if(bindingResult.hasErrors())
            return "contract/add";
        contractDao.addContract(contract);
        return "redirect:list";
    }

    @RequestMapping(value="/update/{number}", method = RequestMethod.GET)
    public String editContract(Model model, @PathVariable int number) {
        model.addAttribute("contract", contractDao.getContractByNumber(number));
        return "contract/update";
    }

    @RequestMapping(value="/update", method = RequestMethod.POST)
    public String processUpdateSubmit(@ModelAttribute("contract") Contract contract, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "contract/update";
        contractDao.updateContract(contract);
        return "redirect:list";
    }

    @RequestMapping(value = "/delete/{number}")
    public String processDelete(@PathVariable int number) {
        contractDao.deleteContract(number);
        return "redirect:../list";
    }

    @RequestMapping("/list")
    public String listContracts(Model model) {
        model.addAttribute("contracts", contractDao.getContracts());
        return "contract/list";
    }
}