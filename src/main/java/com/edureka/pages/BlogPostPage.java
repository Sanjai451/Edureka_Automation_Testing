package com.edureka.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BlogPostPage {

	@FindBy(tagName = "h1")
	private WebElement title;
	
	@FindBy(css = "[class='btn bookmark-it']")
	private WebElement bookMarkButton;
	
	@FindBy(css = "[rel='author']")
	private WebElement authorName;
	
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
