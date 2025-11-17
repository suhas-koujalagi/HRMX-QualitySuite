package com.ssk.orangehrm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EmployeeListPage {

    private WebDriver driver;

    // Search fields
    @FindBy(xpath = "//label[text()='Employee Name']/../following-sibling::div//input")
    private WebElement employeeNameSearchInput;

    @FindBy(xpath = "//label[text()='Employee Id']/../following-sibling::div//input")
    private WebElement employeeIdSearchInput;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement searchButton;

    @FindBy(xpath = "//button[text()=' Reset ']")
    private WebElement resetButton;

    // Add employee button
    @FindBy(xpath = "//button[normalize-space()='Add']")
    private WebElement addEmployeeBtn;

    // Table row
    @FindBy(xpath = "//div[@class='oxd-table-card']")
    private WebElement employeeRow;

    public EmployeeListPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void searchEmployeeByName(String name) {
        employeeNameSearchInput.clear();
        employeeNameSearchInput.sendKeys(name);
        searchButton.click();
    }

    public void searchEmployeeById(String id) {
        employeeIdSearchInput.clear();
        employeeIdSearchInput.sendKeys(id);
        searchButton.click();
    }

    public boolean isEmployeeFound() {
        try {
            return employeeRow.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void clickAddEmployee() {
        addEmployeeBtn.click();
    }
}

