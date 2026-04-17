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

    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
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

    public boolean areResultsDisplayed(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));

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

        return resultList.size() > 0;
    }

    public String getFirstResultTitle() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement element = wait.until(ExpectedConditions.visibilityOf(firstResultTitle));

        String text = element.getText();

        if (text == null || text.trim().isEmpty()) {
            throw new RuntimeException("First result title is EMPTY");
        }

        return text.trim();
    }

    public void clickFirstResult() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(viewDetailsBtn)).click();
    }

    public boolean isNoResultMessageDisplayed() {
        return noResultMessage.size() > 0;
    }

    public boolean isCallbackFormDisplayed() {
        return callbackForm.size() > 0;
    }

    public void enterMobileNumber(WebDriver driver, String mobile) {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("arguments[0].scrollIntoView({block:'center'});", mobileNumberField);
        js.executeScript("arguments[0].value='';", mobileNumberField);
        js.executeScript("arguments[0].click();", mobileNumberField);
        js.executeScript("arguments[0].value=arguments[1];", mobileNumberField, mobile);
    }

    public String getEnteredMobileNumber() {
        return mobileNumberField.getAttribute("value");
    }
}