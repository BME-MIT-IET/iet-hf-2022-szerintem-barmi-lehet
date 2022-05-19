Feature: exponentialMA
  Scenario: An exponential moving average get tested
    Given The reader reads
    When Calculate exponentialMa with given time
    Then Calculated exponential value equals expected
