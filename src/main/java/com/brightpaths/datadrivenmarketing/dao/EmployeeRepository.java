package com.brightpaths.datadrivenmarketing.dao;

import com.brightpaths.datadrivenmarketing.dto.ChartData;
import com.brightpaths.datadrivenmarketing.dto.EmployeeCustomer;
import com.brightpaths.datadrivenmarketing.entities.Employee;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

    @Override
    public List<Employee> findAll();

    @Query(nativeQuery=true, value = "SELECT e.first_name AS firstName, e.last_name AS lastName, COUNT(ce.employee_id) AS customerCount " +
            "FROM employee e LEFT JOIN customer_employee ce ON ce.employee_id = e.employee_id " +
            "GROUP BY e.first_name, e.last_name " +
            "ORDER BY 3 DESC")
    public List<EmployeeCustomer> employeeCustomers();

//    @Modifying
//    @Query(nativeQuery=true, value= "DELETE FROM employee e " +
//            "WHERE e.employee_id = :employee_id " +
//            "GROUP BY e.employee_id, e.first_name, e.last_name " +
//            "ORDER BY 3 DESC")

    //    @Query(nativeQuery=true, value = "SELECT e.first_name AS firstName, e.last_name AS lastName, COUNT(*) AS value " +
//            "FROM employee e " +
//            "GROUP BY e.first_name, e.last_name")
    @Query(nativeQuery=true, value = "SELECT first_name AS firstName, last_name AS lastName, COUNT(*) AS value " +
            "FROM employee " +
            "GROUP BY first_name, last_name")
    void delete(Employee theEmp);


    public Employee findByEmail(String value);

    public Employee findByEmployeeId(long theId);
}