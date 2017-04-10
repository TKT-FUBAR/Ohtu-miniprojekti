Feature: User can add book reference

    Scenario: user can add book reference using webform
        Given user is logged in
        And clicks the  "Add a reference" link
        And has navigated to the "add_book" tab 
        When the entry "foo" is entered into the field "handle" of "form-book" form
        And the entry "ABC" is entered into the field "title" of "form-book" form
        And the entry "Arto" is entered into the field "author" of "form-book" form
        And the entry "2017" is entered into the field "year" of "form-book" form
        And the entry "Otava" is entered into the field "publisher" of "form-book" form
        And the entry "NYC" is entered into the field "address" of "form-book" form
        And the form "form-book" is submitted
        Then a reference to "ABC" is added.