@regression @darkskyhomepage @web

Feature: verify homepage web elements feature

  Background:
    Given I am on Darksky home page

  @darkskyhomepage-1
    Scenario: Verify Time Machine Calendar
    When I click on Time Machine
    Then I verify date is selected to today's date


  @darkskyhomepage-2
  Scenario: Verify individual day temp timeline
    When I expand todays timeline
    Then I verify lowest and highest temp is displayed correctly


  @darkskyhomepage-3
  Scenario: Verify timline is displayed in correct format

    Then I verify timeline is displayed with two hours incremented

