package com.saucedemo.testsuite;

import com.saucedemo.customlisteners.CustomListeners;
import com.saucedemo.pages.LoginPage;
import com.saucedemo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(CustomListeners.class)
public class LoginPageTest extends BaseTest {

    LoginPage loginpage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        loginpage = new LoginPage();
    }

    @Test(groups = {"sanity", "regression"})
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        loginpage.loginToApplication("standard_user", "secret_sauce");

        //Verify the text “PRODUCTS”
        Assert.assertEquals(loginpage.getTextFromProductTitle(), "Products", "Error message-Not matching");

    }

    @Test(groups = {"smoke", "regression"})
    public void verifyThatSixProductsAreDisplayedOnPage()
     {
        //Verify that six products are displayed on page
         loginpage.loginToApplication("standard_user","secret_sauce");
        String expectedNumberOfProducts = "6";
         String actualNumberOfProducts = String.valueOf(loginpage.countProductOnList());
         Assert.assertEquals(actualNumberOfProducts,expectedNumberOfProducts,"total number of products are not displayed");

    }


}
