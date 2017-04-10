Feature: User can add article reference

    Scenario: user can add book reference using webform
        Given user is logged in
        And clicks the  "Add a reference" link
        And has navigated to the "add_ip" tab 
        When the entry "fu" is entered into the field "handle" of "form-inproceedings" form
        And the entry "CBA" is entered into the field "title" of "form-inproceedings" form
        And the entry "aaaa" is entered into the field "booktitle" of "form-inproceedings" form
        And the entry "fff" is entered into the field "author" of "form-inproceedings" form
        And the entry "2013" is entered into the field "year" of "form-inproceedings" form
        And the form "form-inproceedings" is submitted
        Then a reference to "CBA" is added.