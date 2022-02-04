package com.brightpaths.datadrivenmarketing.controllers;

import com.brightpaths.datadrivenmarketing.dao.CustomerRepository;
import com.brightpaths.datadrivenmarketing.dao.EmployeeRepository;
import com.brightpaths.datadrivenmarketing.dto.ChartData;
import com.brightpaths.datadrivenmarketing.dto.EmployeeCustomer;
import com.brightpaths.datadrivenmarketing.entities.Customer;
import com.brightpaths.datadrivenmarketing.entities.Employee;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class HomeController {



    @Autowired
    CustomerRepository customerRepo;

    @Autowired
    EmployeeRepository employeeRepo;

    @GetMapping("/")
    public String displayHome(Model model) throws JsonProcessingException {


        Map<String, Object> map = new HashMap<>();

        // querying the DB for customers
        List<Customer> customers = customerRepo.findAll();
        model.addAttribute("customersList", customers);

        List<ChartData> customerData = customerRepo.getCustomerStatus();

//        // convert projectData object into a JSON structure for use in javascript
//        ObjectMapper objectMapper = new ObjectMapper();
//        String jsonString = objectMapper.writeValueAsString(customerData);
//
//
//        model.addAttribute("employeeStatusCount", jsonString);

        // querying the DB for employees
//        List<Employee> employees = employeeRepo.findAll();
//        model.addAttribute("employeesList", employees);

//        Querying the DB for the Employee Customer Count
        List<EmployeeCustomer> employeesCustomerCount = employeeRepo.employeeCustomers();
        model.addAttribute("employeesListCustomersCount", employeesCustomerCount);

        return "main/home";
    }
}
