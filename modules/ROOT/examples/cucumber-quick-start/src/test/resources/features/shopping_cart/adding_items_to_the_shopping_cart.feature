Feature: Adding items to the shopping cart
  In order to buy more than one item easily
  As a buyer
  I want to be able to add multiple items to the shopping cart

  Background:
    Given I have searched for items containing 'svg' in my region
    And I have selected an item

  Scenario: Should see total price including tax
    When I add the item to the shopping cart
    Then the item should appear in the cart
    And the shipping cost should be included in the total price

