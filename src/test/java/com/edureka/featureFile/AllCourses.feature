Feature: All Courses Module


 Scenario: Verify All Courses page loads correctly
    Given user is on homepage
    When user clicks on "All Courses"
    Then all courses page should be displayed
    And course list should be visible

  Scenario: Verify courses are opening from all course page
    Given user is on homepage
    When user clicks on "All Courses"
    And user selects course "Tableau Certification Training Course"
    And URL should contain "tableau"

  Scenario Outline: Verify Courses are opening from All Course
    Given user is on homepage
    When user clicks on "All Courses"
    When user selects course "<course>"
    Then user should be navigated to course page
    And course title should be displayed correctly
    And URL should contain "<urlPart>"

    Examples:
      | course                                | urlPart |
      | Tableau Certification Training Course | tableau |

  Scenario: Verify courses can be enrolled using Excel data
    Given user is on homepage
    When user clicks on "All Courses"
    When user selects course from excel
    Then user should be navigated to course page
    And course title should be displayed correctly
    And user needs to click on enroll button using excel data
    And verify user is on payment page

  Scenario: Preview sample certificate from course page
    Given user is on homepage
    When user clicks on "All Courses"
    When user selects course
      | course                                |
      | Tableau Certification Training Course |
    Then user should be navigated to course page
    And course title should be displayed correctly
    When user scrolls to preview certificate section
    And user clicks on preview certificate button
    And user fills certificate details
      | name      | email              | phone      |
      | Test User | testuser123@gmail.com | 9876543210 |
    Then certificate success message should be displayed

  Scenario: Verify behavior when wishlist is not updated
    Given user is on homepage
    When user logs in to add course in wishlists
    And user clicks on "All Courses"
    And user selects course "Tableau Certification Training Course"
    When user adds course to wishlist
    Then course should appear in wishlist "Tableau Certification Training Course"



