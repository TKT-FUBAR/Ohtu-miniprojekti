Feature: User can edit references with a webform

  Scenario: user can see reference's fields in the edit form
    Given user is logged in
    And test reference is added
    When user clicks on the "testTitle" reference
    Then user sees populated fields on the edit form

  Scenario: user can edit the reference's fields in the edit form
    Given user is logged in
    And test reference is added
    When user clicks on the "testTitle" reference
    And user changes the field "title" to "editTitle"
    And the form is submitted
    Then the reference to "testTitle" is removed.
    And reference to "editTitle" is added.
