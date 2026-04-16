Feature: Edureka Blog Functionality

Scenario: Verify blog page loads successfully and open recent blog
Given User logs in to the edureka for viewing blogs
When  User click blogs from navbar 
Then blogs page need to be visible
And User open the blog "How To Use Python For DevOps?"
And verify wheather it opened the blog "How To Use Python For DevOps?"

# Negative Scenario
Scenario: Verify blogs can be bookmarked
Given User logs in to the edureka for viewing blogs
When  User click blogs from navbar 
And blogs page need to be visible
And User open the blog "How To Use Python For DevOps?"
Then verify wheather it opened the blog "How To Use Python For DevOps?"
And click on bookmark button 
And if not added print the warning message 


Scenario: Verify blog page loads from category
Given User logs in to the edureka for viewing blogs
When  User click blogs from navbar 
And User click on category "AWS"
Then blogs page need to be visible
And User open the blog "Machine Learning with Mahout"
And verify wheather it opened the blog "Machine Learning with Mahout"

Scenario: Verify user can view video and comment in blogs
Given User logs in to the edureka for viewing blogs
When  User click blogs from navbar 
And User click on video icon
Then User need to see videos and click video "Top DevOps Interview Questions And Answers in 2024"
And verify user can view video 
And add comments for video as "Test Comment"
And verify the comment is visible under comment section

Scenario: Verify user can view recommended blogs
Given User logs in to the edureka for viewing blogs
When  User click blogs from navbar 
And User click on video icon
Then User need to see videos and click video "Top DevOps Interview Questions And Answers in 2024"
And verify user can view video 
And verify user can see recommended blogs and first recommended blog



