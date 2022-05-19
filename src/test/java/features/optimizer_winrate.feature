Feature: optimizer_winrate
  Scenario: Optimizer gets tested for best possible win rate
    Given Optimizer with parameters
    When Optimizer calculates max winning rate
    Then Best win rate equals expected amount
