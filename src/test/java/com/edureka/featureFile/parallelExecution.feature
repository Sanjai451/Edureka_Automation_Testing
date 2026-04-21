Feature: Verify parallel execution is working 


Scenario Outline: Verify all the links works at navbar
Given the user is on the Edureka homepage
When the user clicks on "<button>" in the navigation
Then the user should be redirected to the "<link>" page

Examples:
| button | link |
| All Courses | all-course |
| Corporate Training | corporate-training |