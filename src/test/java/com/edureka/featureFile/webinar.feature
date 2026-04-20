Feature: Webinar End-to-End Flow

As a user
I want to explore webinars and register
So that I can attend live sessions

Scenario: Verify all available webinars are displayed on the webinars page

Given user is on the Edureka homepage
When user clicks on "Webinars" from navigation menu
Then user should be redirected to webinars page
And webinars page should load successfully
And all upcoming webinars should be displayed
And all webinars category should be displayed

Scenario: Complete webinar flow from homepage to registration

Given user is on the Edureka homepage
When user clicks on "Webinars" from navigation menu
Then user should be redirected to webinars page

And webinars page should load successfully

When user selects the category "Python"
Then user should be navigated to "Python Webinar" webinar details page
And fill the details in registration form 
| Name | Email | Phone | Experience |
| TestUser | sampleuser123@test.com | 9876543210 | Student |

Then registration form or login page should be displayed
