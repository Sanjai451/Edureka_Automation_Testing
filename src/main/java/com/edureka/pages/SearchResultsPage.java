package com.edureka.pages;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.edureka.utility.Base;

public class SearchResultsPage {
	
	Base base;
	public SearchResultsPage(Base base) {
		this.base = base;
	}

    @FindBy(xpath = "//div[contains(@class,'card giTrackElement')]")
    private List<WebElement> resultList;

    @FindBy(xpath = "(//div[contains(@class,'card giTrackElement')]//h3)[1]")
    private WebElement firstResultTitle;

    @FindBy(xpath = "(//span[contains(text(),'View Details')])[1]")
    private WebElement viewDetailsBtn;

    @FindBy(xpath = "//*[contains(text(),'did not match')]")
    private List<WebElement> noResultMessage;

    @FindBy(xpath = "//*[contains(text(),'Get a call back')]")
    private List<WebElement> callbackForm;

    @FindBy(xpath = "//input[@placeholder='Your mobile number']")
    private WebElement mobileNumberField;

    public boolean areResultsDisplayed() {
        return resultList.size() > 0;
    }

    public String getFirstResultTitle() {
        String text = firstResultTitle.getText();

        if (text == null || text.trim().isEmpty()) {
            throw new RuntimeException("First result title is EMPTY");
        }

        return text.trim();
    }

    public void clickFirstResult() {
        viewDetailsBtn.click();
    }

    public boolean isNoResultMessageDisplayed() {
        return noResultMessage.size() > 0;
    }

    public boolean isCallbackFormDisplayed() {
        return callbackForm.size() > 0;
    }

    public WebElement getMobileNumberField() {
        return mobileNumberField;
    }

    public void enterMobileNumber(String mobile) {
        JavascriptExecutor js = (JavascriptExecutor) base.getDriver();

        js.executeScript("arguments[0].scrollIntoView({block:'center'});", mobileNumberField);
        js.executeScript("arguments[0].value='';", mobileNumberField);
        js.executeScript("arguments[0].click();", mobileNumberField);
        js.executeScript("arguments[0].value=arguments[1];", mobileNumberField, mobile);
    }

    public String getEnteredMobileNumber() {
        return mobileNumberField.getAttribute("value");
    }
}