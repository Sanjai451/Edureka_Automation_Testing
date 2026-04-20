package com.edureka.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BlogVideoFullScreenPage {
	
	@FindBy(xpath = "//span[contains(@class, 'category-title')]")
	private WebElement title;
	
	@FindBy(id = "comment")
	private WebElement commentInput;
	
	@FindBy(id = "comment-submit")
	private WebElement commentSubmitButton;
	
	@FindBy(xpath = "//h3[.='Recommended blogs for you']")
	private WebElement recommentVideosTitle;
	
	public void addComment(String value) {
		commentInput.sendKeys(value);
		commentSubmitButton.click();
	}
	
	public String getVideoTitle() {
		return title.getText();
	}
	
	public String getRecommendedVideoTitle() {
		return recommentVideosTitle.getText();
	}
	
	
	// will navigate to blog post page
	public void clickOnFirstRecommendedBlog(WebDriver driver, String value) {
		driver.findElement(By.xpath("//h3[.='Recommended blogs for you']/..//h3[.='" + value + "']")).click();
	}
	
	public void clickOnRecommendedBlog(WebDriver driver, String value) {
		driver.findElement(By.xpath("//h3[.='Recommended blogs for you']/..//a[.='Read Article']")).click();
	}
}
