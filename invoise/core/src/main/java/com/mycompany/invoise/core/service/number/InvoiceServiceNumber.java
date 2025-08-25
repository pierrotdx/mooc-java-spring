package com.mycompany.invoise.core.service.number;

import com.mycompany.invoise.core.entity.Invoice;
import com.mycompany.invoise.core.repository.InvoiceRepositoryInterface;
import com.mycompany.invoise.core.service.InvoiceServiceInterface;

import java.util.List;

//@Service
public class InvoiceServiceNumber implements InvoiceServiceInterface {
    private static Long lastNumber = 0l;

    public InvoiceRepositoryInterface getInvoiceRepository() {
        return invoiceRepository;
    }

    public void setInvoiceRepository(InvoiceRepositoryInterface invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    private InvoiceRepositoryInterface invoiceRepository;

    public Invoice createInvoice(Invoice invoice) {
        invoice.setNumber(String.valueOf(++lastNumber));
        this.invoiceRepository.create(invoice);
        return invoice;
    }

    @Override
    public List<Invoice> getInvoiceList() {
        return this.invoiceRepository.list();
    }

    @Override
    public Invoice getInvoiceByNumber(String number) {
        return this.invoiceRepository.getById(number);
    }
}
