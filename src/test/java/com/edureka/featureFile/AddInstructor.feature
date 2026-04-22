Feature: Add Instructor - Submit instructor details form

  Background:
   Given user launches the browser
    And user navigates to Edureka application
    And user logs in using config credentials
    And user clicks Become an Instructor link

  Scenario Outline: Verify user can submit instructor form with valid details

    When user enters first name "<firstName>"
    And user enters last name "<lastName>"
    And user enters mobile "<mobile>"
    And user enters email "<email>"
    And user enters course name "<course>"
    And user enters linkedin "<linkedin>"
    And user enters about course "<aboutCourse>"
    And user enters about yourself "<aboutYourself>"
    And user clicks submit button

    Then instructor form should be submitted successfully

    Examples:
      | firstName | lastName | mobile     | email                | course    | linkedin                  | aboutCourse        | aboutYourself      |
      | Ramana    | Sekar    | 9876543210 | ramana@gmail.com     | Selenium  | linkedin.com/in/ramana    | Automation course  | Trainer            |
    #  | John      | Doe      | 9123456780 | john@gmail.com       | Java      | linkedin.com/in/john      | Java course        | Developer          |