package com.edureka.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommunityQuestionPage {

	// upvote on the question - First Upvote button
	@FindBy(xpath = "//button[@title='Click to vote up']")
	private WebElement upVoteButton;
	
	@FindBy(id = "q_doanswer")
	private WebElement answerButton;
	
	@FindBy(xpath = "//button[contains(text(), 'comment')]")
	private WebElement commentButton;
	
	@FindBy(xpath = "//button[contains(text(), 'Add comment')]")
	private WebElement postCommentButton;

	@FindBy(xpath = "//button[contains(text(), 'Add answer')]")
	private WebElement postAnswerButton;
	public void addAnswerForQuestion(WebDriver driver, String answer) {
		answerButton.click();
		addTextToFrame(driver, answer);
		postAnswerButton.click();
	}
	
	public void addCommentForQuestion(WebDriver driver, String comment) {
		commentButton.click();
		addTextToFrame(driver, comment);
		postCommentButton.click();
	}
	
	
	private void addTextToFrame(WebDriver driver, String answerText) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
	    
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        try {            
            // Scroll down to the "Your answer" section
            WebElement answerSection = wait.until(
                ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.answer-section, .answer-form, form"))
            );
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", answerSection);
            
            Thread.sleep(1000);
            
            System.out.println("Scrolled to answer section");

            List<WebElement> iframes = driver.findElements(By.tagName("iframe"));
            // System.out.println("Total iframes found: " + iframes.size());

            // Loop through each iframe to find CKEditor body
            
            for (int i = 0; i < iframes.size(); i++) {
                try {
                    // Switch into iframe by index
                    driver.switchTo().defaultContent();
                    driver.switchTo().frame(i);

                    // Check if this iframe has a cke_editable body
                    List<WebElement> bodies = driver.findElements(By.cssSelector("body.cke_editable"));
                    if (!bodies.isEmpty()) {
                        System.out.println("CKEditor found at iframe index: " + i);

                        js.executeScript(
                            "var body = document.querySelector('body.cke_editable');" +
                            "body.focus();" +
                            "body.innerHTML = '<p>" + answerText + "</p>';"
                        );

                        System.out.println("Text entered successfully: " + answerText);
                        break;
                    }
                } catch (Exception e) {
                    System.out.println("iframe " + i + " skipped: " + e.getMessage());
                }
            }

            // Always switch back to main page
            driver.switchTo().defaultContent();
            Thread.sleep(3000); // Pause so you can see the result in browser

        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
            e.printStackTrace();
        } finally {
        	System.out.println("Test completed. Browser left open for inspection.");
        }
	}
	
	
	
}
