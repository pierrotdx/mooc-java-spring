package com.mycompany.invoice.invoice.service;

import com.mycompany.invoise.core.entity.invoice.Invoice;

public interface InvoiceServiceInterface {
    Invoice createInvoice(Invoice invoice);
    Iterable<Invoice> getInvoiceList();
    Invoice getInvoiceByNumber(String number);
}
