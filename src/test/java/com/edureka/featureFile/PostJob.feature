Feature: Post Job - Submit job details form

  Background:
    Given user launches the browser
    And user navigates to Edureka application
    And user logs in using config credentials
    And user clicks Hire from Edureka link

  Scenario Outline: Verify user can post a job with valid details
    When user enters job title "<jobTitle>"
    And user enters number of vacancies "<vacancies>"
    And user enters job description "<jobDescription>"
    And user enters candidate profile "<candidateProfile>"
    And user selects work experience
    And user enters minimum salary "<minSalary>"
    And user enters maximum salary "<maxSalary>"
    And user selects country "<country>"
    And user enters the company name "<companyName>"
    And user enters the first name "<firstName>"
    And user enters the last name "<lastName>"
    And user enters the mobile "<mobile>"
    And user enters the email "<email>"
    And user enters company url "<companyUrl>"
    And user clicks post job button
   

    Examples:
      | jobTitle    | vacancies | jobDescription   | candidateProfile  | minSalary | maxSalary | companyName | firstName | lastName | mobile     | email            | companyUrl      | country |
      | QA Engineer | 2         | Testing job role | Automation tester | 30000     | 60000     | TCS         | Ramana    | Sekar    | 9876543210 | ramana@gmail.com | https://tcs.com |Albania   |