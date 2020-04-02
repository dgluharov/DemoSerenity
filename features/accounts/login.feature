# new feature
# Tags: optional

Feature: Login

  Background:
    Given John is on the login page

#  @Debug
  Scenario: Successful Declarative Login
    When John logs in with:
      | email            | password   |
      | johngo@fsdfs.coy | password13 |
    Then Johngo is logged in successfully