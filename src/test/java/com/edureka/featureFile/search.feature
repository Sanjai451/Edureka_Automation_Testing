Feature: Search functionality in Edureka

  Scenario: Verify search bar visibility and search panel opening
    Given user is ready on homepage for search module
    Then search bar should be visible for search module
    When user clicks the search bar for search module
    Then search panel should open for search module

  Scenario: Verify valid search flow and navigation to course page
    Given user is ready on homepage for search module
    When user clicks the search bar for search module
    And user enters valid keyword from excel sheet "SearchData" row 1
    And user presses Enter in search for search module
    Then relevant search results should be displayed for search module
    When user stores first search result title for search module
    And user clicks first search result for search module
    Then opened course page title should match stored result title for search module

  Scenario: Verify partial and case insensitive search using datatable
    Given user is ready on homepage for search module
    When user searches using datatable for search module
      | keyword |
      | pyt     |
      | AWS     |
      | aws     |
         
    Then datatable search should complete for search module

  Scenario: Verify empty search navigates to default search page
    Given user is ready on homepage for search module
    When user clicks the search bar for search module
    And user presses Enter in search for search module
    Then default search page should open for search module

  Scenario: Verify special character search is handled safely
    Given user is ready on homepage for search module
    When user clicks the search bar for search module
    And user enters special keyword from excel sheet "SearchData" row 1
    And user presses Enter in search for search module
    Then system should not crash for search module

  Scenario: Verify invalid keyword search is handled safely and callback form is displayed
    Given user is ready on homepage for search module
    When user clicks the search bar for search module
    And user enters invalid keyword from excel sheet "SearchData" row 1
    And user presses Enter in search for search module
    Then system should not crash for search module
    And callback form should be displayed for search module

  Scenario: Verify mobile number validation on callback form
    Given user is on no-results callback form page using excel sheet "SearchData" row 1 for search module
    When user enters valid mobile number from excel sheet "SearchData" row 1 for search module
    Then system should accept valid 10 digit mobile number for search module
    When user enters invalid mobile number from excel sheet "SearchData" row 1 for search module
    Then system should not accept more than 10 digits for search module