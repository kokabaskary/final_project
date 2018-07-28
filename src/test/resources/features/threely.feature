
@regression  @homepage @web
Feature: verify homepage web elements feature

  Background:
    Given I am on Threely homepage


  @homepage-1
    Scenario:  verify autocomplete
    When I search on top search bar with text "ios"
    Then I verify "Title: I will teach you IOS" as displayed result

  @homepage-2
  Scenario:  verify webelememts display
    Then I verify 57 total post is displayed
    And I verify all post has price tag
    And I verify all post has title
    And  I verify all post has displayed image


