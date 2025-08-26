//package com.mycompany.invoise.core.service.prefix;
//
//import com.mycompany.invoise.core.entity.Invoice;
//import com.mycompany.invoise.core.repository.InvoiceRepositoryInterface;
//import com.mycompany.invoise.core.service.InvoiceServiceInterface;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class InvoiceServicePrefix implements InvoiceServiceInterface {
//    @Value("${invoice.lastNumber}")
//    private Long lastNumber;
//    @Value("${invoice.prefix}")
//    private String prefix;
//
//    public InvoiceServicePrefix(InvoiceRepositoryInterface invoiceRepository) {
//        this.invoiceRepository = invoiceRepository;
//    }
//
//    private final InvoiceRepositoryInterface invoiceRepository;
//
//    public InvoiceRepositoryInterface getInvoiceRepository() {
//        return invoiceRepository;
//    }
//
//    public Invoice createInvoice(Invoice invoice) {
//        invoice.setNumber(String.valueOf(this.prefix + (++lastNumber)));
//        this.invoiceRepository.save(invoice);
//        return invoice;
//    }
//
//    public String getPrefix() {
//        return prefix;
//    }
//
//    public void setPrefix(String prefix) {
//        this.prefix = prefix;
//    }
//
//    public Long getLastNumber() {
//        return lastNumber;
//    }
//
//    public void setLastNumber(Long lastNumber) {
//        this.lastNumber = lastNumber;
//    }
//
//    @Override
//    public Iterable<Invoice> getInvoiceList() {
//        return this.invoiceRepository.findAll();
//    }
//
//    @Override
//    public Invoice getInvoiceByNumber(String number) {
//        return this.invoiceRepository.findById(number).orElseThrow();
//    }
//}
