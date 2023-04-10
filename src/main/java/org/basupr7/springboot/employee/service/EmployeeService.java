package org.basupr7.springboot.employee.service;

import org.basupr7.springboot.employee.model.Address;
import org.basupr7.springboot.employee.model.Employee;
import org.basupr7.springboot.employee.projection.EmployeeReport;

public interface EmployeeService {


    String addEmployee(Employee employee);
    public Employee find(String id) throws Exception;
    public String getReportById(String empId);
}
