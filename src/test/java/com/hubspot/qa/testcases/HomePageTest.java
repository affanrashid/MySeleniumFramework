package com.hubspot.qa.testcases;

import com.hubspot.qa.base.TestBase;
import com.hubspot.qa.pages.*;

import com.hubspot.qa.util.CreateContactInfo;
import com.hubspot.qa.util.Login;
import com.hubspot.qa.util.TestUtil;
import org.apache.log4j.lf5.viewer.LogFactor5InputDialog;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class HomePageTest extends TestBase {

    MainPage mainPage;
    LoginPageHubSpot loginPageHubSpot;
    HomePageHubSpot homePageHubSpot;
    ContactsPageHubSpot contactsPageHubSpot;
    //Class used to create a user
    ContactInfoPageHubSpot contactInfoPageHubSpot; //POM for the new user created
    Login login;


    public HomePageTest() {
        super();

    }

    @BeforeMethod
    public void setUp() throws Exception {
        initialization();
        login = new Login();
        homePageHubSpot = login.logInAs("admin");

    }

    @Test(priority = 1)
    public void createNewUser() throws InterruptedException {
        CreateContactInfo contact = new CreateContactInfo(); // Instantiating a new class to create a random contact
        contactInfoPageHubSpot = new ContactInfoPageHubSpot();
        contactsPageHubSpot = homePageHubSpot.clickContactsOption();
        contactsPageHubSpot.createContact(contact);
        System.out.println(contactInfoPageHubSpot.getContactsPageTitle());
        System.out.println(contact.getFirstName() + ' ' + contact.getLastName());
        Assert.assertEquals(contactInfoPageHubSpot.getContactsPageTitle(), contact.getFirstName() + ' ' + contact.getLastName());
    }

    //Data driven test case
    //I am creating a string that contains the name of the sheet where the data is stored in the excel file
    //I pass the sheet to the .getTestData method which will open the excel file, look at the sheet, and extract all the data from each of the rows and columns
    //into a 2D array.
    @DataProvider
    public Object [][] getDataFromExcel() {
        String excelSheetName = "Sheet1";
        Object data[][] = TestUtil.getTestData(excelSheetName);
        return data;
    }


    @Test(priority = 2, dataProvider = "getDataFromExcel")
    public void createUsersUsingExcelFile(String email, String firstName, String lastName, String jobTitle, String phoneNumber) throws InterruptedException {
        contactsPageHubSpot = homePageHubSpot.clickContactsOption();
        contactsPageHubSpot.createContactWithData(email, firstName, lastName, jobTitle, phoneNumber);
        Assert.assertEquals(contactInfoPageHubSpot.getContactsPageTitle(), firstName + ' ' + lastName);


    }

    //  @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}