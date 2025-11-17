package com.ssk.orangehrm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {

    private WebDriver driver;

    // Top bar user dropdown
    @FindBy(xpath = "//img[@class='oxd-userdropdown-img']")
    private WebElement userDropdown;

    @FindBy(xpath = "//a[text()='Logout']")
    private WebElement logoutButton;

    // Side menu modules
    @FindBy(xpath = "//span[text()='Admin']")
    private WebElement adminModule;

    @FindBy(xpath = "//span[text()='PIM']")
    private WebElement pimModule;

    @FindBy(xpath = "//span[text()='Leave']")
    private WebElement leaveModule;

    @FindBy(xpath = "//span[text()='Recruitment']")
    private WebElement recruitmentModule;

    @FindBy(xpath = "//h6[text()='Dashboard']")
    private WebElement dashboardHeader;

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Validations
    public boolean isDashboardLoaded() {
        try {
            return dashboardHeader.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    // Navigation actions
    public void openAdminModule() {
        adminModule.click();
    }

    public void openPIMModule() {
        pimModule.click();
    }

    public void openLeaveModule() {
        leaveModule.click();
    }

    public void openRecruitmentModule() {
        recruitmentModule.click();
    }

    // Logout
    public void logout() {
        userDropdown.click();
        logoutButton.click();
    }
}

