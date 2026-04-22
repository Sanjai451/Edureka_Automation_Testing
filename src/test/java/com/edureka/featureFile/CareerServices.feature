Feature: Career Services - Complete Flow

Background:
  Given user launches the browser
  And user navigates to Edureka application
  And user logs in using config credentials
  And user navigates to My Profile
  And user clicks on Career Services tab

Scenario: Verify complete career services flow using Excel data

  # PROFESSIONAL DETAILS
  When user clicks Professional Details edit button
  And user reads professional details from excel
  And user enters professional details from excel
  And user clicks Next button

  # CAREER INTERESTS
  And user reads career interests data from excel
  And user enters career interests data from excel
  And user clicks Next button

  # OTHER DETAILS
  And user reads other details data from excel
  And user enters other details from excel
  And user clicks Save button

  Then all career service details should be saved successfully
  And updated career service details should be displayed correctly