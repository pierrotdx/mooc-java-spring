package com.mycompany.invoise.core.service;

import com.mycompany.invoise.core.entity.Invoice;

import java.util.List;

public interface InvoiceServiceInterface {
    void createInvoice(Invoice invoice);
    List<Invoice> getInvoiceList();
}
