Feature: Change Password - Update user password functionality

  Background:
    Given user launches the browser
    And user navigates to Edureka application
    And user logs in using config credentials
    And user navigates to My Profile
    And user clicks on Change Password tab


  Scenario: Verify user can change password using DataTable

    When user enters password details
      | existingPassword | oldPass123 |
      | newPassword      | NewPass@123 |
      | confirmPassword  | NewPass@123 |
    And user clicks Submit button

    Then password should be updated successfully


  Scenario Outline: Verify password validation scenarios

    When user enters existing password "<existing>"
    And user enters new password "<new>"
    And user enters confirm password "<confirm>"
    And user clicks Submit button

    Then "<message>" should be displayed

    Examples:
      | existing    | new         | confirm     | message              |
      | wrong123    | New@123     | New@123     | incorrect password   |
      | oldPass123  | New@123     | Wrong@123   | password mismatch    |
      | oldPass123  | short       | short       | password policy      |
      |             |             |             | required field       |
