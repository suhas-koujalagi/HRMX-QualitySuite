package com.ssk.orangehrm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddUserPage {

    private WebDriver driver;

    // User Role dropdown
    @FindBy(xpath = "//label[text()='User Role']/../following-sibling::div//div[contains(@class,'oxd-select-text-input')]")
    private WebElement userRoleDropdown;

    // Status dropdown
    @FindBy(xpath = "//label[text()='Status']/../following-sibling::div//div[contains(@class,'oxd-select-text-input')]")
    private WebElement statusDropdown;

    // Employee Name auto-suggest
    @FindBy(xpath = "//input[@placeholder='Type for hints...']")
    private WebElement employeeNameInput;

    @FindBy(xpath = "//div[@role='option']")
    private WebElement employeeSuggestionOption;

    // Username
    @FindBy(xpath = "//label[text()='Username']/../following-sibling::div/input")
    private WebElement usernameInput;

    // Password + confirm
    @FindBy(xpath = "//label[text()='Password']/../following-sibling::div/input")
    private WebElement passwordInput;

    @FindBy(xpath = "//label[text()='Confirm Password']/../following-sibling::div/input")
    private WebElement confirmPasswordInput;

    // Save button
    @FindBy(xpath = "//button[normalize-space()='Save']")
    private WebElement saveBtn;

    public AddUserPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Actions
    public void selectUserRole(String role) {
        userRoleDropdown.click();
        driver.findElement(
            org.openqa.selenium.By.xpath("//span[text()='" + role + "']")
        ).click();
    }

    public void selectStatus(String status) {
        statusDropdown.click();
        driver.findElement(
            org.openqa.selenium.By.xpath("//span[text()='" + status + "']")
        ).click();
    }

    public void enterEmployeeName(String name) throws InterruptedException {
        employeeNameInput.sendKeys(name);
        Thread.sleep(1000);  // give auto-suggest time
        employeeSuggestionOption.click();
    }

    public void enterUsername(String username) {
        usernameInput.sendKeys(username);
    }

    public void enterPassword(String password) {
        passwordInput.sendKeys(password);
        confirmPasswordInput.sendKeys(password);
    }

    public void clickSave() {
        saveBtn.click();
    }
}
