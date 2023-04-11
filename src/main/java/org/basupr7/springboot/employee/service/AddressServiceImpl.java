package org.basupr7.springboot.employee.service;

import org.basupr7.springboot.employee.model.Address;
import org.basupr7.springboot.employee.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.commons.collections4.IterableUtils;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    private AddressRepository addressRepository;

    @Override
    @Transactional
    public String save(Address address) {
        Address newAddress = addressRepository.save(address);
        return "New address created with ID " + newAddress.getAddressId();
    }

    @Override
    public List<Address> findAll() {
        return IterableUtils.toList(addressRepository.findAll());
    }

    @Override
    public Address find(Long addressId) {
        return addressRepository.findById(addressId).get();
    }
}
