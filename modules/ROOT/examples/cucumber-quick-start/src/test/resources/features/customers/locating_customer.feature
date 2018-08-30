Feature: Locate a customer
In order to provide assistance to customers more quickly
As a financial adviser
I want to be able to locate a customer using a variety of different criteria

  Background:
    Given I am logged into the application

  Scenario: Search for customer by name
    Given the following customers exist:
    | id  | first name | last name |
    | 100 | Sarah-Jane | Smith     |
    | 101 | Sarah      | Smith     |
    When I search for a customer using the following search criteria:
    | name | Sarah-Jane Smith |
    Then I should display the customer details for customer 100

  Scenario: Search for customer by name and date of birth
    Given the following customers exist:
    | id  | first name | last name | date of birth |
    | 101 | Sarah      | Smith     | 10-May-1980   |
    | 102 | Sarah      | Smith     | 21-May-1950   |
    When I search for a customer using the following search criteria:
    | name          | Sarah-Jane Smith |
    | date of birth | 10-May-1980      |
    Then I should display the customer details for customer 100

