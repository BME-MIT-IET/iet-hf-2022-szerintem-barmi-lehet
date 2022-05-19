Feature: select_MA_type
  Scenario: User selects the MA type "Simple"
    Given The GUI window pops up
    When The user selects type "Simple"
    Then Type "Simple" will be set

  Scenario: User selects the MA type "Exponential" MA type
    Given The GUI window pops up
    When The user selects type "Exponential"
    Then Type "Exponential" will be set