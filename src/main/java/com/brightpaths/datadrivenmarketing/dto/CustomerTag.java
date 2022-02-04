package com.brightpaths.datadrivenmarketing.dto;

import java.util.HashMap;
import java.util.Map;

public class CustomerTag {


    private CustomerContactInfo contactInfo;

    public CustomerContactInfo getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(CustomerContactInfo contactInfo) {
        this.contactInfo = contactInfo;
    }

    private Map<String, String> contactTag = new HashMap<String, String>();

    public void addContactIdAndTagId(String tagInfo, String contactInfo) {
        contactTag.put(tagInfo, contactInfo);
    }

}
