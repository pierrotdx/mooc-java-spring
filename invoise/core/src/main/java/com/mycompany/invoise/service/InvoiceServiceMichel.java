package com.mycompany.invoise.service;

import com.mycompany.invoise.entity.Invoice;
import com.mycompany.invoise.repository.InvoiceRepositoryInterface;

public class InvoiceServiceMichel implements InvoiceServiceInterface {
    private static Long lastNumber = 112l;

    private InvoiceRepositoryInterface invoiceRepositoryMichel;

    public void createInvoice(Invoice invoice) {
        invoice.setNumber(String.valueOf("INV_" + (++lastNumber)));
        this.invoiceRepositoryMichel.create(invoice);
    }
}
