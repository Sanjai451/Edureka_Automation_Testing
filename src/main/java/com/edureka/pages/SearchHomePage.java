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

/**
 * Page Object Model class for the Search functionality on the Home Page.
 * This class provides methods to interact with search elements such as
 * search trigger, search input, popular searches, and categories.
 */
public class SearchHomePage {

    private WebDriver driver;
    private WebDriverWait wait;

    /**
     * Constructor to initialize the SearchHomePage with WebDriver and WebDriverWait.
     * @param driver The WebDriver instance to interact with the browser.
     */
    public SearchHomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        
    }

  
    @FindBy(xpath = "//div[contains(@class,'navbar_search_click_bx')]")
    private WebElement searchTrigger;

    private By searchInputBy = By.xpath("//input[contains(@id,'search') or contains(@placeholder,'Search')]");

    @FindBy(xpath = "//input[@name='search']")
    private WebElement searchInput;

    /**
     * Checks if the search trigger element is displayed on the page.
     * @return true if the search trigger is visible, false otherwise.
     */
    public boolean isSearchTriggerDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(searchTrigger)).isDisplayed();
    }

    /**
     * Clicks on the search trigger to open the search panel.
     */
    public void clickSearchTrigger() {

        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(searchTrigger));
        element.click();
    }

    /**
     * Checks if the search input panel is displayed.
     * @return true if the search input is visible, false otherwise.
     */
    public boolean isSearchPanelDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(searchInputBy)).isDisplayed();
    }

    /**
     * Enters a keyword into the search input field.
     * @param keyword The search keyword to enter.
     */
    public void enterKeyword(String keyword) {
        WebElement input = wait.until(ExpectedConditions.visibilityOf(searchInput));
        input.clear();
        input.sendKeys(keyword);
    }

    /**
     * Retrieves the currently entered keyword from the search input field.
     * @return The value entered in the search input field.
     */
    public String getEnteredKeyword() {
    	
        return wait.until(ExpectedConditions.visibilityOfElementLocated(searchInputBy))
                   .getAttribute("value");
    }

    /**
     * Presses the Enter key in the search input field to perform the search.
     */
    public void pressEnter() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchInputBy))
            .sendKeys(Keys.ENTER);
    }



    /**
     * Clicks on a popular search link by its text.
     * @param keyword The text of the popular search link to click.
     */
    public void clickPopularSearchByText(String keyword) {
        WebElement popular = wait.until(
            ExpectedConditions.elementToBeClickable(
                By.xpath("//ul[contains(@class,'pop_search_ul')]//a[normalize-space()='" + keyword + "']")
            )
        );
        popular.click();
    }

    /**
     * Clicks on a category link by its text.
     * @param category The text of the category link to click.
     */
    public void clickCategoryByText(String category) {
        WebElement categoryElement = wait.until(
            ExpectedConditions.elementToBeClickable(
                By.xpath("//ul[contains(@class,'pop_course_cat_ul')]//a[normalize-space()='" + category + "']")
            )
        );
        categoryElement.click();
    }
}