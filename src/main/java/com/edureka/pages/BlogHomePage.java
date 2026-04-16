package com.edureka.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BlogHomePage {
	
	@FindBy(css = "[href='https://www.edureka.co/blog/videos/']")
	private WebElement videos;
	
	@FindBy(css = "[href='https://www.edureka.co/blog/interview-questions/']")
	private WebElement interViewQuestions;
	
	@FindBy(css = "[href='https://www.edureka.co/blog/cheatsheets/']")
	private WebElement cheatSheets;
	
	@FindBy(css = "[href='https://www.edureka.co/blog/ebook/']")
	private WebElement eBooks;
	
	@FindBy(xpath = "//a[@title='Next']")
	private WebElement nextPage;
	
	@FindBy(xpath = "//a[@title='Previous']")
	private WebElement previousPage;
	
	@FindBy(xpath = "//li[contains(@class, 'active') and contains(@class, 'page-item')]//a")
	private WebElement currentPage;

	public void clickOnCategory(WebDriver driver, String value) {
		driver.findElement(By.xpath("//h3[text()='" + value + "']")).click();
	}
	
	public void clickOnArticles(WebDriver driver, String value) {
		driver.findElement(By.xpath("//a[text()='" + value + "']")).click();
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
	
	public void clickOnVideo() {
		videos.click();
	}
	
	public void clickOnCheatSheet() {
		cheatSheets.click();
	}
	//
	public void clickOnInterviewQuestion() {
		interViewQuestions.click();
	}
	
	public void clickOnEBooks() {
		eBooks.click();
	}
	
	
}
