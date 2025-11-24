package com.ssk.orangehrm.pages;

import java.util.Random;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminUsersPage {

	private WebDriver driver;
	private static int id;
	
	// System Section Search fields
	@FindBy(xpath = "//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@class='oxd-input oxd-input--active']")
	private WebElement sysUserName;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement serachButton;

	// Table row to verify Searched user found
	@FindBy(xpath = "//div[@class='oxd-table-card']")
	private WebElement userTableRow;

	@FindBy(xpath = "//div[@role='rowgroup']")
	private WebElement tableRecord;

	//Adding User by admin
	@FindBy(xpath = "//button[normalize-space()='Add']")
	private WebElement addNewEmpButton; 

	@FindBy(xpath = "//body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]")
	private WebElement newEmpRole;

	@FindBy(xpath = "//input[@placeholder='Type for hints...']")
	private WebElement newEmpName;

	@FindBy(xpath = "//div[3]//div[1]//div[2]//div[1]//div[1]//div[1]")
	private WebElement newEmpStatus;

	@FindBy(xpath = "//div[@class='oxd-form-row']//div[@class='oxd-grid-2 orangehrm-full-width-grid']//div[@class='oxd-grid-item oxd-grid-item--gutters']//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@class='oxd-input oxd-input--active']")
	private WebElement newEmpUserName;

	@FindBy(xpath = "//div[@class='oxd-grid-item oxd-grid-item--gutters user-password-cell']//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@type='password']")
	private WebElement newEmpPassowrd;

	@FindBy(xpath = "//div[@class='oxd-grid-item oxd-grid-item--gutters']//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@type='password']")
	private WebElement newEmpConfirmPassword;

	@FindBy(xpath = "//button[normalize-space()='Save']")
	private WebElement newEmpsaveButton;

	// Constructure
	public AdminUsersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
		//creating the unique username for test purpose
		Random random = new Random();
		int id = random.nextInt(100);
	}

	// Actions for search 
	public void searchByUsername(String username) {
		sysUserName.clear();
		sysUserName.sendKeys(username);
		serachButton.click();
	}

	// to verify user exists or not
	public boolean isUserFound() {
		try {
			return tableRecord.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	// New User add option by Admin
	public void clickAddUser() {
		addNewEmpButton.click();
	}

	// actions to fill new user details
	public void enterNewEmpRole(String role) throws InterruptedException {
		Thread.sleep(4000);
		newEmpRole.click();
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
	}

	public void enterNewEmpName(String name) throws InterruptedException {
		newEmpName.sendKeys(name);
		Thread.sleep(4000);
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();

	}

	public void enterNewEmpStatus(String status) {
		newEmpStatus.sendKeys(status);
	}

	public void enterNewEmpUserName(String username) {
		username += id;
		newEmpUserName.sendKeys(username);
	}

	public void enterNewEmpPassword(String passsword) {
		passsword += id;
		newEmpPassowrd.sendKeys(passsword);
	}

	public void enterNewEmpConfirmPassword(String passsword) {
		passsword += id;
		newEmpConfirmPassword.sendKeys(passsword);
	}


	public void enterNewUserDetails(String role,String name, String status, String username, String password) throws InterruptedException {
		enterNewEmpRole(role);
		enterNewEmpName(name);
		enterNewEmpStatus(status);
		enterNewEmpUserName(username);
		enterNewEmpPassword(password);
		enterNewEmpConfirmPassword(password);
		Thread.sleep(4000);
	}

	// save action to add new user
	public void saveUser() {
		newEmpsaveButton.click();
	}
}

