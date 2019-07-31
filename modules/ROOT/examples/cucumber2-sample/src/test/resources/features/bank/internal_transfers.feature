Feature: Internal Transfers

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
