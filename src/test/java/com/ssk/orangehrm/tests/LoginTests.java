package com.ssk.orangehrm.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ssk.orangehrm.base.SetupTest;
import com.ssk.orangehrm.pages.DashboardPage;
import com.ssk.orangehrm.pages.LoginPage;
import com.ssk.orangehrm.utils.ConfigReader;

public class LoginTests extends SetupTest {

    @Test(priority = 1, description = "Verify login with valid credentials")
    public void validLoginTest() {

        LoginPage login = new LoginPage(driver);
        DashboardPage dashboard = new DashboardPage(driver);

        driver.get(ConfigReader.getProperty("baseUrl"));

        login.enterUsername(ConfigReader.getProperty("username"));
        login.enterPassword(ConfigReader.getProperty("password"));
        login.clickLogin();

        Assert.assertTrue(dashboard.isDashboardLoaded(), "Valid login failed.");
    }

    @Test(priority = 2, description = "Verify login with invalid credentials")
    public void invalidLoginTest() {
    	System.out.println("checking the invalid cred");
        LoginPage login = new LoginPage(driver);

        driver.get(ConfigReader.getProperty("baseUrl"));
        System.out.println("entring the cred");
        login.enterUsername("wrongUser");
        login.enterPassword("WrongPass");
        login.clickLogin();

        Assert.assertTrue(login.isLoginErrorVisible(), "Error message not visible for invalid login.");
    }
}
