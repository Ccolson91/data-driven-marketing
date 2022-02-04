package com.brightpaths.datadrivenmarketing.services;

import com.brightpaths.datadrivenmarketing.dao.CustomerRepository;
import com.brightpaths.datadrivenmarketing.dto.ChartData;
import com.brightpaths.datadrivenmarketing.entities.Customer;
import com.brightpaths.datadrivenmarketing.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepo;


    public Customer save(Customer customer) {
        return customerRepo.save(customer);
    }


    public List<Customer> getAll() {
        return customerRepo.findAll();
    }

    public List<ChartData> getCustomerStatus(){
        return customerRepo.getCustomerStatus();
    }

    public void delete(Customer theCust) {
        customerRepo.delete(theCust);
    }

    public Customer findByCustomerId(long theId) {
        return customerRepo.findByCustomerId(theId);
    }

    public List<Customer> findAll() {
        return customerRepo.findAll();
    }


//    public List<TimeChartData> getTimeData(){
//        return customerRepo.getTimeData();
//    }
}