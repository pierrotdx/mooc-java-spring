package com.mycompany.invoise.core.controller.keyboard;

import com.mycompany.invoise.core.controller.InvoiceControllerInterface;
import com.mycompany.invoise.core.entity.Customer;
import com.mycompany.invoise.core.entity.Invoice;
import com.mycompany.invoise.core.service.InvoiceServiceInterface;

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
