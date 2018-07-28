@regression @login @web
Feature: verify login feature

  Background:
    Given I am on Threely homepage

 @login-1
  Scenario: Verify valid login
    When User is on the Threely login page
    And I enter  email as test3@test.com password as test12345678
    And I click submit
    And I click on image circle button
    Then I verify logout button is displayed