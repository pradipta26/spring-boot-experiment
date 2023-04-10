package org.basupr7.springboot.employee.repository;

import org.basupr7.springboot.employee.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String>, EmployeeReportRepository {

}
