package com.ssk.orangehrm.tests;

import java.util.Random;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.ssk.orangehrm.base.SetupTest;
import com.ssk.orangehrm.pages.AddEmployeePage;
import com.ssk.orangehrm.pages.DashboardPage;
import com.ssk.orangehrm.pages.EmployeeListPage;
import com.ssk.orangehrm.pages.LoginPage;
import com.ssk.orangehrm.utils.ConfigReader;

public class PIMTests extends SetupTest {

	@Test(priority = 1, description = "Verify adding a new employee")
	public void addEmployeeTest() throws InterruptedException {

		LoginPage login = new LoginPage(driver);
		DashboardPage dashboard = new DashboardPage(driver);

		driver.get(ConfigReader.getProperty("baseUrl"));
		login.loginUser(ConfigReader.getProperty("username"), ConfigReader.getProperty("password"));

		Assert.assertTrue(dashboard.isDashboardLoaded(), "Dashboard did not load.");

		dashboard.openPIMModule();

		EmployeeListPage pim = new EmployeeListPage(driver);
		pim.clickAddEmployee();

		AddEmployeePage addEmp = new AddEmployeePage(driver);

		String fName = "Auto" + System.currentTimeMillis();
		addEmp.enterEmployeeDetails(fName, "Test", "User", "ID" + new Random().nextInt(1000));
		addEmp.saveEmployee();

		Thread.sleep(4000);

		dashboard.openPIMModule();

		pim.searchEmployeeByName(fName);

		Assert.assertTrue(pim.isEmployeeFound(), "Employee not found in the list!");
	}

	@Test(priority = 2, description = "Verify searching an employee")
	public void searchEmployeeTest() {

		LoginPage login = new LoginPage(driver);
		DashboardPage dashboard = new DashboardPage(driver);

		driver.get(ConfigReader.getProperty("baseUrl"));
		login.loginUser(ConfigReader.getProperty("username"), ConfigReader.getProperty("password"));

		Assert.assertTrue(dashboard.isDashboardLoaded(), "Dashboard did not load.");

		dashboard.openPIMModule();

		EmployeeListPage pim = new EmployeeListPage(driver);
		pim.searchEmployeeByName("Linda");

		Assert.assertTrue(pim.isEmployeeFound(), "Employee not found in search!");
	}
}

