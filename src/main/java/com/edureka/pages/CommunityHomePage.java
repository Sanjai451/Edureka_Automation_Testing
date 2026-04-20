package com.edureka.pages;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
	
	public void performLogin(String email, String pass) {
		loginButtonOnNavbar.click();
		emailInput.sendKeys(email);
		passwordInput.sendKeys(pass);
		loginButton.click();
	}
	
	public void clickOnTag(WebDriver driver, String tag) {
		tag = tag.toLowerCase();
		driver.findElement(By.xpath("//a[@class='ga-tags-click' and .='" + tag + "']")).click();
	}
	
	public void clickOnCategory(WebDriver driver, String category) {
		category = category.toLowerCase();
		driver.findElement(By.xpath("//a[@class='qa-nav-cat-link' and .='" + category + "']")).click();
	}
	
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
	
	public void clickOnQuestion(WebDriver driver, String question) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(
				driver.findElement(By.xpath("//a[text()='" + question + "']"))
				))
		.click();	
	}
	
	public void clickOnRecentQuestions(WebDriver driver, String question) {
		driver.findElement(By.xpath("//span[text()='" + question + "']")).click();	
	}
	
}
