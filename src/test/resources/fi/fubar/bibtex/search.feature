Feature: user can search references using keywords

  Scenario: user can find a searched reference
    Given user is logged in
    And test reference is added
    When user searches for "testTitle"
    Then "testTitle" is shown

  Scenario: user can find a searched reference
    Given user is logged in
    And test reference is added
    When user searches for "will not find anything"
    Then "testTitle" is not shown

