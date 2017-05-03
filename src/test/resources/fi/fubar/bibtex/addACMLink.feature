Feature: User add references using an ACM link

  Scenario: user can add a book reference
    Given user is logged in
    When clicks the "Import from ACM" link
    And the entry "http://dl.acm.org/citation.cfm?id=2915031" is entered into the field "acmurl" of "acm-import" form
    And the form "acm-import" is submitted
    Then a reference to "A Practical Introduction to Information Retrieval and Text Mining" is added.

  Scenario: user can add a article reference
    Given user is logged in
    When clicks the "Import from ACM" link
    And the entry "http://dl.acm.org/citation.cfm?id=2669370" is entered into the field "acmurl" of "acm-import" form
    And the form "acm-import" is submitted
    Then a reference to "Matrix Calculus for Classical and Quantum Circuits" is added.

  Scenario: user can add a inproceedings reference
    Given user is logged in
    When clicks the "Import from ACM" link
    And the entry "http://dl.acm.org/citation.cfm?id=2380552.2380613" is entered into the field "acmurl" of "acm-import" form
    And the form "acm-import" is submitted
    Then a reference to "Three Years of Design-based Research to Reform a Software Engineering Curriculum" is added.