Feature: Topics of Interest - Manage User Preferences

  Background:
    Given user launches the browser
    And user navigates to Edureka application
    And user logs in using config credentials
    And user navigates to My Profile
    And user clicks on Topics of Interest tab

  Scenario: Verify complete topics selection flow
    When user clicks Add Now button
    And user reads topics from excel
    And user selects topics from excel
    And user clicks Save and Continue in Topics
    Then topics should be saved successfully
    And topics should persist after page refresh
