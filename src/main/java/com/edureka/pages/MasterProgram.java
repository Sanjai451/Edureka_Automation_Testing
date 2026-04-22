package com.edureka.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MasterProgram {

    WebDriver driver;
    WebDriverWait wait;

    public MasterProgram(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @FindBy(xpath = "//button[.='Download Curriculum']")
    private WebElement downLoadCurriculumButton;

    @FindBy(xpath = "//div[contains(@class,'wishlist')]")
    private WebElement addToWishlistButton;

    @FindBy(xpath = "//div[contains(@class,'share')]")
    private WebElement shareButton;

    @FindBy(id = "formEmail-requestbox")
    private WebElement talkToAdvisorEmailInput;

    @FindBy(id = "formPhoneNumber-requestbox")
    private WebElement talkToAdvisorPhoneInput;

    @FindBy(xpath = "//button[.='Request a Call']")
    private WebElement requestACallButton;

    public void addToWishlist() {
//    	By loader = By.xpath("//div[contains(@class,'loader_loader_div')]");
//
//    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
//
//    	// wait until loader disappears
//    	wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));
    	
//    	try {
//			Thread.sleep(5000);
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
    	
    	By loaderLocator = By.cssSelector("[class*='loader_loader_div']");

        // Wait until loader is invisible or removed from DOM
        wait.until(ExpectedConditions.invisibilityOfElementLocated(loaderLocator));
    	
    	System.out.println("Loader disappeared");
    	
    	WebElement wishlistBtn = wait.until(
	        ExpectedConditions.elementToBeClickable(
	            By.xpath("//div[contains(@class,'wishlist')]")
	        )
	    );

	    wishlistBtn.click();
    }

    public void clickDownloadCurriculum() {
        downLoadCurriculumButton.click();
    }
}