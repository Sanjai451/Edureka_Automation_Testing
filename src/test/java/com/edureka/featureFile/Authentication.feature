Feature: Authentication functionality

  Background:
    Given User is on login page

  Scenario: Verify user registration using DataTable
    When User navigates to signup page
    And User enters signup details
      | email                      | number     |
      | testuser124@gmail.com      | 9875435226 |
    And User clicks on signup button
    Then Account should be created successfully

  Scenario: Verify user login using Excel data
    When User enters login credentials from Excel
    Then User should be redirected to dashboard