package com.mycompany.invoice.invoice.controller.scan;

import com.mycompany.invoice.invoice.controller.InvoiceControllerInterface;
import com.mycompany.invoice.invoice.service.InvoiceServiceInterface;
import com.mycompany.invoise.core.entity.customer.Customer;
import com.mycompany.invoise.core.entity.invoice.Invoice;

//@Controller
public class InvoiceControllerDouchette implements InvoiceControllerInterface {
    private InvoiceServiceInterface invoiceService;

    public InvoiceServiceInterface getInvoiceService() {
        return invoiceService;
    }

    public void setInvoiceService(InvoiceServiceInterface invoiceService) {
        this.invoiceService = invoiceService;
    }

    public String createInvoice(Invoice invoice) {
        System.out.println("Usage of a scanner");
        invoice = new Invoice();
        Customer customer = new Customer("Virgin Galactic");
        invoice.setCustomer(customer);
        this.invoiceService.createInvoice(invoice);
        return null;
    }
}
