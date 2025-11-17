package com.ssk.orangehrm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddEmployeePage {

    private WebDriver driver;

    @FindBy(name = "firstName")
    private WebElement firstNameInput;

    @FindBy(name = "middleName")
    private WebElement middleNameInput;

    @FindBy(name = "lastName")
    private WebElement lastNameInput;

    @FindBy(xpath = "//label[text()='Employee Id']/../following-sibling::div/input")
    private WebElement employeeIdInput;

    @FindBy(xpath = "//button[normalize-space()='Save']")
    private WebElement saveEmployeeBtn;

    public AddEmployeePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterEmployeeDetails(String first, String middle, String last, String id) {
        firstNameInput.sendKeys(first);
        middleNameInput.sendKeys(middle);
        lastNameInput.sendKeys(last);
        employeeIdInput.clear();
        employeeIdInput.sendKeys(id);
    }

    public void saveEmployee() {
        saveEmployeeBtn.click();
    }
}

