@regression @signup @web
Feature: verify signup feature

  Background:
    Given I am on Threely homepage

  @signup-1
  Scenario: Verify a new user can register with a valid email address
    When I am on Registration page
    And I enter  the name as "testuser" the email as "test@test.com" the password as "test12345"
    And I click 'submit' button
    Then  I am signed-in as a new user


  @signup-2
  Scenario Outline: Verify invalid email on registration
    When I am on Registration page
    And I enter name as testuser emails as <email> password as test12345
    And I click 'submit' button
    Then  I verify invalid email address

    Examples:
      | email              |
      | test.com           |
      | test@test@test.com |

