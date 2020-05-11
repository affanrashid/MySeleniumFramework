package com.hubspot.qa.testcases;

import com.hubspot.qa.pages.HomePageHubSpot;
import com.hubspot.qa.pages.LoginPageHubSpot;
import com.hubspot.qa.pages.MainPage;
import com.hubspot.qa.base.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTest extends TestBase {
    MainPage mainPage;
    LoginPageHubSpot loginPageHubSpot;
    HomePageHubSpot homePageHubSpot;

    public LoginPageTest() {
        super();
    }

    @BeforeMethod
    public void setUp(){
        initialization();
        mainPage = new MainPage();
        loginPageHubSpot = new LoginPageHubSpot();
        homePageHubSpot = new HomePageHubSpot();
        loginPageHubSpot = mainPage.clickLoginBtn();

    }

    @Test(priority = 1)
    public void loginTest() throws InterruptedException {
        homePageHubSpot = loginPageHubSpot.login(prop.getProperty("username"), prop.getProperty("password"));

    }




}
