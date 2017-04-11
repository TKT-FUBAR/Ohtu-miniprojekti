#Feature: user can download all references in BibTex Format
#    
#    Scenario: bibtex string has an article reference 
#        Given user is logged in
#        When clicks the  "Get a BibTex" link
#        Then output contains a "@article" annotated entry.
#
#    Scenario: bibtex string has an book reference 
#        Given user is logged in
#        When clicks the  "Get a BibTex" link
#        Then output contains a "@book" annotated entry.
#
#    Scenario: bibtex string has an inproceedings reference 
#        Given user is logged in
#        When clicks the  "Get a BibTex" link
#        Then output contains a "@inproceedings" annotated entry.