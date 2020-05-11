package com.hubspot.qa.util;

import com.hubspot.qa.base.TestBase;
import org.apache.commons.lang3.RandomStringUtils;

public class CreateContactInfo extends TestBase {

    private String email, firstName, lastName, jobTitle;
    private int phoneNumber;

    public CreateContactInfo(){
        this.email = String.format(RandomStringUtils.randomAlphanumeric(10)+'@'+ "test.com");
        this.firstName = RandomStringUtils.randomAlphanumeric(7);
        this.lastName = RandomStringUtils.randomAlphanumeric(8);
        this.jobTitle = RandomStringUtils.randomAlphanumeric(10);
        this.phoneNumber = (int)Math.random() * 1000000000;

    }

    //Getters
    public String getEmail(){
        return email;
    }

    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public String getJobTitle(){
        return jobTitle;
    }
    public String getPhoneNumber(){
        return Integer.toString(phoneNumber);
    }

}
