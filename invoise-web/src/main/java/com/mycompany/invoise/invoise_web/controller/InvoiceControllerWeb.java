package com.mycompany.invoise.invoise_web.controller;

import com.mycompany.invoise.core.controller.InvoiceControllerInterface;
import com.mycompany.invoise.core.entity.Invoice;
import com.mycompany.invoise.core.service.InvoiceServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/invoice")
public class InvoiceControllerWeb implements InvoiceControllerInterface {
    @Autowired
    private InvoiceServiceInterface invoiceService;

    public InvoiceServiceInterface getInvoiceService() {
        return invoiceService;
    }

    public void setInvoiceService(InvoiceServiceInterface invoiceService) {
        this.invoiceService = invoiceService;
    }

    public void createInvoice() {
        String customerName = "Tesla";
        Invoice invoice = new Invoice();
        invoice.setCustomerName(customerName);

        this.invoiceService.createInvoice(invoice);
    }

    @RequestMapping("/home")
    public String displayHome(Model model) {
        System.out.println("La méthode displayHome() a été invoquée.");
        List<Invoice> invoices = this.invoiceService.getInvoiceList();
        model.addAttribute("invoices", invoices);
        return "invoice-home";
    }

    @RequestMapping("/{id}")
    public String displayInvoice(@PathVariable("id") String number, Model model) {
        System.out.println("La méthode displayInvoice() a été invoquée.");
        Invoice invoice = this.invoiceService.getInvoiceByNumber(number);
        model.addAttribute("invoice", invoice);
        return "invoice-details";
    }
}
