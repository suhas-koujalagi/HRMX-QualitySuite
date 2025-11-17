package com.ssk.orangehrm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeavePage {

    private WebDriver driver;

    @FindBy(xpath = "//button[normalize-space()='Apply']")
    private WebElement applyLeaveBtn;

    @FindBy(xpath = "//label[text()='Leave Type']/../following-sibling::div//div[contains(@class,'oxd-select-text-input')]")
    private WebElement leaveTypeDropdown;

    @FindBy(xpath = "//input[@placeholder='yyyy-mm-dd']")
    private WebElement fromDate;

    @FindBy(xpath = "(//input[@placeholder='yyyy-mm-dd'])[2]")
    private WebElement toDate;

    @FindBy(xpath = "//textarea")
    private WebElement comments;

    @FindBy(xpath = "//button[normalize-space()='Apply']")
    private WebElement applyButton;

    public LeavePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void openApplyLeave() {
        applyLeaveBtn.click();
    }

    public void selectLeaveType(String type) {
        leaveTypeDropdown.click();
        driver.findElement(org.openqa.selenium.By.xpath("//span[text()='" + type + "']")).click();
    }

    public void enterLeaveDates(String start, String end) {
        fromDate.clear();
        fromDate.sendKeys(start);
        toDate.clear();
        toDate.sendKeys(end);
    }

    public void enterComment(String text) {
        comments.sendKeys(text);
    }

    public void submitLeave() {
        applyButton.click();
    }
}

