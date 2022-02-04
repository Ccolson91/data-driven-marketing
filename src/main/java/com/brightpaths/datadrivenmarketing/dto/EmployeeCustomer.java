package com.brightpaths.datadrivenmarketing.dto;

public interface EmployeeCustomer {
    // property names begin with get so spring knows to get properties from dao file using the custom sql query

    public String getFirstName();
    public String getLastName();
    public int getCustomerCount();

}

