package com.brightpaths.datadrivenmarketing;

import com.brightpaths.datadrivenmarketing.dao.CustomerRepository;
import com.brightpaths.datadrivenmarketing.dao.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class DataDrivenMarketingApplication {

	@Autowired
	EmployeeRepository employeeRepo;

	@Autowired
	CustomerRepository customerRepo;

	public static void main(String[] args) {
		SpringApplication.run(DataDrivenMarketingApplication.class, args);
	}

}
