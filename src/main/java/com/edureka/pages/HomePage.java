package com.edureka.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
    
    @FindBy(xpath = "//input[@placeholder='Search courses']")
    WebElement homeSearchBar;

    
    public void clickHomeSearchBar() {
        homeSearchBar.click();
    }

    public void enterKeywordInHomeSearchBar(String value) {
        homeSearchBar.sendKeys(value);
    }
    
    public void clickOnCategory(WebDriver driver, String value) {
		driver.findElement(By.xpath("//a[.='" +  value + "']")).click();
	}
	
	public void clickOnCourse(WebDriver driver, String value) {
		driver.findElement(By.xpath("//h2[.='" +  value + "']")).click();
	}

}