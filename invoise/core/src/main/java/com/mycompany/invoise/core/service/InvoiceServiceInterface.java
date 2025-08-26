package com.mycompany.invoise.core.service;

import com.mycompany.invoise.core.entity.Invoice;

import java.util.List;

public interface InvoiceServiceInterface {
    Invoice createInvoice(Invoice invoice);
    Iterable<Invoice> getInvoiceList();
    Invoice getInvoiceByNumber(String number);
}
