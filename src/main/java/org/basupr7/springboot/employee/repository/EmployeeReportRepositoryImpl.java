package org.basupr7.springboot.employee.repository;

import org.basupr7.springboot.employee.model.Employee;
import org.basupr7.springboot.employee.projection.EmployeeReport;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class EmployeeReportRepositoryImpl implements EmployeeReportRepository{

    @PersistenceContext
    private EntityManager entityManager;

    public EmployeeReport getReportById(String empId) throws Exception {
        try{
            /*
            We can create String query here and execute by createQuery(queryString) here,
            if we want to use JPQL direct invoke instead of namedQuery.
             */
            EmployeeReport employee = (EmployeeReport) entityManager
                    .createNamedQuery(Employee.EMP_REPORT)
                    .setParameter("empId", empId)
                    .getSingleResult();
            return employee;
        }
        catch(javax.persistence.NoResultException ex){
            System.out.println("Error: NoResultException - Employee Not Found!!!");
            throw new Exception("Error: NoResultException - Employee Not Found!!!");
        }
        catch(Exception ex){
            System.out.println("Error: NoResultException - Other Exception!!!");
            throw new Exception("Error: Application Error -> :" + ex.getMessage());
        }


    }
}
