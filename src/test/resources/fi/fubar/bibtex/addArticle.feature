Feature: User can add article reference

    Scenario: user can add book reference using webform
        Given user is logged in
        And has navigated to the "references" page
        And has navigated to the "add_article" tab 
        When the entry "foo" is entered into the field "handle" of "form-article" form
        And the entry "BCA" is entered into the field "title" of "form-article" form
        And the entry "Eino Leino" is entered into the field "author" of "form-article" form
        And the entry "2014" is entered into the field "year" of "form-article" form
        And the entry "Hesari" is entered into the field "journal" of "form-article" form
        And the form "form-article" is submitted
        Then a reference to "BCA" is added.