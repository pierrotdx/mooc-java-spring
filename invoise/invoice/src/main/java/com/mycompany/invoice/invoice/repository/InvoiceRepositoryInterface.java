package com.mycompany.invoice.invoice.repository;

import com.mycompany.invoise.core.entity.invoice.Invoice;
import org.springframework.data.repository.CrudRepository;

public interface InvoiceRepositoryInterface extends CrudRepository<Invoice, String> {}
