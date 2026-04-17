package com.edureka.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.edureka.pages.HomePage;
import com.edureka.pages.WebinarCategoryPage;
import com.edureka.pages.WebinarHomePage;


public class Pages {
	
	public static HomePage homePage;
	public static WebinarCategoryPage webinarCategoryPage;
	public static WebinarHomePage webinarHomePage;
	
	public static void loadAllPages(WebDriver driver) {
		homePage = PageFactory.initElements(driver, HomePage.class);
		webinarCategoryPage = PageFactory.initElements(driver, WebinarCategoryPage.class);
		webinarHomePage = PageFactory.initElements(driver, WebinarHomePage.class);
	}
}
