package com.brightpaths.datadrivenmarketing.services;

import java.util.List;


import com.brightpaths.datadrivenmarketing.dao.EmployeeRepository;
import com.brightpaths.datadrivenmarketing.dto.EmployeeCustomer;
import com.brightpaths.datadrivenmarketing.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepo;


    public Employee save(Employee employee) {
        return employeeRepo.save(employee);
    }


    public Iterable<Employee> getAll() {
        return employeeRepo.findAll();
    }


    public List<EmployeeCustomer> employeeProjects() {
        return employeeRepo.employeeCustomers();
    }


    public Employee findByEmployeeId(long theId) {
        // TODO Auto-generated method stub
        return employeeRepo.findByEmployeeId(theId);
    }


    public void delete(Employee theEmp) {
        employeeRepo.delete(theEmp);

    }

}