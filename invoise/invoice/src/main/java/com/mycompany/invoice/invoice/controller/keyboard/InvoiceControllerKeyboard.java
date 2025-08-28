package com.mycompany.invoice.invoice.controller.keyboard;

import com.mycompany.invoice.invoice.controller.InvoiceControllerInterface;
import com.mycompany.invoice.invoice.service.InvoiceServiceInterface;
import com.mycompany.invoise.core.entity.customer.Customer;
import com.mycompany.invoise.core.entity.invoice.Invoice;

import java.util.Scanner;

//@Controller
public class InvoiceControllerKeyboard implements InvoiceControllerInterface {
    public InvoiceServiceInterface getInvoiceService() {
        return invoiceService;
    }

    public void setInvoiceService(InvoiceServiceInterface invoiceService) {
        this.invoiceService = invoiceService;
    }

    private InvoiceServiceInterface invoiceService;

    public String createInvoice(Invoice invoice) {
        Scanner sc = new Scanner(System.in);
        System.out.println("What is the customer name?");
        String customerName = sc.nextLine();
        invoice = new Invoice();
        Customer customer = new Customer(customerName);
        invoice.setCustomer(customer);

        this.invoiceService.createInvoice(invoice);
        return null;
    }
}
