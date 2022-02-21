package com.brightpaths.datadrivenmarketing.controllers;

import com.brightpaths.datadrivenmarketing.dao.EmployeeRepository;
import com.brightpaths.datadrivenmarketing.entities.Employee;
import com.brightpaths.datadrivenmarketing.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;


    @GetMapping
    public String displayEmployees(Model model) {
        Iterable<Employee> employees = employeeService.getAll();
        model.addAttribute("employeesList", employees);
        return "employees/list-employees";
    }

    @GetMapping("/new")
    public String displayEmployeeForm(Model model) {
        Employee singleEmployee = new Employee();
        model.addAttribute("employee", singleEmployee);
        return "employees/new-employees";
    }

    @PostMapping("/save")
    public String createEmployeeForm(Employee employee, Model model) {
        employeeService.save(employee);
        return "redirect:/employees";
    }

    @GetMapping("/update")
    public String displayEmployeeUpdateForm(@RequestParam("id") long theId, Model model) {

        Employee theEmp = employeeService.findByEmployeeId(theId);
        model.addAttribute("employee", theEmp);

        return "employees/update-employee";
    }

    @PostMapping("/{id}/update")
    public String updateEmployee(@PathVariable("id") long theId, Model model, Employee employee) {
        Employee theEmp = employeeService.findByEmployeeId(theId);
        theEmp.setFirstName(employee.getFirstName());
        theEmp.setLastName(employee.getLastName());
        theEmp.setEmail(employee.getEmail());
        employeeService.save(theEmp);

        return "redirect:/employees";

    }

    @GetMapping("/delete")
    public String deleteEmployee(@RequestParam("id") long theId, Model model) {
        Employee theEmp = employeeService.findByEmployeeId(theId);
        employeeService.delete(theEmp);
        return "redirect:/employees";
    }

}