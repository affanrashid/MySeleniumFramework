package com.hubspot.qa.testcases;

import com.hubspot.qa.base.TestBase;
import com.hubspot.qa.pages.*;

import com.hubspot.qa.util.CreateContactInfo;
import com.hubspot.qa.util.TestUtil;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class HomePageTest extends TestBase {

    MainPage mainPage;
    LoginPageHubSpot loginPageHubSpot;
    HomePageHubSpot homePageHubSpot;
    ContactsPageHubSpot contactsPageHubSpot;
    CreateContactInfo contact; //Class used to create a user
    ContactInfoPageHubSpot contactInfoPageHubSpot; //POM for the new user created


    public HomePageTest() {
        super();
    }

    @BeforeMethod
    public void setUp() throws InterruptedException {
        initialization();
        //Initializing all the instances of the classes declared above
        mainPage = new MainPage();
        loginPageHubSpot = new LoginPageHubSpot();
        homePageHubSpot = new HomePageHubSpot();
        contactsPageHubSpot = new ContactsPageHubSpot();
        contact = new CreateContactInfo();
        contactInfoPageHubSpot = new ContactInfoPageHubSpot();


        //Login into the website.
        loginPageHubSpot = mainPage.clickLoginBtn();
        homePageHubSpot = loginPageHubSpot.login(prop.getProperty("username"), prop.getProperty("password"));

    }

    @Test(priority = 1)
    public void createNewUser() {
        contactsPageHubSpot = homePageHubSpot.clickContactsOption();
        contactsPageHubSpot.createContact(contact);
        Assert.assertEquals(contactInfoPageHubSpot.verifyHomePageTitle(), contact.getFirstName() + ' ' + contact.getLastName());
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


    @Test(priority = 1, dataProvider = "getDataFromExcel")
    public void createUsersUsingExcelFile(String email, String firstName, String lastName, String jobTitle, String phoneNumber) throws InterruptedException {
        contactsPageHubSpot = homePageHubSpot.clickContactsOption();
        contactsPageHubSpot.createContactWithData(email, firstName, lastName, jobTitle, phoneNumber);
        Assert.assertEquals(contactInfoPageHubSpot.verifyHomePageTitle(), firstName + ' ' + lastName);

    }

  //  @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
