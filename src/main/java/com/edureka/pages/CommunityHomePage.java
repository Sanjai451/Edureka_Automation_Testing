package com.edureka.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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
	
	public void clickOnTag(WebDriver driver, String tag) {
		tag = tag.toLowerCase();
		driver.findElement(By.xpath("//a[@class='ga-tags-click' and .='" + tag + "']")).click();
	}
	
	public void clickOnCategory(WebDriver driver, String category) {
		category = category.toLowerCase();
		driver.findElement(By.xpath("//a[@class='qa-nav-cat-link' and .='" + category + "']")).click();
	}
	
	public void clickAskQuestion() {
		askQuestionButton.click();
	}
	
	public void clickOnQuestion(WebDriver driver, String question) {
		driver.findElement(By.xpath("//a[text()='" + question + "']")).click();	
	}
	
	public void clickOnRecentQuestions(WebDriver driver, String question) {
		driver.findElement(By.xpath("//span[text()='" + question + "']")).click();	
	}
	
}
