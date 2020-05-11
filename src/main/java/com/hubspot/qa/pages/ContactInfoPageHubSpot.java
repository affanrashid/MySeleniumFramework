package com.hubspot.qa.pages;

import com.hubspot.qa.base.TestBase;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPageHubSpot extends TestBase {

    public ContactInfoPageHubSpot() {
        PageFactory.initElements(driver, this);
    }

    public String verifyHomePageTitle(){
        return driver.getTitle();
    }
}
