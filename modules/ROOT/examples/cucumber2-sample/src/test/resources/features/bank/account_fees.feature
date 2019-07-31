Feature: Account Fees

  Scenario Outline: Account Fees for different types of account
    Given Clive has an <Account Type> account with a balance of <Sample Balance>
    When the monthly fees are calculated
    Then a "<Monthly Fee>" monthly fee of <Sample Fee> should be deducted
    Examples:
      | Account Type | Monthly Fee | Sample Balance | Sample Fee |
      | Current      | Fixed       | 1000           | 1.50       |
      | Savings      | Free        | 1000           | 0.00       |
      | Investment   | Percentage  | 1000           | 2.50       |