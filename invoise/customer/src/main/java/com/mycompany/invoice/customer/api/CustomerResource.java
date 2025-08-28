package com.mycompany.invoice.customer.api;

import com.mycompany.invoice.customer.repository.CustomerRepositoryInterface;
import com.mycompany.invoise.core.entity.customer.Customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/customer")
public class CustomerResource {
    @Autowired
    private CustomerRepositoryInterface customerRepositoryInterface;

    @GetMapping("/{id}")
    public Customer get(@PathVariable("id") Long id) {
        return this.customerRepositoryInterface.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public CustomerRepositoryInterface getCustomerRepositoryInterface() {
        return customerRepositoryInterface;
    }

    public void setCustomerRepositoryInterface(CustomerRepositoryInterface customerRepositoryInterface) {
        this.customerRepositoryInterface = customerRepositoryInterface;
    }
}
