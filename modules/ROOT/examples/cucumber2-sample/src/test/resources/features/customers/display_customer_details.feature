Feature: Display customer details
  In order to propose more relevant services to my customers
  As a financial adviser
  I want to view a customer's profile details

  Scenario: Search for customer by name
    Given I am logged into the application
    When I locate customer Sarah-Jane Smith
    Then I should see the following details in her Personal Profile:
      | Name               | Sarah-Jane Smith |
      | Gender             | Female           |
      | Marital Status     | Married          |
      | Date of Birth      | 25 May 1980      |
      | Dependents         | 2                |
      | Residential Status | Resident         |

  Scenario: Search for customer by name
    Given I am logged into the application
    And Sarah-Jane Smith is a customer with the following details:
      | Field              | Value      |
      | Surname            | Smith      |
      | First name         | Sarah-Jane |
      | Gender             | Female     |
      | Marital Status     | Married    |
      | Date of Birth      | 25-05-1980 |
      | Dependents         | Joe, Jill  |
      | Residential Status | Resident   |
    When I locate customer Sarah-Jane Smith
    Then I should see the following details in her Personal Profile:
      | Name               | Sarah-Jane Smith |
      | Gender             | Female           |
      | Marital Status     | Married          |
      | Date of Birth      | 25 May 1980      |
      | Dependents         | 2                |
      | Residential Status | Resident         |


