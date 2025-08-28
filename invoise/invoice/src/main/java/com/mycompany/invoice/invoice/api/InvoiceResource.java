package com.mycompany.invoice.invoice.api;

import com.mycompany.invoise.core.entity.customer.Customer;
import com.mycompany.invoise.core.entity.invoice.Invoice;
import com.mycompany.invoise.core.service.InvoiceServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/invoice")
public class InvoiceResource {
//    @Autowired
//    private InvoiceServiceInterface invoiceService;
//
//    public InvoiceServiceInterface getInvoiceService() {
//        return invoiceService;
//    }
//
//    public void setInvoiceService(InvoiceServiceInterface invoiceService) {
//        this.invoiceService = invoiceService;
//    }
//
//    @PostMapping
//    public Invoice create(@RequestBody Invoice invoice) {
//        this.invoiceService.createInvoice(invoice);
//        return invoice;
//    }

    @GetMapping
    public Iterable<Invoice> list() {
        System.out.println("La méthode displayHomFe() a été invoquée.");
        //return this.invoiceService.getInvoiceList();
        List<Invoice> invoices = new ArrayList<>();
        Customer customer = new Customer("lambda");
        Invoice invoice = new Invoice("NUM_001", "orderNumber", customer);
        invoices.add(invoice);
        return invoices;
    }

//    @GetMapping("/{id}")
//    public Invoice get(@PathVariable("id") String number) {
//        System.out.println("La méthode displayInvoice() a été invoquée.");
//        return this.invoiceService.getInvoiceByNumber(number);
//    }

//    @GetMapping("/create-form")
//    public String displayCreateForm(@ModelAttribute InvoiceForm invoice) {
//        return "invoice-create-form";
//    }
}
