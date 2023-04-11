package org.basupr7.springboot.employee.service;

import org.basupr7.springboot.employee.model.Address;

import java.util.List;

public interface AddressService {

    public String save(Address address);
    List<Address> findAll();
    public Address find(Long addressId);
}
