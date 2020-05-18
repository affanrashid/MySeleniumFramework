package com.hubspot.qa.util;


import com.hubspot.qa.base.TestBase;
import com.hubspot.qa.pages.HomePageHubSpot;
import com.hubspot.qa.pages.LoginPageHubSpot;
import com.hubspot.qa.pages.MainPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;



public class Login extends TestBase {

    @FindBy(id="username")
    private WebElement username;

    @FindBy(id="password")
    private WebElement password;

    @FindBy(id="loginBtn")
    private WebElement submitBtn;

    @FindBy(xpath = "//a[@class='cta--secondary cta--small']")
    private WebElement loginBtn;

    @FindBy(id="hs-eu-confirmation-button")
    private WebElement allowCookiesBtn;



    public Login() {
        super();
        PageFactory.initElements(driver, this);
    }



    public HomePageHubSpot logInAs(String str) throws Exception {
        if ("admin".equals(str)) {
            allowCookiesBtn.click();
            loginBtn.click();
            username.sendKeys(prop.getProperty("adminUsername"));
            password.sendKeys(prop.getProperty("adminPassword"));
            submitBtn.click();
            return new HomePageHubSpot();
        } else if ("user1".equals(str)) {
            allowCookiesBtn.click();
            loginBtn.click();
            username.sendKeys((prop.getProperty("")));
            password.sendKeys(prop.getProperty(""));
            submitBtn.click();
            return new HomePageHubSpot();
        }
        throw new Exception("Unable to login");
    }


}