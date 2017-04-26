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

   Scenario: user can edit the references handle in the edit form
    Given user is logged in
    And test reference is added
    When user clicks on the "testTitle" reference
    And user changes the field "handle" to "editHandle"
    And the form is submitted
    And reference to "editHandle" is added.

   Scenario: user can edit the references author in the edit form
    Given user is logged in
    And test reference is added
    When user clicks on the "testTitle" reference
    And user changes the field "author" to "editAuthor"
    And the form is submitted
    And reference to "editAuthor" is added.
  
  # TODO: Fix test, publisher doesn't show in the main page.'
  # Scenario: user can edit the references publisher in the edit form
  #  Given user is logged in
  #  And test reference is added
  #  When user clicks on the "testTitle" reference
  #  And user changes the field "publisher" to "editPub"
  # And the form is submitted
  #  And reference to "editPub" is added.