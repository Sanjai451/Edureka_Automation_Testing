package com.edureka.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BlogVideoPage {
	
	public void clickOnVideo(WebDriver driver, String value) {
		driver.findElement(By.xpath("//a[text()='" + value + "']")).click();
	}
	
}
