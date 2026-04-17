package com.edureka.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

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

	public void clickConnectWithUs() {
		connectWithUs.click();
	}

	public void selectOptions(String value) {
		Select select = new Select(selectTrainingNeed);
		select.selectByVisibleText(value);
	}

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

	public void printAllCurriculums() {
		System.out.println("===== Available Curriculums =====");

		listOfCurriculums.stream().forEach(System.out::println);
		
	}
}
