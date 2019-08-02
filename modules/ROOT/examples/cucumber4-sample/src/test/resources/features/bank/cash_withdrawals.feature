Feature: Cash Withdrawals

  Scenario: Cash withdrawal
    Given Clive has $1000 in his current account
    When he withdraws $100 in cash
    Then his remaining balance should be $900

  Scenario: Transferring funds between internal accounts
    Given Clive has the following accounts:
      | Account | Balance |
      | Current | 1000    |
      | Savings | 2000    |
    When he transfers $100 from his Current account to his Savings account
    Then his new account balances should be:
      | Account | Balance |
      | Current | 900     |
      | Savings | 2100    |

  Scenario Outline: Account Fees for different types of account
    Given Clive has an <Account Type> account with a balance of <Sample Balance>
    When the monthly fees are calculated
    Then a <Monthly Fee> monthly fee of <Sample Fee> should be deducted
    Examples:
      | Account Type | Monthly Fee | Sample Balance | Sample Fee |
      | Current      | $1.50       | 1000           | 1.50       |
      | Savings      | $0.00       | 1000           | 0.00       |
      | Investment   | 0.25%       | 1000           | 2.50       |