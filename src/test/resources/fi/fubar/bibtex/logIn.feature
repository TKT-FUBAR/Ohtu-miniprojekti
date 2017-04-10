
Feature: User can add book reference

  Scenario: user can log in with created account
    Given user navigates to the "login" page
    When the entry "foo" is entered into the field "name"
    And the entry "bar" is entered into the field "password"
    And the form is submitted
    Then user is succesfully logged in

  Scenario: user can not log in with incorrect username and incorrect password
  Given user navigates to the "login" page
  When the entry "LOLNOT123412424141" is entered into the field "name"
  And the entry "Hah" is entered into the field "password"
  And the form is submitted
  Then user is not logged in and error is shown

