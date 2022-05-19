Feature: click_optimize
  Scenario: User clicks the Optimize! button
    Given The GUI window pops up
    And All numbers are set
    And User selects "Net profit"
    And User selects type "Simple"
    When User clicks the Optimize! button
    Then The procedure starts with option "Net profit" and type "Simple" in mind

  Scenario: User clicks the Optimize! button
    Given The GUI window pops up
    And All numbers are set
    When User clicks the Optimize! button
    And The user selects "Net profit"
    And The user selects type "Exponential"
    Then The procedure starts with option "Net profit" and type "Exponential" in mind

  Scenario: User clicks the Optimize! button
    Given The GUI window pops up
    And All numbers are set
    When User clicks the Optimize! button
    And The user selects "Winning ratio"
    And The user selects type "Simple"
    Then The procedure starts with option "Winning ratio" and type "Simple" in mind

  Scenario: User clicks the Optimize! button
    Given The GUI window pops up
    And All numbers are set
    When User clicks the Optimize! button
    And The user selects "Winning ratio"
    And The user selects type "Exponential"
    Then The procedure starts with option "Winning ratio" and type "Exponential" in mind