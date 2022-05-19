Feature: numbers_set
  Scenario: Set all numbers in the GUI window
    Given The GUI window pops up
    When User writes numbers in all fields
    Then The required numbers are set
