package com.brightpaths.datadrivenmarketing.controllers;

import com.brightpaths.datadrivenmarketing.dao.CustomerRepository;
import com.brightpaths.datadrivenmarketing.dao.EmployeeRepository;
import com.brightpaths.datadrivenmarketing.dto.ContactResponse;
import com.brightpaths.datadrivenmarketing.dto.CustomerContactInfo;
import com.brightpaths.datadrivenmarketing.dto.CustomerTag;
import com.brightpaths.datadrivenmarketing.dto.SingleCustomer;
import com.brightpaths.datadrivenmarketing.entities.Customer;
import com.brightpaths.datadrivenmarketing.entities.Employee;
import com.brightpaths.datadrivenmarketing.services.CustomerService;
import com.brightpaths.datadrivenmarketing.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    CustomerRepository customerRepo;

    @Autowired
    EmployeeRepository employeeRepo;

    @Autowired
    CustomerService customerService;

    @Autowired
    EmployeeService employeeService;


    @GetMapping
    public String displayCustomers(Model model) {
        List<Customer> customers = customerService.findAll();
        model.addAttribute("customers", customers);
        return "customers/list-customers";
    }

    @GetMapping("/new")
    public String displayCustomerForm(Model model){
        Customer singleCustomer = new Customer();
        Iterable<Employee> employees = employeeService.getAll();
        model.addAttribute("singleCustomer", singleCustomer);
        model.addAttribute("allEmployees", employees);
        return "customers/new-customer";
    }

    @PostMapping("/save")
    public String createCustomer(Customer customer, Model model) {

        CustomerContactInfo contactInfo = new CustomerContactInfo();

        contactInfo.setEmail(customer.getEmail());
        contactInfo.setFirstName(customer.getFirstName());
        contactInfo.setLastName(customer.getLastName());
        contactInfo.setPhone((customer.getPhoneNumber()));
        contactInfo.setHairColor(customer.getHairColor());

        SingleCustomer singleCustomer = new SingleCustomer();

        singleCustomer.setContact(contactInfo);

        HttpHeaders headers = new HttpHeaders();

        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.set("Api-Token", "8b58f7a664289ab530a593108a10744ac9a0763f5b9fce7d8efbe656777dd1184297eec9");
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<SingleCustomer> requestEntity = new HttpEntity<>(singleCustomer, headers);


        RestTemplate restTemplate = new RestTemplate();
        ContactResponse response = restTemplate.postForObject("https://hometownpromotionsllc.api-us1.com/api/3/contacts", requestEntity, ContactResponse.class);

//        CustomerTag customerTag = new CustomerTag();
//        CustomerContactInfo customerContactInfo = new CustomerContactInfo();
//
//        customerTag.addContactIdAndTagId(response.getId(), "37");
//
//        HttpHeaders addTagHeaderRequest = new HttpHeaders();
//
//        addTagHeaderRequest.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
//        addTagHeaderRequest.set("Api-Token", "8b58f7a664289ab530a593108a10744ac9a0763f5b9fce7d8efbe656777dd1184297eec9");
//        headers.setContentType(MediaType.APPLICATION_JSON);
//
//        HttpEntity<CustomerTag> tagRequestEntity = new HttpEntity<>(customerTag, addTagHeaderRequest);
//
//        ContactResponse tagResponse = restTemplate.postForObject("https://hometownpromotionsllc.api-us1.com/api/3/contactsTags", tagRequestEntity, ContactResponse.class);

        customerService.save(customer);

        return "redirect:/customers";
    }

    @GetMapping("/update")
    public String displayCustomerUpdateForm(@RequestParam("id") long theId, Model model) {

        Customer theCust = customerService.findByCustomerId(theId);
        model.addAttribute("customer", theCust);

        return "customers/update-customer";
    }

    @PostMapping("/{id}/update")
    public String updateCustomer(@PathVariable("id") long theId, Model model, Customer customer) {
        Customer theCust = customerService.findByCustomerId(theId);
        theCust.setFirstName(customer.getFirstName());
        theCust.setLastName(customer.getLastName());
        theCust.setPhoneNumber(customer.getPhoneNumber());
        theCust.setEmail(customer.getEmail());
        theCust.setHairColor(customer.gethairColor());
        customerService.save(theCust);

        return "redirect:/customers";

    }

    @GetMapping("delete")
    public String deleteCustomer(@RequestParam("id") long theId, Model model) {
        Customer theCust = customerService.findByCustomerId(theId);
        customerService.delete(theCust);
        return "redirect:/customers";
    }

    @GetMapping("/list")
    public String displayCustomerList(Model model) {
        List<Customer> customers = customerService.findAll();
        model.addAttribute("customerList", customers);
        return "customers/list-customers";
    }
}
