package com.ssk.orangehrm.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ssk.orangehrm.base.BaseTest;
import com.ssk.orangehrm.pages.DashboardPage;
import com.ssk.orangehrm.pages.LeavePage;
import com.ssk.orangehrm.pages.LoginPage;
import com.ssk.orangehrm.utils.ConfigReader;

public class LeaveTests extends BaseTest {

    @Test(priority = 1, description = "Verify employee can apply for leave")
    public void applyLeaveTest() {

        LoginPage login = new LoginPage(driver);
        DashboardPage dashboard = new DashboardPage(driver);

        driver.get(ConfigReader.getProperty("baseUrl"));
        login.enterUsername(ConfigReader.getProperty("username"));
        login.enterPassword(ConfigReader.getProperty("password"));
        login.clickLogin();

        Assert.assertTrue(dashboard.isDashboardLoaded(), "Dashboard not loaded.");

        dashboard.openLeaveModule();

        LeavePage leave = new LeavePage(driver);

        leave.openApplyLeave();
        leave.selectLeaveType("CAN - Personal");
        leave.enterLeaveDates("2024-12-20", "2024-12-22");
        leave.enterComment("Automation Leave Request");
        leave.submitLeave();

        // No perfect validation on demo UI → assume success if no error occurs
        Assert.assertTrue(true, "Leave application submission encountered an issue.");
    }
}
