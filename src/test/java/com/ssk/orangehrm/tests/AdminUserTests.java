package com.ssk.orangehrm.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ssk.orangehrm.base.SetupTest;
import com.ssk.orangehrm.pages.AddUserPage;
import com.ssk.orangehrm.pages.AdminUsersPage;
import com.ssk.orangehrm.pages.DashboardPage;
import com.ssk.orangehrm.pages.LoginPage;
import com.ssk.orangehrm.utils.ConfigReader;

public class AdminUserTests extends SetupTest {

    @Test(priority = 1, description = "Verify admin can add a new user successfully")
    public void testAddUser() throws Exception {

        LoginPage login = new LoginPage(driver);
        DashboardPage dashboard = new DashboardPage(driver);

        driver.get(ConfigReader.getProperty("baseUrl"));
        login.enterUsername(ConfigReader.getProperty("username"));
        login.enterPassword(ConfigReader.getProperty("password"));
        login.clickLogin();

        Assert.assertTrue(dashboard.isDashboardLoaded(), "Dashboard not loaded — login failed.");

        // Navigate to Admin
        dashboard.openAdminModule();

        AdminUsersPage admin = new AdminUsersPage(driver);
        admin.clickAddUser();

        // Fill form
        AddUserPage addUser = new AddUserPage(driver);
        addUser.selectUserRole("Admin");
        addUser.selectStatus("Enabled");
        addUser.enterEmployeeName("Belinda Louis Weber Volkman"); // existing employee
        addUser.enterUsername("autoUser" + System.currentTimeMillis());
        addUser.enterPassword("Auto@1234");
        addUser.clickSave();

        Thread.sleep(2000);

        // Validate by searching
        String newUser = "auto";
        admin.searchByUsername(newUser);

        Assert.assertTrue(admin.isUserFound(), "Newly added user not found in search results.");
    }

    @Test(priority = 2, description = "Verify admin can search for an existing user")
    public void testSearchUser() {

        LoginPage login = new LoginPage(driver);
        DashboardPage dashboard = new DashboardPage(driver);

        driver.get(ConfigReader.getProperty("baseUrl"));
        login.enterUsername(ConfigReader.getProperty("username"));
        login.enterPassword(ConfigReader.getProperty("password"));
        login.clickLogin();

        Assert.assertTrue(dashboard.isDashboardLoaded(), "Dashboard not loaded — login failed.");

        dashboard.openAdminModule();

        AdminUsersPage admin = new AdminUsersPage(driver);

        admin.searchByUsername("Admin");

        Assert.assertTrue(admin.isUserFound(), "Admin user not found.");
    }
}

