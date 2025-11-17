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

    @FindBy(xpath = "//input[@type='email']")
    private WebElement emailInput;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement saveCandidateBtn;

    public RecruitmentPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickAddCandidate() {
        addCandidateBtn.click();
    }

    public void enterCandidateDetails(String fName, String lName, String email) {
        firstName.sendKeys(fName);
        lastName.sendKeys(lName);
        emailInput.sendKeys(email);
    }

    public void saveCandidate() {
        saveCandidateBtn.click();
    }
}

