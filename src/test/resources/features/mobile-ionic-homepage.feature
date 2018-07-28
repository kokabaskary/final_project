@mobile-regression @mobile-ionic-homepage @mobile

Feature: Mobile homepage Feature

  Background:
  Given I am on Splash screen of the ionic conference app
  When I swipe right 3 times on tutorials slides
  And I verify Continue button is displayed
 And I am on home page of the app

  @mobile-ionic-homepage-1
  Scenario: Verify user should be able to view default main menu bar items
    When I click on hamburger menu
    Then I verify default main menu bar fields

#
  @mobile-ionic-homepage-2
  Scenario: Verify user should be able see all the filter options
    When I click on filter button
    And I disable "Angular" option
#    And I click on All Reset Filer button
    Then I verify all options are enabled
#
  @mobile-ionic-homepage-3
  Scenario: Verify user should be able to search for event
    When Search for Breakfast
    Then I verify Event displayed with header, Duration, description