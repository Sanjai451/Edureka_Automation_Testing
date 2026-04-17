Feature: Home page functionality 
<<<<<<< HEAD
  
Scenario: Verify logo is visible and redirects to homepage
Given the user is on the Edureka homepage
When the user clicks on the Edureka logo
Then the page should go to "https://www.edureka.co"

  
Scenario Outline: Verify all links in "Resouces" link navigates correctly
Given the user is on the homepage
When the user clicks on "<icon>" in the navigation under resources from home page
Then the user should be redirected to the "<url>" page
Then goto home page

Examples:
| icon | url | 
| blogs | blog |
| webinars | webinars |
| community | community |
=======

# use scenario outline for the below 3
>>>>>>> main

Scenario Outline: Verify all the links works at navbar
Given the user is on the Edureka homepage
When the user clicks on "<button>" in the navigation
Then the user should be redirected to the "<link>" page

Examples:
| button | link |
| All Courses | all-course |
| Corporate Training | corporate-training |
<<<<<<< HEAD


# Requires log in - negative scenario
#Scenario: Verify "forum" link navigates correctly
#Given the user is on the homepage
#When the user clicks on "forum" in the navigation under community
#Then the user should be redirected to the "forum" page
=======
	

Scenario: Verify logo is visible and redirects to homepage
Given the user is on the Edureka homepage
When the user clicks on the Edureka logo
Then the page should reload to "https://www.edureka.co/"
	    
Scenario: Verify all links in "Resouces" link navigates correctly
Given the user is on the homepage
When the user clicks on "blogs" in the navigation under resources from home page
Then the user should be redirected to the "blogs" page
When the user clicks on "webinars" in the navigation  under resources from home page
Then the user should be redirected to the "webinars" page
When the user clicks on "community" in the navigation under resources from home page
Then the user should be redirected to the "community" page
	  

# This requires login
#	Scenario: Verify "Refer" link navigates correctly
#	    Given the user is on the homepage
#	    When the user clicks on "Refer" in the navigation
#	    Then the user should be redirected to the "refer" page
>>>>>>> main
 