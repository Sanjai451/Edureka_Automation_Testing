package com.edureka.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.edureka.pages.HomePage;
import com.edureka.pages.SearchHomePage;
import com.edureka.pages.SearchResultsPage;

public class Pages {

    public SearchHomePage shp;
    public SearchResultsPage srp;
    public HomePage homePage;

    public Pages(WebDriver driver) {
        shp = new SearchHomePage(driver);
        srp = new SearchResultsPage(driver);
        homePage = PageFactory.initElements(driver, HomePage.class);
    }
}