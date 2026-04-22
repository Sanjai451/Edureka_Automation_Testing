package com.edureka.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Page Object Model class for the Search Results Page.
 * This class provides methods to interact with search results, including
 * checking results display, clicking on results, handling no results,
 * and interacting with the callback form for inquiries.
 */
public class SearchResultsPage {

    private WebDriver driver;
    private WebDriverWait wait;

    /**
     * Constructor to initialize the SearchResultsPage with WebDriver and WebDriverWait.
     * Initializes PageFactory elements.
     * @param driver The WebDriver instance to interact with the browser.
     */
    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        PageFactory.initElements(driver, this);
    }

    // List of WebElements representing the search result items
    @FindBy(xpath = "//div[contains(@class,'giTrackElement')]")
    private List<WebElement> resultList;

    // WebElement for the title of the first search result
    @FindBy(xpath = "(//div[contains(@class,'giTrackElement')]//h3)[1]")
    private WebElement firstResultTitle;

    // WebElement for the "View Details" button of the first result
    @FindBy(xpath = "(//span[contains(text(),'View Details')])[1]")
    private WebElement viewDetailsBtn;

    // List of WebElements for no result messages
    @FindBy(xpath = "//*[contains(text(),'did not match')]")
    private List<WebElement> noResultMessage;

    // WebElement for the Job Role dropdown button
    @FindBy(xpath = "//button[contains(text(),'Job Role')]")
    private WebElement jobRoleDropdown;

    // WebElement for the category heading
    @FindBy(xpath = "//h2")
    private WebElement categoryHeading;

    // By locator for callback form text
    private By callbackTextBy = By.xpath(
            "//*[contains(text(),'Tell us what you are looking for') or contains(text(),'Get a call back') or contains(text(),\"Thanks, You'll get a call soon\")]");
    // By locator for mobile number input
    private By mobileNumberBy = By.xpath("//input[@placeholder='Your mobile number']");
    // By locator for course field input
    private By courseFieldBy = By.xpath("(//*[contains(text(),'did not match')]/following::input)[2]");
    // By locator for get call back button
    private By getCallBackButtonBy = By.xpath("//button[contains(normalize-space(),'Get a call back')]");
    // By locator for success message
    private By successMessageBy = By.xpath("//span[contains(text(),'Thanks, You’ll get a call soon')]");

    /**
     * Checks if search results are displayed on the page.
     * Waits for either results or no result message to appear.
     * @return true if results are displayed, false otherwise.
     */
    public boolean areResultsDisplayed() {
        try {
            wait.until(ExpectedConditions.or(
                    ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'giTrackElement')]")),
                    ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'did not match')]"))));
        } catch (Exception e) {
            return false;
        }

        return resultList != null && resultList.size() > 0;
    }

    /**
     * Retrieves the title of the first search result.
     * @return The text of the first result title, trimmed.
     * @throws RuntimeException if the title is empty.
     */
    public String getFirstResultTitle() {
        String text = wait.until(ExpectedConditions.visibilityOf(firstResultTitle)).getText();

        if (text == null || text.trim().isEmpty()) {
            throw new RuntimeException("First result title is EMPTY");
        }

        return text.trim();
    }

    /**
     * Clicks on the "View Details" button of the first search result.
     */
    public void clickFirstResult() {
        wait.until(ExpectedConditions.elementToBeClickable(viewDetailsBtn)).click();
    }

    /**
     * Checks if the no result message is displayed.
     * @return true if no result message is present, false otherwise.
     */
    public boolean isNoResultMessageDisplayed() {
        return noResultMessage != null && noResultMessage.size() > 0;
    }

    /**
     * Checks if the callback form is displayed.
     * Waits for the mobile number field to be visible.
     * @return true if callback form is displayed, false otherwise.
     */
    public boolean isCallbackFormDisplayed() {
        try {
            // wait.until(ExpectedConditions.visibilityOfElementLocated(callbackTextBy));
            wait.until(ExpectedConditions.visibilityOfElementLocated(mobileNumberBy));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Enters the mobile number into the callback form.
     * Scrolls to the field and clears before sending keys.
     * @param mobile The mobile number to enter.
     */
    public void enterMobileNumber(String mobile) {
        WebElement field = wait.until(ExpectedConditions.presenceOfElementLocated(mobileNumberBy));

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", field);

        wait.until(ExpectedConditions.visibilityOf(field));
        wait.until(ExpectedConditions.elementToBeClickable(field));
        field.clear();
        field.sendKeys(mobile);
    }

    /**
     * Retrieves the entered mobile number from the callback form.
     * @return The value of the mobile number field, trimmed.
     */
    public String getEnteredMobileNumber() {
        WebElement field = wait.until(ExpectedConditions.presenceOfElementLocated(mobileNumberBy));

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", field);

        wait.until(ExpectedConditions.visibilityOf(field));
        return field.getAttribute("value").trim();
    }

    /**
     * Enters the course name into the callback form.
     * Scrolls to the field and clears before sending keys.
     * @param courseName The course name to enter.
     */
    public void enterCourseLookingFor(String courseName) {
        WebElement field = wait.until(ExpectedConditions.presenceOfElementLocated(courseFieldBy));

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", field);

        wait.until(ExpectedConditions.visibilityOf(field));
        wait.until(ExpectedConditions.elementToBeClickable(field));
        field.clear();
        field.sendKeys(courseName);
    }

    /**
     * Clicks the "Get a call back" button to submit the callback request.
     * Scrolls to the button before clicking using JavaScript.
     */
    public void clickGetCallBackButton() {
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(getCallBackButtonBy));

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", button);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", button);
    }

    /**
     * Checks if the callback success message is displayed.
     * @return true if success message is visible, false otherwise.
     */
    public boolean isCallBackSuccessMessageDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(successMessageBy));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Clicks on the Job Role dropdown button.
     * Uses JavaScript to click.
     */
    public void clickJobRoleDropdown() {
        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(jobRoleDropdown));

        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", dropdown);
    }

    /**
     * Selects a job role from the dropdown by its label text.
     * Scrolls to the label and clicks using JavaScript.
     * @param role The job role text to select.
     */
    public void selectJobRole(String role) {
        WebElement label = wait
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//label[normalize-space()='" + role + "']")));

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", label);

        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", label);
    }

    /**
     * Retrieves the text of the category heading.
     * @return The text of the category heading.
     */
    public String getCategoryHeading() {
        return wait.until(ExpectedConditions.visibilityOf(categoryHeading)).getText();
    }

    /**
     * Checks if a specific job role is selected.
     * Finds the input associated with the label and checks if it's selected.
     * @param role The job role text to check.
     * @return true if the role is selected, false otherwise.
     */
    public boolean isJobRoleSelected(String role) {
        WebElement label = wait.until(
                ExpectedConditions.presenceOfElementLocated(By.xpath("//label[normalize-space()='" + role + "']")));

        String inputId = label.getAttribute("for");

        WebElement input = wait.until(ExpectedConditions.presenceOfElementLocated(By.id(inputId)));

        return input.isSelected();
    }
}