package com.mycompany.invoice.customer.repository;

import com.mycompany.invoise.core.entity.customer.Address;
import com.mycompany.invoise.core.entity.customer.Customer;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepositoryInterface extends CrudRepository<Address, Long> {
}
