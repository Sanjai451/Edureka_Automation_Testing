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


Scenario: Verify behavior when wishlist is not updated
 Given user is on homepage
  When user clicks on "All Courses"
  When user selects course "<course>"
  Then user should be navigated to course page
  And course title should be displayed correctly
  And URL should contain "<urlPart>"

Examples:
  | course                     | urlPart      |
  | Tableau Certification Training Course | tableau |



Scenario: Verify courses can be enrolled 
 Given user is on homepage
  When user clicks on "All Courses"
  When user selects course "<course>"
  Then user should be navigated to course page
  And course title should be displayed correctly
  And URL should contain "<urlPart>"
  And user needs to click on enroll button
  And verify user is on payment page
  
Examples:
  | course                     | urlPart      |
  | Tableau Certification Training Course | tableau |


Scenario: Fill training query form after scrolling to it
 Given user is on homepage
  When user clicks on "All Courses"
  When user selects course "<course>"
  Then user should be navigated to course page
  And course title should be displayed correctly
  When user scrolls to training form
  And user fills training form details
  Then form should be submitted successfully
Examples:
  | course                     | urlPart      |
  | Tableau Certification Training Course | tableau |



Scenario: Preview sample certificate from course page
 Given user is on homepage
  When user clicks on "All Courses"
  When user selects course "<course>"
  Then user should be navigated to course page
  And course title should be displayed correctly
  When user scrolls to preview certificate section
  And user clicks on preview certificate button
  And user fills certificate details
  Then certificate success message should be displayed
 Examples:
  | course                     | urlPart      |
  | Tableau Certification Training Course | tableau |
