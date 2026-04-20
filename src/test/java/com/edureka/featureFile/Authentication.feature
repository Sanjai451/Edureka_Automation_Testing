Feature: Authentication functionality

  Scenario: Verify user registration using DataTable
    When User navigates to signup page
    And User enters signup details
      | email                 | number     |
      | testuser128@gmail.com | 9874535226 |
    And User clicks on signup button
    Then Account should be created successfully

  Scenario: Verify show password icon works on login page
    Given User is on login page
    When User enters password in login form
    And User clicks on show password icon
    Then Password should be visible

  Scenario: Verify user login using Excel data
    Given User is on login page
    When User enters login credentials from Excel
    Then User should be redirected to dashboard