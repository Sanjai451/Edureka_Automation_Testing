package com.edureka.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.edureka.pages.SearchHomePage;
import com.edureka.pages.SearchResultsPage;

import pages.SearchResultPage;
import com.edureka.pages.HomePage;


public class Pages {
  
	public static SearchHomePage shp;
	public static SearchResultsPage srp;
  public static HomePage homePage;
	
	public static void loadAllPages(WebDriver driver) {
		shp = PageFactory.initElements(driver, SearchHomePage.class);
		srp = PageFactory.initElements(driver, SearchResultsPage.class);
		homePage = PageFactory.initElements(driver, HomePage.class);
	}
}
