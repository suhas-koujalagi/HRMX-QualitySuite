package com.ssk.orangehrm.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ssk.orangehrm.base.BaseTest;
import com.ssk.orangehrm.pages.AddEmployeePage;
import com.ssk.orangehrm.pages.DashboardPage;
import com.ssk.orangehrm.pages.EmployeeListPage;
import com.ssk.orangehrm.pages.LoginPage;
import com.ssk.orangehrm.utils.ConfigReader;

public class PIMTests extends BaseTest {

    @Test(priority = 1, description = "Verify adding a new employee")
    public void addEmployeeTest() throws InterruptedException {

        LoginPage login = new LoginPage(driver);
        DashboardPage dashboard = new DashboardPage(driver);

        driver.get(ConfigReader.getProperty("baseUrl"));
        login.enterUsername(ConfigReader.getProperty("username"));
        login.enterPassword(ConfigReader.getProperty("password"));
        login.clickLogin();

        Assert.assertTrue(dashboard.isDashboardLoaded(), "Dashboard did not load.");

        dashboard.openPIMModule();

        EmployeeListPage pim = new EmployeeListPage(driver);
        pim.clickAddEmployee();

        AddEmployeePage addEmp = new AddEmployeePage(driver);

        String fName = "Auto" + System.currentTimeMillis();
        addEmp.enterEmployeeDetails(fName, "Test", "User", "ID" + System.currentTimeMillis());
        addEmp.saveEmployee();

        Thread.sleep(2000);

        dashboard.openPIMModule();

        pim.searchEmployeeByName(fName);

        Assert.assertTrue(pim.isEmployeeFound(), "Employee not found in the list!");
    }

    @Test(priority = 2, description = "Verify searching an employee")
    public void searchEmployeeTest() {

        LoginPage login = new LoginPage(driver);
        DashboardPage dashboard = new DashboardPage(driver);

        driver.get(ConfigReader.getProperty("baseUrl"));
        login.enterUsername(ConfigReader.getProperty("username"));
        login.enterPassword(ConfigReader.getProperty("password"));
        login.clickLogin();

        Assert.assertTrue(dashboard.isDashboardLoaded(), "Dashboard did not load.");

        dashboard.openPIMModule();

        EmployeeListPage pim = new EmployeeListPage(driver);
        pim.searchEmployeeByName("Linda");

        Assert.assertTrue(pim.isEmployeeFound(), "Employee not found in search!");
    }
}

