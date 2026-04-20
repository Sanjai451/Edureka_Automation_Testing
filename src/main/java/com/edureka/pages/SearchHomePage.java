package com.edureka.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchHomePage {
	
	

    private WebDriver driver;
    private WebDriverWait wait;

    public SearchHomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[contains(@class,'navbar_search_click_bx')]")
    private WebElement searchTrigger;

    @FindBy(xpath = "//input[@name='search']")
    private WebElement searchInput;

    public boolean isSearchTriggerDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(searchTrigger)).isDisplayed();
    }

    public void clickSearchTrigger() {

        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(searchTrigger));

        // Use JS click (avoids overlay issue)
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);

        // Wait for input to appear
        wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//input[@name='search']")
        ));
    }

    public boolean isSearchPanelDisplayed() {

        
        wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//div[@role='dialog' and contains(@class,'show')]")
        ));

        return wait.until(ExpectedConditions.visibilityOf(searchInput)).isDisplayed();
    }

    public void enterKeyword(String keyword) {
        WebElement input = wait.until(ExpectedConditions.visibilityOf(searchInput));
        input.clear();
        input.sendKeys(keyword);
    }

    public String getEnteredKeyword() {
        return wait.until(ExpectedConditions.visibilityOf(searchInput)).getAttribute("value");
    }

    public void pressEnter() {
        wait.until(ExpectedConditions.visibilityOf(searchInput)).sendKeys(Keys.ENTER);
    }

    public void clickPopularSearchByText(String keyword) {
        WebElement popular = wait.until(
            ExpectedConditions.elementToBeClickable(
                By.xpath("//ul[contains(@class,'pop_search_ul')]//a[normalize-space()='" + keyword + "']")
            )
        );
        popular.click();
    }

    public void clickCategoryByText(String category) {
        WebElement categoryElement = wait.until(
            ExpectedConditions.elementToBeClickable(
                By.xpath("//ul[contains(@class,'pop_course_cat_ul')]//a[normalize-space()='" + category + "']")
            )
        );
        categoryElement.click();
    }
}