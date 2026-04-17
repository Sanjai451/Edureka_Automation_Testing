package com.edureka.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AllCoursePage {

public void clickOnCategory(WebDriver driver, String value) {
driver.findElement(By.xpath("//a[.='" +  value + "']")).click();
}

public void clickOnCourse(WebDriver driver, String value) {
driver.findElement(By.xpath("//h2[.='" +  value + "']")).click();
}
}

