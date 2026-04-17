package com.edureka.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchHomePage {

    private WebDriver driver;

    public SearchHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[contains(@class,'navbar_search_click_bx')]")
    private WebElement searchTrigger;

    @FindBy(xpath = "//div[@role='dialog' and contains(@class,'show')]")
    private WebElement searchPanel;

    public boolean isSearchTriggerDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOf(searchTrigger)).isDisplayed();
    }

    public void clickSearchTrigger() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(searchTrigger)).click();
    }

    public boolean isSearchPanelDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOf(searchPanel)).isDisplayed();
    }

    public void enterKeyword(String keyword) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement input = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='search']"))
        );

        input.clear();
        input.sendKeys(keyword);
    }

    public String getEnteredKeyword() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement input = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='search']"))
        );

        return input.getAttribute("value");
    }

    public void pressEnter() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement input = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='search']"))
        );

        input.sendKeys(Keys.ENTER);
    }
}