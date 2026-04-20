Feature: Edureka Blog Functionality

 # Background:
 #   Given User logs in to the edureka for viewing blogs

 # Scenario: Verify blog page loads successfully and open recent blog
 #   When User click blogs from navbar
 #   Then blogs page need to be visible
 #   And User open the recent blog from Excel
 #   And verify whether recent blog opened from Excel

 # Scenario: Verify blogs can be bookmarked
  #  When User click blogs from navbar
  #  And blogs page need to be visible
  #  And User open the recent blog from Excel
  #  Then verify whether recent blog opened from Excel
  #  And click on bookmark button
  #  And if not added print the warning message

  Scenario: Verify blog page loads from category
    When User click blogs from navbar
    And User click on category from Excel
    Then blogs page need to be visible
    And User open category blog from Excel
    And verify whether category blog opened from Excel

