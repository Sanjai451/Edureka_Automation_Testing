Feature: Add Question in Edureka Community

As a logged-in user  
I want to post a question in the community  
So that I can get answers from others  

Scenario: Successfully add a question to the community
Given the user is on the Edureka homepage
When user navigates to Community section from footer link
And user clicks on Ask a Question
And user enters question details
| Title                  | Category | Description                          | Tags        |
| Selenium issue in POM  | Generative AI |Facing issue with PageFactory usage | Selenium    |
And user submits the question
Then question should be posted successfully in the forum

Scenario: Post a comment to question in the community
Given the user is on the Edureka homepage
When user navigates to Community section from footer link
# Feed quesiton name from excel 
And user clicks on question "How can I run a ‘docker exec’ command inside a docker container?"
And user should see the question fully 
And user add answer for the question
Then verify the answer is added 

Scenario: Post a comment to question in the community
Given the user is on the Edureka homepage
When user navigates to Community section from footer link
# Feed quesiton name from excel 
And user clicks on question ""
And user should see the question fully 
And user add comment for the question
Then verify the comment is added 