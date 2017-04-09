Feature: User can add article reference

    Scenario: user can add book reference using webform
        Given user is logged in
        And has navigated to the "references" page
        And has navigated to the "add_article" tab 
        When the entry "foo" is entered into the field "article_handle"
        And the entry "BCA" is entered into the field "article_title"
        And the entry "Eino Leino" is entered into the field "article_author"
        And the entry "2014" is entered into the field "article_year"
        And the entry "Hesari" is entered into the field "article_journal"
        And the form "article_" is submitted
        Then a reference to "BCA" is added.