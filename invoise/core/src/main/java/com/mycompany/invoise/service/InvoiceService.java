package com.mycompany.invoise.service;

import com.mycompany.invoise.entity.Invoice;
import com.mycompany.invoise.repository.InvoiceRepository;

public class InvoiceService {
    private static Long lastNumber = 0l;

    private InvoiceRepository invoiceRepository = new InvoiceRepository();

    public void createInvoice(Invoice invoice) {
        invoice.setNumber(String.valueOf(++lastNumber));
        this.invoiceRepository.create(invoice);
    }
}
