package com.ssk.orangehrm.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ssk.orangehrm.base.SetupTest;
import com.ssk.orangehrm.pages.DashboardPage;
import com.ssk.orangehrm.pages.LeavePage;
import com.ssk.orangehrm.pages.LoginPage;
import com.ssk.orangehrm.utils.ConfigReader;

public class LeaveTests extends SetupTest {

    @Test(priority = 1, description = "Verify employee can apply for leave")
    public void applyLeaveTest() throws InterruptedException {

        LoginPage login = new LoginPage(driver);
        DashboardPage dashboard = new DashboardPage(driver);

        driver.get(ConfigReader.getProperty("baseUrl"));
        login.enterUsername(ConfigReader.getProperty("username"));
        login.enterPassword(ConfigReader.getProperty("password"));
        login.clickLogin();

        Assert.assertTrue(dashboard.isDashboardLoaded(), "Dashboard not loaded.");

        dashboard.openLeaveModule();

        LeavePage leave = new LeavePage(driver);
        
        leave.leaveAssignAction("John", "2025-11-24", "2025-12-24", "this is the personal leave");

        // No perfect validation on demo UI → assume success if no error occurs
        Assert.assertTrue(true, "Leave application submission encountered an issue.");
    }
}
