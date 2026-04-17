package com.edureka.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchHomePage {

    @FindBy(xpath = "//div[contains(@class,'navbar_search_click_bx')]")
    private WebElement searchTrigger;

    @FindBy(xpath = "//input[@name='search']")
    private WebElement searchInput;

    @FindBy(xpath = "//div[@role='dialog' and contains(@class,'show')]")
    private WebElement searchPanel;

    public boolean isSearchTriggerDisplayed() {
        return searchTrigger.isDisplayed();
    }

    public void clickSearchTrigger() {
        searchTrigger.click();
    }

    public boolean isSearchPanelDisplayed() {
        return searchPanel.isDisplayed();
    }

    public void enterKeyword(String keyword) {
        searchInput.clear();
        searchInput.sendKeys(keyword);
    }

    public String getEnteredKeyword() {
        return searchInput.getAttribute("value");
    }

    public void pressEnter() {
        searchInput.sendKeys(Keys.ENTER);
    }
}