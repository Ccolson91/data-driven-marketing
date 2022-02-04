package com.brightpaths.datadrivenmarketing.dao;

import com.brightpaths.datadrivenmarketing.dto.ChartData;
import com.brightpaths.datadrivenmarketing.entities.Customer;
import com.brightpaths.datadrivenmarketing.entities.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

    @Override
    public List<Customer> findAll();


    @Query(nativeQuery=true, value = "SELECT first_name AS firstName, last_name AS lastName, COUNT(*) AS value " +
            "FROM customer " +
            "GROUP BY first_name, last_name")
    public List<ChartData> getCustomerStatus();

    void delete(Customer theCust);


    Customer findByCustomerId(long theId);
}