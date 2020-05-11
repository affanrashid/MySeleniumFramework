package com.hubspot.qa.pages;

import com.hubspot.qa.base.TestBase;
import com.hubspot.qa.util.CreateContactInfo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ContactsPageHubSpot extends TestBase {

    @FindBy(xpath="//div[@class='add-control']//span[contains(text(),'Create contact')]")
    private WebElement createContactsBtn;

    @FindBy(xpath = "//input[@data-selenium-test='property-input-email']")
    private WebElement contactEmailInputBox;

    @FindBy(xpath = "//input[@data-selenium-test='property-input-firstname']")
    private WebElement contactFirstNameInputBox;

    @FindBy(xpath = "//input[@data-selenium-test='property-input-lastname']")
    private WebElement contactLastNameInputBox;

    @FindBy(xpath = "//input[@data-selenium-test='property-input-jobtitle']")
    private WebElement contactJobTitleInputBox;

    @FindBy(xpath = "//input[@data-selenium-test='property-input-phone']")
    private WebElement contactPhoneNumberInputBox;

    @FindBy(xpath = "//button[@data-selenium-test='base-dialog-confirm-btn']")
    private WebElement submitBtn;

    public ContactsPageHubSpot() {
        PageFactory.initElements(driver,this);
    }

    public ContactInfoPageHubSpot createContact(CreateContactInfo contact){
        createContactsBtn.click();
        contactEmailInputBox.sendKeys(contact.getEmail());
        contactFirstNameInputBox.sendKeys(contact.getFirstName());
        contactLastNameInputBox.sendKeys(contact.getLastName());
        contactJobTitleInputBox.sendKeys(contact.getJobTitle());
        contactPhoneNumberInputBox.sendKeys(contact.getPhoneNumber());
        submitBtn.click();
        _wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='UIIcon__IconContent-sc-1ngbkfp-0 bZmqko']")));
        return new ContactInfoPageHubSpot();
    }


    public ContactInfoPageHubSpot createContactWithData(String email, String firstName, String lastName, String jobTitle, String phoneNumber) throws InterruptedException {
        createContactsBtn.click();
        contactEmailInputBox.sendKeys(email);
        contactFirstNameInputBox.sendKeys(firstName);
        contactLastNameInputBox.sendKeys(lastName);
        Thread.sleep(1000);
        contactJobTitleInputBox.sendKeys(jobTitle);
        contactPhoneNumberInputBox.sendKeys(phoneNumber);
        submitBtn.click();
        _wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='UIIcon__IconContent-sc-1ngbkfp-0 bZmqko']")));
        return new ContactInfoPageHubSpot();
    }
}
