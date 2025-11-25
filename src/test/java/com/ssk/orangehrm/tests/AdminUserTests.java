package com.ssk.orangehrm.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.ssk.orangehrm.base.SetupTest;
import com.ssk.orangehrm.pages.AdminUsersPage;
import com.ssk.orangehrm.pages.DashboardPage;
import com.ssk.orangehrm.pages.LoginPage;
import com.ssk.orangehrm.utils.ConfigReader;


public class AdminUserTests extends SetupTest {

	@Test(priority = 1, description = "Verify admin can add new User successfully")
	public void testAddUser() throws Exception {

		LoginPage login = new LoginPage(driver);
		DashboardPage dashboard = new DashboardPage(driver);
		
		//Admin login
		driver.get(ConfigReader.getProperty("baseUrl"));
		login.loginUser(ConfigReader.getProperty("username"), ConfigReader.getProperty("password"));

		Assert.assertTrue(dashboard.isDashboardLoaded(), "Dashboard not loaded — login failed.");

		// Navigate to Admin
		dashboard.openAdminModule();

		AdminUsersPage adminUsersPage = new AdminUsersPage(driver);

		//add new user and verify
		adminUsersPage.clickAddUser();

		adminUsersPage.enterNewUserDetails("Admin", "John", "Disabled","test", "test");	
	}

	@Test(priority = 2, description = "Verify admin can search for an existing user")
	public void testSearchUser() {

		LoginPage login = new LoginPage(driver);
		DashboardPage dashboard = new DashboardPage(driver);

		driver.get(ConfigReader.getProperty("baseUrl"));
		login.loginUser(ConfigReader.getProperty("username"), ConfigReader.getProperty("password"));

		dashboard.openAdminModule();

		AdminUsersPage admin = new AdminUsersPage(driver);

		admin.searchByUsername("Admin");

		Assert.assertTrue(admin.isUserFound(), "Admin user not found.");
	}

}

