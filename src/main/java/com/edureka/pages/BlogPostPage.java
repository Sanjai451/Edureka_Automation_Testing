package com.edureka.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BlogPostPage {
//web element for Blog page
	@FindBy(tagName = "h1")
	private WebElement title;
	
	@FindBy(css = "[class='btn bookmark-it']")
	private WebElement bookMarkButton;
	
	@FindBy(css = "[rel='author']")
	private WebElement authorName;
	
	@FindBy(css = ".bookmark-it.active")
	private WebElement bookmarkActiveIcon;
	
	public boolean isBookMarked() {
	    return bookmarkActiveIcon.isDisplayed(); // or class contains active
	}
	
	public String getBlogTitle() {
		return title.getText();
	}
	
	public void addBookMark() {
		bookMarkButton.click();
	}
	
	public void clickOnAuthor() {
		authorName.click();
	}
}
