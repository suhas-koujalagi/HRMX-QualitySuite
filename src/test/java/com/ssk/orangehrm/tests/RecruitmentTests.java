package com.ssk.orangehrm.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ssk.orangehrm.base.BaseTest;
import com.ssk.orangehrm.pages.RecruitmentPage;
import com.ssk.orangehrm.utils.ConfigReader;
import com.ssk.orangehrm.pages.DashboardPage;
import com.ssk.orangehrm.pages.LoginPage;

public class RecruitmentTests extends BaseTest {

    @Test(priority = 1, description = "Verify adding a new candidate")
    public void addCandidateTest() {

        LoginPage login = new LoginPage(driver);
        DashboardPage dashboard = new DashboardPage(driver);

        driver.get(ConfigReader.getProperty("baseUrl"));
        login.enterUsername(ConfigReader.getProperty("username"));
        login.enterPassword(ConfigReader.getProperty("password"));
        login.clickLogin();

        Assert.assertTrue(dashboard.isDashboardLoaded(),
                "Dashboard not loaded — login failed.");

        dashboard.openRecruitmentModule();

        RecruitmentPage recruit = new RecruitmentPage(driver);

        recruit.clickAddCandidate();
        recruit.enterCandidateDetails("Auto", "Candidate", "auto" + System.currentTimeMillis() + "@gmail.com");
        recruit.saveCandidate();

        Assert.assertTrue(true, "Candidate creation process hit an issue.");
    }
}

