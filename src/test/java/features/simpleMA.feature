Feature: simpleMA_test
  Scenario: A simple moving average get tested
    Given The reader reads
    When Calculate simpleMa with given time
    Then Calculated simple value equals expected
