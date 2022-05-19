Feature: optimizer_works_flawlessly
  Scenario: Optimizer works flawlessly
    Given An Optimizer
    When Optimizer works
    Then Net profit equals expected amount
