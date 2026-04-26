package com.edureka.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Page Object Model class for the Webinar Home Page of the Edureka website.
 * This class encapsulates all the web elements and actions related to the webinar home page,
 * including navigation links, webinar categories, upcoming webinars, and footer elements.
 */
public class WebinarHomePage {
	
	WebDriver driver;
	WebDriverWait wait;

	// ─────────────────────────────────────────────────
    // CONSTRUCTOR
    // ─────────────────────────────────────────────────
	
	/**
	 * Constructor for WebinarHomePage.
	 * Initializes the WebDriver and WebDriverWait instances.
	 * PageFactory is commented out, so elements are not initialized automatically.
	 * @param driver the WebDriver instance to be used for interacting with the page
	 */
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
    
    @FindBy(xpath = "//h2[contains(text(),'Upcoming Webinars')]")
    private List<WebElement> upComingWebinarTitle;
    
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
    
    /**
     * Gets the title of the current page.
     * @return the page title as a String
     */
    public String getPageTitle() {
        return driver.getTitle();
    }
    
    /**
     * Gets the list of web elements for the "Upcoming Webinars" title.
     * @return List of WebElement representing the upcoming webinar title
     */
    public List<WebElement> getUpcomingWebinarsTitles(){
    	return upComingWebinarTitle;
    }
    
    /**
     * Prints all upcoming webinar titles to the console.
     * Waits for the elements to be visible before printing.
     */
    public void printAllUpcomingWebinarTitles() {
        wait.until(ExpectedConditions.visibilityOfAllElements(upcomingWebinarTitles));
        upcomingWebinarTitles.stream()
            .forEach(e -> System.out.println(e.getText().trim()));
    }
    
    /**
     * Prints all category titles to the console.
     * Waits for the elements to be visible before printing.
     */
    public void printAllCategoryTitles() {
        wait.until(ExpectedConditions.visibilityOfAllElements(allCategories));
        allCategories.stream()
            .forEach(e -> System.out.println(e.getText().trim()));
    }
    
    /**
     * Gets the list of all webinar category elements.
     * @return List of WebElement representing all webinar categories
     */
    public List<WebElement> getAllWebinarsCategory() {
    	return allCategories;
    }
    
    /**
     * Clicks on a webinar category based on the provided value.
     * @param driver the WebDriver instance
     * @param value the text value of the category to click
     */
    public void clickOnWebinarCategory(WebDriver driver, String value) {
    	driver.findElement(By.xpath("//div[@class='wl_title']//h3[contains(text(),'" + value + "')]")).click();
    }
    
    /**
     * Prints all trending certification course links in the footer to the console.
     * Waits for the elements to be visible before printing.
     */
    public void printFooterTrendingCertCourses() {
        wait.until(ExpectedConditions.visibilityOfAllElements(footerTrendingCertLinks));
        
        footerTrendingCertLinks.stream()
            .forEach(e -> System.out.println(e.getText().trim()));
    }
    
 
}
