Feature: My Wallet - View balance and credits

  Background:
    Given user launches the browser
    And user navigates to Edureka application
    And user logs in using config credentials
    And user navigates to My Profile
    And user clicks on My Wallet

  Scenario: Verify wallet details are displayed
    Then account balance section should be displayed
    And promotional credits section should be displayed
    And referral credits section should be displayed
    Then account balance amount should be displayed
    And account balance should be in valid format
    Then promotional credits amount should be displayed
    And promotional credits value should be valid
    Then referral credits amount should be displayed
    And referral credits value should be valid
