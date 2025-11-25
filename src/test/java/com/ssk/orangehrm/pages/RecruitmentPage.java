package com.ssk.orangehrm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RecruitmentPage {

	private WebDriver driver;

	@FindBy(xpath = "//button[normalize-space()='Add']")
	private WebElement addCandidateBtn;

	@FindBy(name = "firstName")
	private WebElement firstName;

	@FindBy(name = "lastName")
	private WebElement lastName;

	@FindBy(xpath = "(//input[@placeholder='Type here'])[1]")
	private WebElement emailInput;

	@FindBy(xpath = "//button[normalize-space()='Save']")
	private WebElement saveCandidateBtn;

	public RecruitmentPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickAddCandidate() {
		addCandidateBtn.click();
	}

	public void enterFirstName(String fname) {
		firstName.sendKeys(fname);
	}

	public void enterLastName(String lname) {
		lastName.sendKeys(lname);
	}

	public void enterEmail(String email) {
		emailInput.sendKeys(email);
	}

	public void saveCandidate() {
		saveCandidateBtn.click();
	}

	public void enterCandidateDetails(String fname, String lname, String email) {
		enterFirstName(fname);
		enterLastName(lname);
		enterEmail(email);
	}
}

