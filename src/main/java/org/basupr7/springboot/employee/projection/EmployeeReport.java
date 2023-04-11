package org.basupr7.springboot.employee.projection;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeReport {
    private String firstName;
    private String lastName;
    private String designation;
    private long salary;
    private String city;
    private String state;
}
