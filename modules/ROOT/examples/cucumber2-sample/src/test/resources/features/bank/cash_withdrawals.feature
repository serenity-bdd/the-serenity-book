Feature: Cash Withdrawals

  Scenario: Cash withdrawal
    Given Clive has $1000 in his Current account
    When he withdraws $100 in cash
    Then his remaining balance should be $900
