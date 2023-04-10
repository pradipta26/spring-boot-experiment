package org.basupr7.springboot.employee.service;

import org.basupr7.springboot.employee.model.Employee;
import org.basupr7.springboot.employee.projection.EmployeeReport;
import org.basupr7.springboot.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository empRepository;

    @Override
    @Transactional
    public String addEmployee(Employee employee) {
        if(empRepository.findById(employee.getId()).isPresent())
            return "Employee " + employee.getId() + " already exist!";
        empRepository.save(employee);
        return "Employee " + employee.getId() + " created!!!";
    }
    @Override
    @Transactional
    public Employee find(String id) throws Exception{
        System.out.println("Service is looking for Employee id == " + id);
        Optional<Employee> employee = empRepository.findById(id);
        if(employee.isPresent())
            return empRepository.findById(id).get();
        else throw new Exception("Employee not found!!!");
    }
    public String getReportById(String empId) {
        try{
            EmployeeReport empReport = empRepository.getReportById(empId);
            ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
            return ow.writeValueAsString(empReport);
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }
}
