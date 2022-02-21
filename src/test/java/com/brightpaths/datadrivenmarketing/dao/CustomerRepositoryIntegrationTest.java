package com.brightpaths.datadrivenmarketing.dao;


import com.brightpaths.datadrivenmarketing.entities.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@SpringBootTest
@RunWith(SpringRunner.class)
//@DataJpaTest
@SqlGroup({@Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = {"classpath:schema.sql", "classpath:import.sql"}), @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:drop.sql")})
public class CustomerRepositoryIntegrationTest {

    @Autowired
    CustomerRepository customerRepo;

    @Test
    public void ifNewCustomerSaved_thenSuccess() {
        Customer newCustomer = new Customer("New Test", "Customer", "8888888888", "newtest@customer.com");
        customerRepo.save(newCustomer);

        assertEquals(8, customerRepo.findAll().size());
    }

}
