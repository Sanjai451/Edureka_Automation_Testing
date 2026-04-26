package com.edureka.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Page Object Model class for the Webinar Category Page of the Edureka website.
 * This class handles interactions with the webinar category page, including filling out
 * registration forms and retrieving page titles.
 */
public class WebinarCategoryPage {
	
    private WebDriver driver;
    private WebDriverWait wait;
    
    /**
     * Constructor for WebinarCategoryPage.
     * Initializes the WebDriver and WebDriverWait instances.
     * PageFactory is commented out, so elements are not initialized automatically.
     * @param driver the WebDriver instance to be used for interacting with the page
     */
    public WebinarCategoryPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
//        PageFactory.initElements(driver, this);
    }
    
    @FindBy(xpath = "//a[.='Join Now']")
    private WebElement joinNowButton;
    
    @FindBy(xpath = "//label[@for='email']/following-sibling::input")
    private WebElement emailInputField;
    
    @FindBy(name = "Experience")
    private WebElement selectDropdown;
    
    @FindBy(name = "phone_no")
    private WebElement phoneNumber;
    
    @FindBy(xpath = "//button[text()='Submit']")
    private WebElement submitButton;
    
    @FindBy(xpath = "//div[@class='top_title']//h1")
    private WebElement titlePage;
    
    // Success message span
    @FindBy(xpath = "//span[contains(text(),'Thank you for your Registration !')]")
    private WebElement successMessage;
    
    /**
     * Fills out the webinar registration form with the provided details and submits it.
     * Selects experience from dropdown, enters email and phone number, then clicks submit.
     * @param email the email address to enter
     * @param phone the phone number to enter
     * @param experience the experience level to select from dropdown
     */
    public void fillDetailAndSubmit(String email, String phone, String experience) {
    	Select sel = new Select(selectDropdown);
    	sel.selectByVisibleText(experience);
    	emailInputField.sendKeys(email);
    	phoneNumber.sendKeys(phone);
    	submitButton.click();
    	
    	// Wait until success message becomes visible
        wait.until(ExpectedConditions.visibilityOf(successMessage));
    	
    }
    
    /**
     * Gets the text of the page title element.
     * @return the title text as a String
     */
    public String getTitle() {
    	return titlePage.getText();
    }
    
}
