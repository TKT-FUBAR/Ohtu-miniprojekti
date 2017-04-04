Feature: User can add book reference

    Scenario: user can add book reference using webform
        Given user is logged in
        And has navigated to the "references" page
        When the entry "foo" is entered into the field "handle"
        And the entry "ABC" is entered into the field "title"
        And the entry "Arto" is entered into the field "author"
        And the entry "2017" is entered into the field "year"
        And the entry "Otava" is entered into the field "publisher"
        And the entry "NYC" is entered into the field "address"
        And the form is submitted
        Then a reference to "ABC" is added.