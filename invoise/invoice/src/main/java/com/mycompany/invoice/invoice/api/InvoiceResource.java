package com.mycompany.invoice.invoice.api;

import com.mycompany.invoice.invoice.service.InvoiceServiceInterface;
import com.mycompany.invoise.core.entity.customer.Address;
import com.mycompany.invoise.core.entity.customer.Customer;
import com.mycompany.invoise.core.entity.invoice.Invoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/invoice")
public class InvoiceResource {
    @Autowired
    private InvoiceServiceInterface invoiceService;

    @Autowired
    private RestTemplate restTemplate;

    public InvoiceServiceInterface getInvoiceService() {
        return invoiceService;
    }

    public void setInvoiceService(InvoiceServiceInterface invoiceService) {
        this.invoiceService = invoiceService;
    }
//
//    @PostMapping
//    public Invoice create(@RequestBody Invoice invoice) {
//        this.invoiceService.createInvoice(invoice);
//        return invoice;
//    }

    @GetMapping
    public Iterable<Invoice> list() {
        System.out.println("La méthode displayHomFe() a été invoquée.");
        Iterable<Invoice> invoices = this.invoiceService.getInvoiceList();
        for (Invoice invoice : invoices) {
            invoice.setCustomer(restTemplate.getForObject("http://localhost:8081/customer/" + invoice.getIdCustomer(), Customer.class));
        }
        return invoices;
    }

    @GetMapping("/{id}")
    public Invoice get(@PathVariable("id") String number) {
        Invoice invoice = this.invoiceService.getInvoiceByNumber(number);
        final Customer customer = restTemplate.getForObject("http://localhost:8081/customer/" + invoice.getIdCustomer(), Customer.class);
        final Address address = restTemplate.getForObject("http://localhost:8081/address/" + customer.getAddress().getId(), Address.class);
        customer.setAddress(address);
        invoice.setCustomer(customer);
        System.out.println("La méthode displayInvoice() a été invoquée.");
        return invoice;
    }

//    @GetMapping("/create-form")
//    public String displayCreateForm(@ModelAttribute InvoiceForm invoice) {
//        return "invoice-create-form";
//    }


    public RestTemplate getRestTemplate() {
        return restTemplate;
    }

    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
}
