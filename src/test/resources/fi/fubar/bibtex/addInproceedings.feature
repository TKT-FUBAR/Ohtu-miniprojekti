Feature: User can add article reference

    Scenario: user can add book reference using webform
        Given user is logged in
        And has navigated to the "references" page
        And has navigated to the "add_ip" tab 
        When the entry "fu" is entered into the field "ip_handle"
        And the entry "CBA" is entered into the field "ip_title"
        And the entry "aaaa" is entered into the field "ip_booktitle"
        And the entry "fff" is entered into the field "ip_author"
        And the entry "2013" is entered into the field "ip_year"
        And the form "ip_" is submitted
        Then a reference to "CBA" is added.