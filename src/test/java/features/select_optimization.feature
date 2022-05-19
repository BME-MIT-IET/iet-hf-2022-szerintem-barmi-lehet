Feature: select_optimization
  Scenario: User selects the "Net profit" option
    Given The GUI window pops up
    When The user selects "Net profit"
    Then Option "Net profit" will be set

  Scenario: User selects the  "Winning ratio" option
    Given The GUI window pops up
    When The user selects "Winning ratio"
    Then Option "Winning ratio" will be set