package com.edureka.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.edureka.pages.SearchHomePage;
import com.edureka.pages.SearchResultsPage;

import pages.SearchResultPage;


public class Pages {
	
//	public static LoginPage loginPage;
	public static SearchHomePage shp;
	public static SearchResultsPage srp;
	
	public static void loadAllPages(WebDriver driver) {
//		loginPage = PageFactory.initElements(driver, LoginPage.class);
		shp = PageFactory.initElements(driver, SearchHomePage.class);
		srp= PageFactory.initElements(driver, SearchResultsPage.class);
		
	}
}
