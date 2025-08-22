package com.mycompany.invoise.controller;

import com.mycompany.invoise.entity.Invoice;
import com.mycompany.invoise.service.InvoiceService;
import com.mycompany.invoise.service.InvoiceServiceMichel;

import java.util.Scanner;

public class InvoiceController {
    public void createInvoiceUsingConsole() {
        Scanner sc = new Scanner(System.in);
        System.out.println("What is the customer name?");
        String customerName = sc.nextLine();
        Invoice invoice = new Invoice();
        invoice.setCustomerName(customerName);

        InvoiceService invoiceService = new InvoiceService();
        invoiceService.createInvoice(invoice);
    }
}
