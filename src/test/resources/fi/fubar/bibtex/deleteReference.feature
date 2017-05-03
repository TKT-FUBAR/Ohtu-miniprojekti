
Feature: User can delete references with a webform

  Scenario: user can delete the reference using the edit form
    Given user is logged in
    And test reference is added
    When user clicks on the "testTitle" reference
    And the delete button is pressed
    Then the reference to "testTitle" is removed.