Feature: My Orders and Invoices - View and navigate orders

  Background:
    Given user launches the browser
    And user navigates to Edureka application
    And user logs in using config credentials
    And user navigates to My Profile
    And user clicks on My Orders and Invoices

  Scenario: Verify no enrolled courses message
    Then no courses message should be displayed
    And message should indicate no enrolled courses
    When user clicks Browse All Courses button
    Then user validates redirection
      | expectedUrlPart |
      | all-courses     |

 