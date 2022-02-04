package com.brightpaths.datadrivenmarketing.dto;

import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("contact")
public class CustomerContactInfo {
    private String firstName;
    private String lastName;

    //@JsonProperty(override name as the API refers to it)
    private String phone;
    private String email;
    private String hairColor;


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

//    public CustomerContactInfo getHairColor() {
//        return hairColor;
//    }

    public void setHairColor(String hairColor) {
        this.hairColor = hairColor;
    }
}

