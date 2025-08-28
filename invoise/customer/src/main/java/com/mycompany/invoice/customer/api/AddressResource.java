package com.mycompany.invoice.customer.api;

import com.mycompany.invoice.customer.repository.AddressRepositoryInterface;
import com.mycompany.invoice.customer.repository.CustomerRepositoryInterface;
import com.mycompany.invoise.core.entity.customer.Address;
import com.mycompany.invoise.core.entity.customer.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/address")
public class AddressResource {
    @Autowired
    private AddressRepositoryInterface addressRepositoryInterface;

    @GetMapping("/{id}")
    public Address get(@PathVariable("id") Long id) {
        return this.addressRepositoryInterface.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public AddressRepositoryInterface getAddressRepositoryInterface() {
        return addressRepositoryInterface;
    }

    public void setAddressRepositoryInterface(AddressRepositoryInterface addressRepositoryInterface) {
        this.addressRepositoryInterface = addressRepositoryInterface;
    }
}
