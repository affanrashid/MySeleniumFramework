package com.hubspot.qa.pages;

import com.hubspot.qa.base.TestBase;
import com.hubspot.qa.pages.LoginPageHubSpot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends TestBase {

    @FindBy(xpath = "//a[@class='cta--secondary cta--small']")
    private WebElement loginBtn;

    @FindBy(id="hs-eu-confirmation-button")
    private WebElement allowCookiesBtn;

    public MainPage(){
        PageFactory.initElements(driver, this);
    }

    public LoginPageHubSpot clickLoginBtn(){
        allowCookiesBtn.click();
        loginBtn.click();
        return new LoginPageHubSpot();
    }
}
