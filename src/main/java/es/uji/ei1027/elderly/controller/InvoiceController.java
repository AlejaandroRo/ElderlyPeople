package es.uji.ei1027.elderly.controller;

import es.uji.ei1027.elderly.dao.ElderlyDao;
import es.uji.ei1027.elderly.dao.InvoiceDao;
import es.uji.ei1027.elderly.model.Invoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.thymeleaf.model.IModel;

@Controller
@RequestMapping("/invoice")
public class InvoiceController {
    private InvoiceDao invoiceDao;

    @Autowired
    public void setInvoiceDao(InvoiceDao invoiceDao) {
        this.invoiceDao=invoiceDao;
    }

    @RequestMapping(value = "/add")
    public String addInvoce(Model model) {
        model.addAttribute("invoice", new Invoice());
        return "invoice/add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String processAddSubmit(@ModelAttribute("invoice") Invoice invoice, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "invoice/add";
        invoiceDao.addInvoice(invoice);
        return "redirect:list";
    }

    @RequestMapping(value = "/update/{number}", method = RequestMethod.GET)
    public String updateInvoice(Model model, @PathVariable("number") int number) {
        model.addAttribute("invoice", invoiceDao.getInvoiceByNumber(number));
        return "invoice/update";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String processUpdateSubmit(@ModelAttribute("invoice") Invoice invoice, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "invoice/update";
        invoiceDao.updateInvoice(invoice);
        return "redirect:list";
    }

    @RequestMapping(value = "/delete/{number}")
    public String processDelete(@PathVariable("number") int number) {
        invoiceDao.deleteInvoice(number);
        return "redirect:../list";
    }

    @RequestMapping(value = "/list")
    public String listInvoices(Model model) {
        model.addAttribute("invoices", invoiceDao.getInvoices());
        return "invoice/list";
    }
}
