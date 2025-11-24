package com.ssk.orangehrm.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeavePage {

	private WebDriver driver;

	// to assign leave to Employee
	@FindBy(xpath = "//a[normalize-space()='Assign Leave']")
	private WebElement assignLeave;

	@FindBy(xpath = "//input[@placeholder='Type for hints...']")
	private WebElement empName;

	@FindBy(xpath = "//div[@class='oxd-select-text-input']")
	private WebElement leaveType;

	@FindBy(xpath = "//body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/input[1]")
	private WebElement fromDate;

	@FindBy(css = "body > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > form:nth-child(3) > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > input:nth-child(1)")
	private WebElement toDate;

	@FindBy(xpath = "//textarea[@class='oxd-textarea oxd-textarea--active oxd-textarea--resize-vertical']")
	private WebElement comments;

	@FindBy(xpath = "//button[normalize-space()='Assign']")
	private WebElement assignButton;

	public LeavePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// move leave assign page 
	public void moveToLeaveAssignPage() throws InterruptedException {
		assignLeave.click();
		Thread.sleep(4000);
	}

	// add details
	public void enterEmpName(String name) throws InterruptedException {
		empName.sendKeys(name);
		Thread.sleep(4000);
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
	}

	public void enterLeaveType() throws InterruptedException {
		Thread.sleep(4000);
		leaveType.click();
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
	}

	public void enterfromDate(String fromDateIn) {
		fromDate.sendKeys(fromDateIn);
	}

	public void enterToDate(String toDateIn) throws InterruptedException {
		toDate.clear();
		toDate.sendKeys(toDateIn);
	}

	public void enterComment(String comment) {
		comments.sendKeys(comment);
		
	}

	public void assignLeave() {
		assignButton.click();	
	}

	public void leaveAssignAction(String name, String fdate, String tdate, String comma) throws InterruptedException {
		moveToLeaveAssignPage();
		enterEmpName(name);
		enterLeaveType();
		enterfromDate(fdate);
		enterToDate(tdate);
		enterComment(comma);
		assignLeave();
		Thread.sleep(4000);
	}
}

