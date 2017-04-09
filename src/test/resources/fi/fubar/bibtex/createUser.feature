Feature: user can create an account

  Scenario: user can create an account
    Given user navigates to the "createuser" page
    When the entry "foo" is entered into the field "name"
    And the entry "bar" is entered into the field "password"
    And the form is submitted
    Then a "user" is added.

  Scenario: user can log in with created account
