Feature: Search functionality in Edureka





 # ================= BASIC SEARCH FLOW =================

  Scenario: Verify search bar visibility, panel opening, and valid search flow
    Given user is ready on homepage for search module
    Then search bar should be visible for search module
    When user clicks the search bar for search module
    Then search panel should open for search module
    When user enters valid keyword from excel sheet "SearchData" row 1
    And user presses Enter in search for search module
    Then relevant search results should be displayed for search module
    When user stores first search result title for search module
    And user clicks first search result for search module
    Then opened course page title should match stored result title for search module


  # ================= PARTIAL + CASE INSENSITIVE =================

  Scenario: Verify partial and case insensitive search using datatable
    Given user is ready on homepage for search module
    When user searches using datatable for search module
      | keyword |
      | pyt     |
      | AWS     |
      | aws     |
    Then datatable search should complete for search module

