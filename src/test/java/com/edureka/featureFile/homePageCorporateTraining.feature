Feature: Corporate Training Form Submission

As a user
I want to connect with Edureka for corporate training
So that I can submit my training requirements

Scenario: Submit corporate training form

Given user is on the Edureka homepage
When user navigates to "Corporate Training" page
Then corporate training page should be displayed

When user enters corporate training details and submit
 | Name     | Email           | Phone      | TrainingNeed | Company     | Query                    |
 | Test User  | jegan@test.com | 9876543210 | For Corporate | ABC Pvt Ltd | Need corporate training |

Then user should see successful submission message