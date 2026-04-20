Feature: Add Question in Edureka Community

As a logged-in user  
I want to post a question in the community  
So that I can get answers from others  

Background:
Given user logs in for performing action in community page

Scenario: Successfully add a question to the community
Given the user is on the Edureka homepage
When user navigates to Community section from footer link
And user clicks on Ask a Question
And user enters question details
| Title                  | Category | Description                          | Tags        |
| Selenium issue in POM  | Generative AI |Facing issue with PageFactory usage | Selenium    |
And user submits the question
Then question should be posted successfully in the forum
