Feature: Edureka Blog Functionality

  Background:
    Given User logs in to the edureka for viewing blogs

Scenario: Verify blog page loads successfully and open recent blog
    When User click blogs from navbar
    Then blogs page need to be visible
    And User open the recent blog from Excel
    And verify whether recent blog opened from Excel
 
Scenario: Verify blog page loads from category
    When User click blogs from navbar
    And User click on category from Excel
    Then blogs page need to be visible
    And User open category blog from Excel
    And verify whether category blog opened from Excel

 Scenario: Verify user can view video and comment in blogs
    When User click blogs from navbar
    And User click on video icon
    Then User need to see videos and click video from Excel
    And verify user can view video
    And add comments for video from Excel
    And verify the comment is visible under comment section

Scenario: Verify user can view recommended blogs
    When User click blogs from navbar
    And User click on video icon
    Then User need to see videos and click video from Excel
    And verify user can view video
    And verify user can see recommended blogs and first recommended blog

#NEG
  Scenario: Verify blogs can be bookmarked
    When User click blogs from navbar
    And blogs page need to be visible
    And User open the recent blog from Excel
    Then verify whether recent blog opened from Excel
    And click on bookmark button
    And if not added print the warning message



