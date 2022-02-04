package com.brightpaths.datadrivenmarketing.dao;

import com.brightpaths.datadrivenmarketing.dto.ChartData;
import com.brightpaths.datadrivenmarketing.dto.EmployeeCustomer;
import com.brightpaths.datadrivenmarketing.entities.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

    @Override
    public List<Employee> findAll();

    @Query(nativeQuery=true, value = "SELECT e.first_name AS firstName, e.last_name AS lastName, COUNT(ce.employee_id) AS customerCount " +
            "FROM employee e LEFT JOIN customer_employee ce ON ce.employee_id = e.employee_id " +
            "GROUP BY e.first_name, e.last_name " +
            "ORDER BY 3 DESC")
    public List<EmployeeCustomer> employeeCustomers();


    public Employee findByEmail(String value);

   public Employee findByEmployeeId(long theId);
}