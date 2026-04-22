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

  Scenario Outline: Verify Filter By Job Role functionality
    Given user is ready on homepage for search module
    When user clicks the search bar for search module
    Then search panel should open for search module
    When user presses Enter in search for search module
    Then default search page should open for search module
    When user clicks on Filter By Job Role dropdown
    And user selects "<role>" job role
    Then filtered results should be displayed for "<role>"

    Examples:
      | role              |
      | Tableau Developer |

  Scenario: Verify navigation using popular search keywords
    Given user is ready on homepage for search module
    When user clicks the search bar for search module
    Then search panel should open for search module
    When user selects popular keyword from excel sheet "SearchData" row 1
    Then user should be navigated to search results page
    And search results should match selected keyword from excel

  Scenario: Verify navigation using categories
    Given user is ready on homepage for search module
    When user clicks the search bar for search module
    Then search panel should open for search module
    When user selects category from excel sheet "SearchData" row 1
    Then user should be navigated to category page for selected category

  Scenario: Verify valid mobile number submission in callback form
    Given user is ready on homepage for search module
    When user clicks the search bar for search module
    Then search panel should open for search module
    When user enters invalid keyword from excel sheet "SearchData" row 1
    And user presses Enter in search for search module
    And callback form should be displayed for search module
    When user enters valid mobile number from excel sheet "SearchData" row 1 for search module
    And user clicks Get a call back button
    Then callback request should be submitted successfully

  Scenario: Verify invalid mobile number should not be accepted in callback form
    Given user is ready on homepage for search module
    When user clicks the search bar for search module
    Then search panel should open for search module
    When user enters invalid keyword from excel sheet "SearchData" row 1
    And user presses Enter in search for search module
    And callback form should be displayed for search module
    When user enters invalid mobile number from excel sheet "SearchData" row 1 for search module
    And user clicks Get a call back button
    Then callback request should not be submitted for invalid mobile
