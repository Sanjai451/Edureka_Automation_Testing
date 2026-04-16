package com.edureka.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyProfile {

	// ================= NAVIGATION =================

	@FindBy(linkText = "Personalize")
	private WebElement personalizeTab;

	@FindBy(linkText = "Topics of Interest")
	private WebElement topicsOfInterestTab;

	@FindBy(linkText = "Career Services")
	private WebElement careerServicesTab;

	@FindBy(linkText = "Change Password")
	private WebElement changePasswordTab;

	@FindBy(linkText = "My Orders and Invoices")
	private WebElement myOrdersLink;

	// ================= EDIT BUTTONS =================

	@FindBy(xpath = "//h4[contains(text(),'User Details')]/ancestor::div[contains(@class,'details-heading')]//a")
	private WebElement userDetailsEdit;

	@FindBy(xpath = "//h4[contains(text(),'Learning Goals')]/ancestor::div[contains(@class,'details-heading')]//a")
	private WebElement learningGoalsEdit;

	@FindBy(xpath = "//h4[contains(text(),'Study Plan')]/ancestor::div[contains(@class,'details-heading')]//a")
	private WebElement studyPlanEdit;

	// ================= USER DETAILS VALUES =================

	@FindBy(xpath = "//span[text()='Name']/following-sibling::span")
	private WebElement nameValue;

	@FindBy(xpath = "//span[text()='Mobile']/following-sibling::span")
	private WebElement mobileValue;

	@FindBy(xpath = "//span[text()='Contact Email']/following-sibling::span")
	private WebElement emailValue;

	@FindBy(xpath = "//span[text()='Current TimeZone']/following-sibling::span")
	private WebElement currentTimezoneValue;

	// ================= PREFERRED TIME =================

	@FindBy(xpath = "//span[text()='Timezone']/following-sibling::span")
	private WebElement preferredTimezoneValue;

	@FindBy(xpath = "//span[text()='Weekdays']/following-sibling::span")
	private WebElement weekdaysValue;

	@FindBy(xpath = "//span[text()='Weekends']/following-sibling::span")
	private WebElement weekendsValue;

	// ================= LEARNING GOALS =================

	@FindBy(xpath = "//h4[contains(text(),'Learning Goals')]/following::span[contains(@class,'skill')]")
	private List<WebElement> learningGoalsList;

	// ================= REMINDER BUDDY =================

	@FindBy(xpath = "//span[text()='Partner's Name']/following-sibling::span")
	private WebElement partnerName;

	@FindBy(xpath = "//span[text()='Partner's Mobile']/following-sibling::span")
	private WebElement partnerMobile;

	@FindBy(xpath = "//span[text()='Partner's Email']/following-sibling::span")
	private WebElement partnerEmail;

	// ================= STUDY PLAN =================

	@FindBy(xpath = "//h4[contains(text(),'Study Plan')]/following::div[contains(text(),'Day')]")
	private WebElement studyDay;

	@FindBy(xpath = "//h4[contains(text(),'Study Plan')]/following::span[contains(text(),'AM') or contains(text(),'PM')]")
	private WebElement studyTime;

	// ================= PROFILE IMAGE =================

	@FindBy(css = "i.icon-camera")
	private WebElement cameraIcon;

	@FindBy(id = "custom-input")
	private WebElement uploadInput;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement uploadBtn;

	// ================= GETTERS =================

	public WebElement getPersonalizeTab() {
		return personalizeTab;
	}

	public WebElement getTopicsOfInterestTab() {
		return topicsOfInterestTab;
	}

	public WebElement getCareerServicesTab() {
		return careerServicesTab;
	}

	public WebElement getChangePasswordTab() {
		return changePasswordTab;
	}

	public WebElement getMyOrdersLink() {
		return myOrdersLink;
	}

	public WebElement getUserDetailsEdit() {
		return userDetailsEdit;
	}

	public WebElement getLearningGoalsEdit() {
		return learningGoalsEdit;
	}

	public WebElement getStudyPlanEdit() {
		return studyPlanEdit;
	}

	// ================= BUSINESS METHODS =================

	public void clickPersonalize() {
		personalizeTab.click();
	}

	public void clickTopicsOfInterest() {
		topicsOfInterestTab.click();
	}

	public void clickCareerServices() {
		careerServicesTab.click();
	}

	public void clickChangePassword() {
		changePasswordTab.click();
	}

	public void clickMyOrders() {
		myOrdersLink.click();
	}

	public void clickUserDetailsEdit() {
		userDetailsEdit.click();
	}

	public void clickLearningGoalsEdit() {
		learningGoalsEdit.click();
	}

	public void clickStudyPlanEdit() {
		studyPlanEdit.click();
	}

	public void uploadProfileImage(String filePath) {
		uploadInput.sendKeys(filePath);
		uploadBtn.click();
	}

	public void clickCameraIcon() {
		cameraIcon.click();
	}

	// ================= VALUE GETTERS =================

	public String getName() {
		return nameValue.getText().trim();
	}

	public String getMobile() {
		return mobileValue.getText().trim();
	}

	public String getEmail() {
		return emailValue.getText().trim();
	}

	public String getCurrentTimezone() {
		return currentTimezoneValue.getText().trim();
	}

	public String getPreferredTimezone() {
		return preferredTimezoneValue.getText().trim();
	}

	public String getWeekdays() {
		return weekdaysValue.getText().trim();
	}

	public String getWeekends() {
		return weekendsValue.getText().trim();
	}

	public String getPartnerName() {
		return partnerName.getText().trim();
	}

	public String getPartnerMobile() {
		return partnerMobile.getText().trim();
	}

	public String getPartnerEmail() {
		return partnerEmail.getText().trim();
	}

	public String getStudyDay() {
		return studyDay.getText().trim();
	}

	public String getStudyTime() {
		return studyTime.getText().trim();
	}

	public List<WebElement> getLearningGoalsList() {
		return learningGoalsList;
	}

	// ================= VALIDATIONS (VERY IMPORTANT) =================

	public boolean verifyUserDetails(String name, String mobile, String email, String timezone) {
		return getName().equalsIgnoreCase(name) && getMobile().contains(mobile) && getEmail().equalsIgnoreCase(email)
				&& getCurrentTimezone().equalsIgnoreCase(timezone);
	}

	public boolean verifyPreferredTime(String timezone, String weekdays, String weekends) {
		return getPreferredTimezone().equalsIgnoreCase(timezone) && getWeekdays().equalsIgnoreCase(weekdays)
				&& getWeekends().equalsIgnoreCase(weekends);
	}

	public boolean verifyLearningGoal(String expectedGoal) {
		for (WebElement goal : learningGoalsList) {
			if (goal.getText().equalsIgnoreCase(expectedGoal)) {
				return true;
			}
		}
		return false;
	}

	public boolean verifyStudyPlan(String expectedDay, String expectedTime) {
		return getStudyDay().contains(expectedDay) && getStudyTime().equalsIgnoreCase(expectedTime);
	}

	public boolean verifyReminderBuddyEmpty() {
		return getPartnerName().equalsIgnoreCase("Not Available")
				&& getPartnerMobile().equalsIgnoreCase("Not Available")
				&& getPartnerEmail().equalsIgnoreCase("Not Available");
	}
}