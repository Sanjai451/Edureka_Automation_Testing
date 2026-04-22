package com.edureka.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.edureka.utility.ExtentReportManager;

/**
 * Page Object class for Blog Category page.
 * Provides methods to interact with blog category elements like pagination and article links.
 */
public class BlogCategoryPage {
	
	// WebElement for the Next page button 
	
	@FindBy(xpath = "//a[@title='Next']")
	private WebElement nextPage;
	
	// WebElement for the Previous page button
	@FindBy(xpath = "//a[@title='Previous']")
	private WebElement previousPage;
	
	// WebElement for the Current page button
	@FindBy(xpath = "//li[contains(@class, 'active') and contains(@class, 'page-item')]//a")
	private WebElement currentPage;

	public void clickOnArticles(WebDriver driver, String value) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//a[contains(.,'" + value + "')]"))).click();
	}
	
	public void goToNthPage(WebDriver driver, String value) {
		System.out.println("Page Number to Navigate : " + value);
		String currentPageNumber = currentPage.getText();
		if(! value.equals(currentPageNumber)) {
			driver.findElement(By.xpath("//li[contains(@class, 'page-item') and .='" + value + "']//a")).click();
		}
	}
	
	public void clickOnNextPage() {
		nextPage.click();
	}
	
	public void clickOnPreviousPage() {
		previousPage.click();
	}
}
