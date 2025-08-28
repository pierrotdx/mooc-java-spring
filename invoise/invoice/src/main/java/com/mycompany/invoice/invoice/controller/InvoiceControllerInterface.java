package com.mycompany.invoice.invoice.controller;

import com.mycompany.invoice.invoice.service.InvoiceServiceInterface;
import com.mycompany.invoise.core.entity.invoice.Invoice;

public interface InvoiceControllerInterface {
    String createInvoice(Invoice invoice);
    void setInvoiceService(InvoiceServiceInterface invoiceService);
}
