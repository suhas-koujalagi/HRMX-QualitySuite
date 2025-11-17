package com.ssk.orangehrm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AdminUsersPage {

    private WebDriver driver;

    // Search fields
    @FindBy(xpath = "//label[text()='Username']/../following-sibling::div/input")
    private WebElement usernameSearchInput;

    @FindBy(xpath = "//label[text()='User Role']/../following-sibling::div//div[contains(@class,'oxd-select-text-input')]")
    private WebElement userRoleDropdown;

    @FindBy(xpath = "//label[text()='Status']/../following-sibling::div//div[contains(@class,'oxd-select-text-input')]")
    private WebElement statusDropdown;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement searchButton;

    @FindBy(xpath = "//button[text()=' Reset ']")
    private WebElement resetButton;

    // Add user button
    @FindBy(xpath = "//button[normalize-space()='Add']")
    private WebElement addUserButton;

    // Add user form
    @FindBy(xpath = "//label[text()='User Role']/../following-sibling::div//div[contains(@class,'oxd-select-text-input')]")
    private WebElement addUserRole;

    @FindBy(xpath = "//input[@placeholder='Type for hints...']")
    private WebElement employeeNameInput;

    @FindBy(xpath = "//label[text()='Status']/../following-sibling::div//div[contains(@class,'oxd-select-text-input')]")
    private WebElement addStatus;

    @FindBy(xpath = "//label[text()='Username']/../following-sibling::div/input")
    private WebElement newUsernameInput;

    @FindBy(xpath = "//label[text()='Password']/../following-sibling::div/input")
    private WebElement newPasswordInput;

    @FindBy(xpath = "//label[text()='Confirm Password']/../following-sibling::div/input")
    private WebElement confirmPasswordInput;

    @FindBy(xpath = "//button[normalize-space()='Save']")
    private WebElement saveUserButton;

    // Table row
    @FindBy(xpath = "//div[@class='oxd-table-card']")
    private WebElement userTableRow;

    public AdminUsersPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Actions
    public void searchByUsername(String username) {
        usernameSearchInput.clear();
        usernameSearchInput.sendKeys(username);
        searchButton.click();
    }

    public boolean isUserFound() {
        try {
            return userTableRow.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void clickAddUser() {
        addUserButton.click();
    }

    public void enterNewUserDetails(String empName, String username, String password) {
        employeeNameInput.sendKeys(empName);
        newUsernameInput.sendKeys(username);
        newPasswordInput.sendKeys(password);
        confirmPasswordInput.sendKeys(password);
    }

    public void saveUser() {
        saveUserButton.click();
    }
}

