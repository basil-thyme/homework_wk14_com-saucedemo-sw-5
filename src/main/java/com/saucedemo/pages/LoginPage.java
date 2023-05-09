package com.saucedemo.pages;

import com.aventstack.extentreports.Status;
import com.saucedemo.customlisteners.CustomListeners;
import com.saucedemo.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.util.List;

public class LoginPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//input[@id='user-name']")
    WebElement usernameField;

    @CacheLookup
    @FindBy(xpath = "//input[@id='password']")
    WebElement passwordField;

    @CacheLookup
    @FindBy(xpath = "//input[@id='login-button']")
    WebElement loginButton;

    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'Products')]")
    WebElement productTitleText;


    public void enterUserName(String userName) {
        Reporter.log("Enter username " + userName + " to username field " + usernameField.toString());
        CustomListeners.test.log(Status.PASS, "Enter username " + userName);
        sendTextToElement(usernameField, userName);
    }

    public void enterPassword(String password) {
        Reporter.log("Enter password " + password + " to password field " + passwordField.toString());
        CustomListeners.test.log(Status.PASS, "Enter password " + password);
        sendTextToElement(passwordField, password);
    }

    public void clickOnLoginButton() {
        Reporter.log("Clicking on Login Button " + loginButton.toString());
        CustomListeners.test.log(Status.PASS, "Click on loginButton");
        clickOnElement(loginButton);
    }

    public void loginToApplication(String username, String password) {
        enterUserName(username);
        enterPassword(password);
        clickOnLoginButton();
    }

    public String getTextFromProductTitle() {
        Reporter.log("Get text from product title");
        CustomListeners.test.log(Status.PASS, "Get error message");
        return getTextFromElement(productTitleText);
    }

    public int countProductOnList() {
        Reporter.log("Count Total no of products");
        CustomListeners.test.log(Status.PASS, "Get error message");
        List<WebElement> productsList = driver.findElements(By.className("inventory_item_label"));
        return productsList.size();
    }


}
