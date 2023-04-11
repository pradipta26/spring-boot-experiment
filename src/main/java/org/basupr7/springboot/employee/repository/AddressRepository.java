package org.basupr7.springboot.employee.repository;


import org.basupr7.springboot.employee.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> { }
