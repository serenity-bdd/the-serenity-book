Feature: Search by keyword

  Scenario: Search for terms by a single keyword
    Given Serge is on the Search page
    When he searches by "Tomato"
    Then he should only see search results containing the word "Tomato"