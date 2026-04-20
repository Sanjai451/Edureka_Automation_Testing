package com.edureka.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.edureka.pages.AllCoursePage;
import com.edureka.pages.HomePage;
import com.edureka.pages.MasterProgram;
import com.edureka.pages.SearchHomePage;
import com.edureka.pages.SearchResultsPage;
import com.edureka.pages.TrainingCourse;

public class Pages {

    public static AllCoursePage allCoursePage;
    public static MasterProgram masterProgram;
    public static TrainingCourse trainingCourse;
    public static SearchHomePage shp;
    public static HomePage homePage;
    public static SearchResultsPage srp;
    
    public static void loadAllPages(WebDriver driver) {
    	allCoursePage = new AllCoursePage();
        homePage = new HomePage(driver);
        masterProgram = new MasterProgram(driver);
        trainingCourse = new TrainingCourse(driver);

        
        
        shp = PageFactory.initElements(driver, SearchHomePage.class);
        srp = PageFactory.initElements(driver, SearchResultsPage.class);
        
        
        
    }
}