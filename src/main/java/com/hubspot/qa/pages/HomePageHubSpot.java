package com.hubspot.qa.pages;

import com.hubspot.qa.base.TestBase;
import com.hubspot.qa.pages.ContactsPageHubSpot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageHubSpot extends TestBase {

    @FindBy (id="nav-primary-contacts-branch")
    private WebElement contactsDropDown;

    @FindBy (id="nav-secondary-contacts")
    private WebElement contactsOption;


    public HomePageHubSpot() {
        PageFactory.initElements(driver, this);
    }

    public ContactsPageHubSpot clickContactsOption(){
        contactsDropDown.click();
        contactsOption.click();
        return new ContactsPageHubSpot();
    }
}
