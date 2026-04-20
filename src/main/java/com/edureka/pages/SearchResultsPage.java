package com.edureka.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.edureka.utility.Base;

public class SearchResultsPage {
	
	Base base;
	public SearchResultsPage(Base base) {
		this.base = base;
	}

    private WebDriver driver;
    private WebDriverWait wait;

    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[contains(@class,'giTrackElement')]")
    private List<WebElement> resultList;

    @FindBy(xpath = "(//div[contains(@class,'giTrackElement')]//h3)[1]")
    private WebElement firstResultTitle;

    @FindBy(xpath = "(//span[contains(text(),'View Details')])[1]")
    private WebElement viewDetailsBtn;

    @FindBy(xpath = "//*[contains(text(),'did not match')]")
    private List<WebElement> noResultMessage;

    @FindBy(xpath = "//*[contains(text(),'Get a call back')]")
    private List<WebElement> callbackForm;

    @FindBy(xpath = "//input[@placeholder='Your mobile number']")
    private WebElement mobileNumberField;

    @FindBy(xpath = "//button[contains(text(),'Job Role')]")
    private WebElement jobRoleDropdown;

    @FindBy(xpath = "//h2")
    private WebElement categoryHeading;

    public boolean areResultsDisplayed() {
        try {
            wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//div[contains(@class,'giTrackElement')]")),
                ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//*[contains(text(),'did not match')]"))
            ));
        } catch (Exception e) {
            return false;
        }

        return resultList != null && resultList.size() > 0;
    }

    public String getFirstResultTitle() {
        String text = wait.until(ExpectedConditions.visibilityOf(firstResultTitle)).getText();

        if (text == null || text.trim().isEmpty()) {
            throw new RuntimeException("First result title is EMPTY");
        }

        return text.trim();
    }

    public void clickFirstResult() {
        wait.until(ExpectedConditions.elementToBeClickable(viewDetailsBtn)).click();
    }

    public boolean isNoResultMessageDisplayed() {
        return noResultMessage != null && noResultMessage.size() > 0;
    }

    public boolean isCallbackFormDisplayed() {
        try {
            return callbackForm != null && callbackForm.size() > 0;
        } catch (Exception e) {
            return false;
        }
    }

    public void enterMobileNumber(String mobile) {
        JavascriptExecutor js = (JavascriptExecutor) base.getDriver();

        WebElement field = wait.until(ExpectedConditions.presenceOfElementLocated(
            By.xpath("//input[@placeholder='Your mobile number']")
        ));

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", field);

        wait.until(ExpectedConditions.visibilityOf(field));

        field.clear();
        field.sendKeys(mobile);
    }
    public String getEnteredMobileNumber() {

        WebElement field = wait.until(ExpectedConditions.presenceOfElementLocated(
            By.xpath("//input[@placeholder='Your mobile number']")
        ));

        return field.getAttribute("value");
    }

    public void clickJobRoleDropdown() {
        wait.until(ExpectedConditions.elementToBeClickable(jobRoleDropdown)).click();
    }

    public void selectJobRole(String role) {
        String formattedId = "_" + role.replace(" ", "_") + "_";

        WebElement element = wait.until(
            ExpectedConditions.presenceOfElementLocated(By.id(formattedId))
        );

        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    public String getCategoryHeading() {
        return wait.until(ExpectedConditions.visibilityOf(categoryHeading)).getText();
    }

    public boolean isJobRoleSelected(String role) {
        String formattedId = "_" + role.replace(" ", "_") + "_";

        WebElement element = wait.until(
            ExpectedConditions.presenceOfElementLocated(By.id(formattedId))
        );

        return element.isSelected();
    }
}