Feature: Partner With Us - Submit partner enquiry form

  Background:
    Given user launches the browser
    And user navigates to Edureka application
    And user logs in using config credentials
    And user clicks Become a Partner link
  Scenario Outline: Verify user can submit partner form with valid details

    When user clicks Partner With Us button
    And user enters partner name "<name>"
    And user enters company name "<company>"
    And user selects training need "<training>"
    And user enters partner email "<email>"
    And user enters partner phone "<phone>"
    And user enters query "<query>"
    And user clicks partner submit button

    Then partner form should be submitted successfully

    Examples:
      | name   | company     | training            | email              | phone      | query                    |
      | Ramana | Capgemini   | For Corporate       | ramana@gmail.com   | 9876543210 | Need training details    |
      | John   | Infosys     | For Myself          | john@gmail.com     | 9123456780 | Interested in courses    |