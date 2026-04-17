package com.edureka.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.edureka.pages.HomePage;
import com.edureka.pages.SearchHomePage;
import com.edureka.pages.SearchResultsPage;


public class Pages {
	
	public static HomePage homePage;
//	public static WebinarCategoryPage webinarCategoryPage;
//	public static WebinarHomePage webinarHomePage;
//	public static CorporateTrainingPage corporateTrainingPage;
	public static SearchHomePage shp;
	public static SearchResultsPage srp;
	
	public static void loadAllPages(WebDriver driver) {
		homePage = PageFactory.initElements(driver, HomePage.class);
		shp = PageFactory.initElements(driver, SearchHomePage.class);
		srp = PageFactory.initElements(driver, SearchResultsPage.class);
//		webinarCategoryPage = PageFactory.initElements(driver, WebinarCategoryPage.class);
//		webinarHomePage = PageFactory.initElements(driver, WebinarHomePage.class);
//		corporateTrainingPage = PageFactory.initElements(driver, CorporateTrainingPage.class);
	}
}
