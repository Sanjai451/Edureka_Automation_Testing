package com.edureka.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommunityAskQuestion {
	
	@FindBy(id = "title")
	private WebElement titleInput;
	
	@FindBy(id = "category_1")
	private WebElement categoryDowndown;
	
	@FindBy(id = "tags")
	private WebElement tagInput;
	
	@FindBy(xpath = "//button[.='Ask the Question']")
	private WebElement submit;
	
	
	
	public void fillQuestionDetails(WebDriver driver, String title, String category, String tag) {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		wait.until(ExpectedConditions.elementToBeClickable(categoryDowndown));
		
		Select select = new Select(categoryDowndown);
		select.selectByVisibleText(category);
		
		titleInput.sendKeys(title);
		tagInput.sendKeys(tag);
		
		submit.click();
		
	}
	
	
}
