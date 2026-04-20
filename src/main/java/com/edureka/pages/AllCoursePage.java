package com.edureka.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AllCoursePage {
	
	WebDriver driver;
	
	
//	public void clickOnCategory(WebDriver driver, String value) {
//		driver.findElement(By.xpath("//a[.='" + value + "']")).click();
//	}
//
//	public void clickOnCourse(WebDriver driver, String value) {
//		driver.findElement(By.xpath("//h2[.='" + value + "']")).click();
//	}


    public void clickOnCategory(WebDriver driver, String value) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement category = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//a[normalize-space()='" + value + "']")
                )
        );

        category.click();
    }
    
    public void clickOnCourse(WebDriver driver, String value) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        String xpath = "//h2[contains(.,'" + value + "')]";
        
        WebElement course =  driver.findElement(By.xpath(xpath));
        
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", course);

//        WebElement course = wait.until(
//                ExpectedConditions.elementToBeClickable(By.xpath(xpath))
//        );

        
        course.click();
    }
}
