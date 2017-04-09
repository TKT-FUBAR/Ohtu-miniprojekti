Feature: User can add book reference

    Scenario: user can add book reference using webform
        Given user is logged in
        And has navigated to the "references" page
        And has navigated to the "add_book" tab 
        When the entry "foo" is entered into the field "book_handle"
        And the entry "ABC" is entered into the field "book_title"
        And the entry "Arto" is entered into the field "book_author"
        And the entry "2017" is entered into the field "book_year"
        And the entry "Otava" is entered into the field "book_publisher"
        And the entry "NYC" is entered into the field "book_address"
        And the form "book_" is submitted
        Then a reference to "ABC" is added.