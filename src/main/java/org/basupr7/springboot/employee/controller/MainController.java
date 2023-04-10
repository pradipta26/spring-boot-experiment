package org.basupr7.springboot.employee.controller;

import org.basupr7.springboot.employee.model.Address;
import org.basupr7.springboot.employee.model.Employee;
import org.basupr7.springboot.employee.projection.EmployeeReport;
import org.basupr7.springboot.employee.service.AddressService;
import org.basupr7.springboot.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class MainController {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private AddressService addressService;
    // curl -X POST localhost:8080/employee -H 'Content-type:application/json' -d '{"id": "nj004","firstName": "Abhinanda", "lastName": "Basu", "salary": "13000", "city": "Hubakan","doj": "08/24/2014","sex": "female"}'
    @PostMapping("/employee")
    //@RequestMapping(value = "/employees", method = RequestMethod.POST)
    //@ResponseStatus(HttpStatus.OK)
    String newEmployee(@RequestBody Employee newEmployee) {
        System.out.println("Main Controller is called for EmpId : " + newEmployee.getId());
        return employeeService.addEmployee(newEmployee);
    }

    //curl -X GET localhost:8080/get-employee/nj001
    @GetMapping("/get-employee/{id}")
    Employee getEmployeeById(@PathVariable String id)  throws Exception{
        System.out.println("Main Controller is called for searching employee " + id );
        return employeeService.find(id);
    }

    @PostMapping("/address")
    String addAddress(@RequestBody Address address) {
        System.out.println("Main Controller is called for address insertion..." );
        return addressService.save(address);
    }

    //curl -X GET localhost:8080/get-address/1
    @GetMapping("/get-address/{addressId}")
    Address getAddressById(@PathVariable Long addressId) {
        return addressService.find(addressId);
    }

    @GetMapping("/employee-report/{empId}")
    String employeeReport(@PathVariable String empId){
        System.out.println("Processing employee report for #" + empId);
        return employeeService.getReportById(empId);
    }
}


