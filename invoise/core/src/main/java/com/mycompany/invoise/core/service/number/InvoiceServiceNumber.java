package com.mycompany.invoise.core.service.number;

import com.mycompany.invoise.core.entity.Invoice;
import com.mycompany.invoise.core.repository.InvoiceRepositoryInterface;
import com.mycompany.invoise.core.service.InvoiceServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class InvoiceServiceNumber implements InvoiceServiceInterface {
    private static Long lastNumber = 0l;

    public InvoiceRepositoryInterface getInvoiceRepository() {
        return invoiceRepository;
    }

    @Autowired
    private InvoiceRepositoryInterface invoiceRepository;

    public void setInvoiceRepository(InvoiceRepositoryInterface invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    public Invoice createInvoice(Invoice invoice) {
        return this.invoiceRepository.save(invoice);
    }

    @Override
    public Iterable<Invoice> getInvoiceList() {
        return this.invoiceRepository.findAll();
    }

    @Override
    public Invoice getInvoiceByNumber(String number) {
        return this.invoiceRepository.findById(number).orElseThrow();
    }
}
