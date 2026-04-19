Feature: All Courses Module


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