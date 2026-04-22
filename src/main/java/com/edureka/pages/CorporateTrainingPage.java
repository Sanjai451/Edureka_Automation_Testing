package com.edureka.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

/**
 * Page Object Model class for the Corporate Training Page of the Edureka website.
 * This class handles interactions with the corporate training page, including
 * filling out contact forms and displaying available curriculums.
 */
public class CorporateTrainingPage {

	@FindBy(xpath = "//button[text()='CONNECT WITH US']")
	private WebElement connectWithUs;

	@FindBy(name = "first_name")
	private WebElement nameField;

	@FindBy(name = "email")
	private WebElement emailField;

	@FindBy(name = "phone")
	private WebElement phoneNumberField;

	@FindBy(name = "organization")
	private WebElement companyNameField;

	@FindBy(name = "query")
	private WebElement queryField;

	@FindBy(id = "learnerCount")
	private WebElement selectTrainingNeed;

	@FindBy(xpath = "//button[.='Submit']")
	private WebElement submitButton;

	@FindBy(xpath = "//div[@id='mCSB_1_container']//a")
	private List<WebElement> listOfCurriculums;

	/**
	 * Clicks the "CONNECT WITH US" button to initiate contact.
	 */
	public void clickConnectWithUs() {
		connectWithUs.click();
	}

	/**
	 * Selects an option from the training need dropdown by visible text.
	 * @param value the visible text of the option to select
	 */
	public void selectOptions(String value) {
		Select select = new Select(selectTrainingNeed);
		select.selectByVisibleText(value);
	}

	/**
	 * Fills out and submits the corporate training contact form with the provided details.
	 * Clears existing values before entering new ones and selects training need from dropdown.
	 * @param name the full name to enter
	 * @param email the email address to enter
	 * @param phoneNumber the phone number to enter
	 * @param trainingNeeded the training need to select from dropdown
	 * @param companyName the company name to enter
	 * @param query the query or message to enter
	 */
	public void submitDetails(String name, String email, String phoneNumber, String trainingNeeded, String companyName,
			String query) {
		// Enter Name
		nameField.clear();
		nameField.sendKeys(name);

		// Enter Email
		emailField.clear();
		emailField.sendKeys(email);

		// Enter Phone
		phoneNumberField.clear();
		phoneNumberField.sendKeys(phoneNumber);

		// Select Training Need
		selectOptions(trainingNeeded);

		// Enter Company Name
		companyNameField.clear();
		companyNameField.sendKeys(companyName);

		// Enter Query
		queryField.clear();
		queryField.sendKeys(query);

		// Submit Form
		submitButton.click();
	}

	/**
	 * Prints all available curriculums to the console.
	 * Displays a header before listing each curriculum.
	 */
	public void printAllCurriculums() {
		System.out.println("===== Available Curriculums =====");

		listOfCurriculums.stream().forEach(System.out::println);
		
	}
}
