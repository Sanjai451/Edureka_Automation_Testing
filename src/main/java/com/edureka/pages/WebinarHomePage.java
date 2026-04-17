package com.edureka.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebinarHomePage {
	
	WebDriver driver;
	WebDriverWait wait;

	// ─────────────────────────────────────────────────
    // CONSTRUCTOR
    // ─────────────────────────────────────────────────
	
	public WebinarHomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
//        PageFactory.initElements(driver, this);
    }
	
	/** Edureka logo */
    @FindBy(css = "a img[alt='logo']")
    private WebElement edurekaLogo;
 
    /** "Corporate Training" nav link */
    @FindBy(linkText = "Corporate Training")
    private WebElement corporateTrainingLink;
 
    /** "Courses" nav link */
    @FindBy(linkText = "Courses")
    private WebElement coursesNavLink;
    
    /** "Blog" nav link */
    @FindBy(linkText = "Blog")
    private WebElement blogNavLink;
    
    /** Main H1 heading: "Edureka! Masterclass" */
    @FindBy(css = "h1")
    private WebElement pageHeading;
    
    /** All individual upcoming webinar card headings */
    @FindBy(xpath = "//h2[contains(text(),'Upcoming Webinars')]/following-sibling::div//h3")
    private List<WebElement> upcomingWebinarTitles;
    
    /** List of all category **/
    @FindBy(xpath = "//div[@class='wl_title']//h3")
    private List<WebElement> allCategories;
    
    /** "Python" category tab heading */
    @FindBy(xpath = "//h3[contains(text(),'Python')]")
    private WebElement pythonCategoryTab;
 
    /** "Artificial Intelligence" category tab heading */
    @FindBy(xpath = "//h3[contains(text(),'Artificial Intelleg')]")
    private WebElement aiCategoryTab;
 
    /** "Data Science" category tab heading */
    @FindBy(xpath = "//h3[contains(text(),'Data Science')]")
    private WebElement dataScienceCategoryTab;
 
    /** "Machine Learning" category tab heading */
    @FindBy(xpath = "//h3[contains(text(),'Machine Learning')]")
    private WebElement machineLearningCategoryTab;
 
    /** "Deep Learning Using TensorFlow" category tab */
    @FindBy(xpath = "//h3[contains(text(),'Deep Learning')]")
    private WebElement deepLearningCategoryTab;
 
    /** "Business Intelligence (BI)" category tab */
    @FindBy(xpath = "//h3[contains(text(),'Business Intelligence')]")
    private WebElement biCategoryTab;
    
    /** All trending certification course links in the footer */
    @FindBy(xpath = "//h3[contains(text(),'Trending Certification')]/following-sibling::ul//a")
    private List<WebElement> footerTrendingCertLinks;
 
    /** All trending master course links in the footer */
    @FindBy(xpath = "//h3[contains(text(),'Trending Master')]/following-sibling::ul//a")
    private List<WebElement> footerTrendingMasterLinks;
 
    /** "About us" footer link */
    @FindBy(linkText = "About us")
    private WebElement aboutUsLink;
 
    /** "Reviews" footer link */
    @FindBy(linkText = "Reviews")
    private WebElement reviewsLink;
 
    /** "Contact us" footer link */
    @FindBy(linkText = "Contact us")
    private WebElement contactUsLink;
 
    /** "Careers" footer link */
    @FindBy(linkText = "Careers")
    private WebElement careersLink;
 
    /** "Terms & Conditions" footer link */
    @FindBy(linkText = "Terms & Conditions")
    private WebElement termsLink;
 
    /** "Legal & Privacy" footer link */
    @FindBy(linkText = "Legal & Privacy")
    private WebElement legalPrivacyLink;
    
    public String getPageTitle() {
        return driver.getTitle();
    }
    
    public void printAllUpcomingWebinarTitles() {
        wait.until(ExpectedConditions.visibilityOfAllElements(upcomingWebinarTitles));
        upcomingWebinarTitles.stream()
            .forEach(e -> System.out.println(e.getText().trim()));
    }
    
    public void printAllCategoryTitles() {
        wait.until(ExpectedConditions.visibilityOfAllElements(allCategories));
        allCategories.stream()
            .forEach(e -> System.out.println(e.getText().trim()));
    }
    
    public void clickOnWebinarCategory(WebDriver driver, String value) {
    	driver.findElement(By.xpath("//div[@class='wl_title']//h3[contains(text(),'" + value + "')]")).click();
    }
    
    public void printFooterTrendingCertCourses() {
        wait.until(ExpectedConditions.visibilityOfAllElements(footerTrendingCertLinks));
        
        footerTrendingCertLinks.stream()
            .forEach(e -> System.out.println(e.getText().trim()));
    }
    
 
}
