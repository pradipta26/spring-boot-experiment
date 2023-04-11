package org.basupr7.springboot.employee.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ManyToAny;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/*
CREATE TABLE `pradipta`.`address` (
  `address_id` INT NOT NULL,
  `houseNumber` VARCHAR(45) NULL,
  `street` VARCHAR(45) NULL,
  `city` VARCHAR(45) NULL,
  `state` VARCHAR(45) NULL,
  `postal_code` INT NULL);
  ALTER TABLE `pradipta`.`address` ADD PRIMARY KEY (`address_id`);
;
 */
@Getter
@Setter
@Entity
@Table(name="address")
//@SequenceGenerator(name="seq", initialValue=1, allocationSize=10000)
public class Address {
    @Id
    @Column(name="address_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    // below code does the same thing but can be customized
    //@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq")
    private long addressId;
    @Column(name = "house_number")
    private int houseNumber;
    private String street;
    private String city;
    private String state;
    @Column(name = "postal_code", length = 5, nullable = false, unique = false)
    private int zip;

    // @JsonManagedReference
    @OneToMany(mappedBy = "address", fetch = FetchType.LAZY) //, fetch = FetchType.EAGER, cascade = CascadeType.ALL
    /*
      use below annotation to avoid circular dependency in serialization
      This should be matched with list variable name in Address class
     */
    @JsonIgnoreProperties("address")
    private List<Employee> employees;

}
