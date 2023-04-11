package org.basupr7.springboot.employee.repository;

import org.basupr7.springboot.employee.projection.EmployeeReport;

public interface EmployeeReportRepository {
    public EmployeeReport getReportById(String empId) throws Exception;
}
