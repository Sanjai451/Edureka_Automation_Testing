package com.edureka.pages;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Page Object Model class for the Community Home Page of the Edureka website.
 * This class encapsulates the web elements and actions related to the community home page,
 * including login functionality, navigation to ask questions, clicking on tags, categories,
 * and specific questions.
 */
public class CommunityHomePage {
	
	@FindBy(xpath = "//a[@href='https://www.edureka.co/community/ask']")
	private WebElement askQuestionButton;
	
	@FindBy(name = "q")
	private WebElement searchBar;
	
	@FindBy(xpath = "//a[@class='qa-nav-sub-link' and text()='Latest']")
	private WebElement latestPostsButton;
	
	@FindBy(xpath = "//a[@class='qa-nav-sub-link' and text()='Most votes']")
	private WebElement mostVotesButton;
	
	@FindBy(xpath = "//a[@class='qa-nav-sub-link' and text()='Most answers']")
	private WebElement mostAnswersButton;
	
	@FindBy(xpath = "//a[@class='qa-nav-sub-link' and text()='Most views']")
	private WebElement mostViewButton;
	
	@FindBy(xpath = "//a[@class='qa-nav-sub-link' and text()='No Answers']")
	private WebElement noAnswersButton;
	
	@FindBy(id = "inputName")
	private WebElement emailInput;
	
	@FindBy(css = "[placeholder='Password*']")
	private WebElement passwordInput;
	
	@FindBy(xpath = "//button[.='LOGIN']")
	private WebElement loginButton;
	
	@FindBy(xpath = "//button[.='Log In']")
	private WebElement loginButtonOnNavbar;
	
	/**
	 * Performs login by clicking the navbar login button, entering email and password,
	 * and submitting the login form.
	 * @param email the email address to enter in the login form
	 * @param pass the password to enter in the login form
	 */
	public void performLogin(String email, String pass) {
		loginButtonOnNavbar.click();
		emailInput.sendKeys(email);
		passwordInput.sendKeys(pass);
		loginButton.click();
	}
	
	/**
	 * Clicks on a specific tag link on the community page.
	 * The tag text is converted to lowercase for matching.
	 * @param driver the WebDriver instance
	 * @param tag the tag text to click on
	 */
	public void clickOnTag(WebDriver driver, String tag) {
		tag = tag.toLowerCase();
		driver.findElement(By.xpath("//a[@class='ga-tags-click' and .='" + tag + "']")).click();
	}
	
	/**
	 * Clicks on a specific category link on the community page.
	 * The category text is converted to lowercase for matching.
	 * @param driver the WebDriver instance
	 * @param category the category text to click on
	 */
	public void clickOnCategory(WebDriver driver, String category) {
		category = category.toLowerCase();
		driver.findElement(By.xpath("//a[@class='qa-nav-cat-link' and .='" + category + "']")).click();
	}
	
	/**
	 * Clicks the "Ask Question" button and switches to the new window/tab that opens.
	 * Handles window switching to navigate to the ask question page.
	 * @param driver the WebDriver instance
	 */
	public void clickAskQuestion(WebDriver driver) {
		String homePage = driver.getWindowHandle();
		
		askQuestionButton.click();
		
		Set<String> allHandles = driver.getWindowHandles();
		
		for(String string : allHandles) {
			if(! string.equals(homePage)) {
				driver.switchTo().window(string);
				break;
			}
		}
	}
	
	/**
	 * Clicks on a specific question link by its exact text.
	 * Waits for the element to be clickable before clicking.
	 * @param driver the WebDriver instance
	 * @param question the exact text of the question to click on
	 */
	public void clickOnQuestion(WebDriver driver, String question) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(
				driver.findElement(By.xpath("//a[text()='" + question + "']"))
				))
		.click();	
	}
	
	/**
	 * Clicks on a recent question by its text in a span element.
	 * @param driver the WebDriver instance
	 * @param question the text of the recent question to click on
	 */
	public void clickOnRecentQuestions(WebDriver driver, String question) {
		driver.findElement(By.xpath("//span[text()='" + question + "']")).click();	
	}
	
}
