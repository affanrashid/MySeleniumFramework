package com.hubspot.qa.pages;

import com.hubspot.qa.base.TestBase;
import com.hubspot.qa.pages.HomePageHubSpot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPageHubSpot extends TestBase {

    @FindBy(id="username")
    private WebElement username;

    @FindBy(id="password")
    private WebElement password;

    @FindBy(id="loginBtn")
    private WebElement loginBtn;

    public LoginPageHubSpot() {
        PageFactory.initElements(driver, this);
    }

    public HomePageHubSpot login(String un, String pwd) throws InterruptedException {
        _wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
        username.sendKeys(un);
        password.sendKeys(pwd);
        loginBtn.click();
        return new HomePageHubSpot();
    }

}
