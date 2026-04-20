Feature: Personalize - Complete User Profile Setup

  Background:
    Given user launches the browser
    And user navigates to Edureka application
    And user logs in using config credentials
    And user navigates to My Profile
    And user clicks on Personalize tab

  Scenario: Complete Personalize Flow with Excel Data
  # USER DETAILS
    When user clicks edit for user details
    And user reads personal details from excel
    And user fills all user details from excel
    And user clicks Save and Continue
  # LEARNING GOALS
    And user clicks edit for learning goals
    And user reads learning goal from excel
    And user selects learning goal from excel
    And user clicks Save and Continue
  # STUDY PLAN
    And user clicks edit for study plan
    And user reads study plan data from excel
    And user fills study plan from excel
    And user clicks Save
    And all entered data should be displayed correctly in profile

  Scenario: Verify invalid characters are restricted in designation
    When user clicks edit for user details
    And user reads invalid designation from excel
    And user enters invalid designation from excel
    And user clicks Save and Continue
    Then system should not accept invalid designation
