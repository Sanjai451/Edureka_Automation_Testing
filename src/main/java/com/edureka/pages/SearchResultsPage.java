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

public class SearchResultsPage {

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

    private By mobileNumberBy = By.xpath("//input[@placeholder='Your mobile number']");

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
            wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[contains(text(),'Get a call back')]")
            ));
            return callbackForm != null && callbackForm.size() > 0;
        } catch (Exception e) {
            return false;
        }
    }

    public void enterMobileNumber(String mobile) {
        WebElement field = wait.until(ExpectedConditions.presenceOfElementLocated(mobileNumberBy));

        ((JavascriptExecutor) driver).executeScript(
            "arguments[0].scrollIntoView({block:'center'});", field
        );

        wait.until(ExpectedConditions.visibilityOf(field));
        field.clear();
        field.sendKeys(mobile);
    }

    public String getEnteredMobileNumber() {
        WebElement field = wait.until(ExpectedConditions.presenceOfElementLocated(mobileNumberBy));

        ((JavascriptExecutor) driver).executeScript(
            "arguments[0].scrollIntoView({block:'center'});", field
        );

        wait.until(ExpectedConditions.visibilityOf(field));
        return field.getAttribute("value");
    }

    public void clickJobRoleDropdown() {
        WebElement dropdown = wait.until(
            ExpectedConditions.elementToBeClickable(jobRoleDropdown)
        );

        ((JavascriptExecutor) driver).executeScript(
            "arguments[0].click();", dropdown
        );
    }

    public void selectJobRole(String role) {
        WebElement label = wait.until(
            ExpectedConditions.elementToBeClickable(
                By.xpath("//label[normalize-space()='" + role + "']")
            )
        );

        ((JavascriptExecutor) driver).executeScript(
            "arguments[0].scrollIntoView({block:'center'});", label
        );

        ((JavascriptExecutor) driver).executeScript(
            "arguments[0].click();", label
        );
    }

    public String getCategoryHeading() {
        return wait.until(ExpectedConditions.visibilityOf(categoryHeading)).getText();
    }

    public boolean isJobRoleSelected(String role) {
        WebElement label = wait.until(
            ExpectedConditions.presenceOfElementLocated(
                By.xpath("//label[normalize-space()='" + role + "']")
            )
        );

        String inputId = label.getAttribute("for");

        WebElement input = wait.until(
            ExpectedConditions.presenceOfElementLocated(By.id(inputId))
        );

        return input.isSelected();
    }
}