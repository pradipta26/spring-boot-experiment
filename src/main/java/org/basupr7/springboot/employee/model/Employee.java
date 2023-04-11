package org.basupr7.springboot.employee.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

/*
CREATE TABLE `pradipta`.`employee` (
  `emp_id` VARCHAR(10) NOT NULL,
  `first_name` VARCHAR(45) NULL,
  `last_name` VARCHAR(45) NULL,
  `designation` VARCHAR(45) NULL,
  `salary` DECIMAL(10,2) NULL,
  `doj` VARCHAR(10) NULL,
  `sex` VARCHAR(6) NULL,
  PRIMARY KEY (`emp_id`));
 */
@Getter
@Setter
@Entity
@Table(name = "employee")
@NamedQueries({
        @NamedQuery(name = Employee.EMP_REPORT, query = Employee.EMP_REPORT_JPQL)
})
public class Employee {
    public static final String EMP_REPORT = "employeeReport";
    public static final String EMP_REPORT_JPQL =
            "select new org.basupr7.springboot.employee.projection.EmployeeReport(" +
                    "e.firstName, e.lastName, e.designation, e.salary, a.city, a.state) " +
                    "from Employee e, Address a where e.id = :empId " +
                    "and e.address.addressId = a.addressId";

    @Id
    @Column(name = "emp_id")
    private String id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private String designation;
    private long salary;
    private String doj;
    private String sex;

    //@JsonBackReference        // This also works with @JsonManagedReference in Address object
    @ManyToOne
    @JoinColumn(name = "address_id")
    /*
    // use below annotation to avoid circular dependency in serialization
    // This should be matched with list variable name in Address class
     */
    @JsonIgnoreProperties("employees")
    private Address address;

}