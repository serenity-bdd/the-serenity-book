Adding items to the shopping cart

Meta:
@driver phantomjs

Narrative:
  In order to buy multiple items at the same time
  As a buyer
  I want to be able to add multiple items to the shopping cart

Scenario: Should see total price including tax
Given I have searched for items containing 'blue wool'
And I have selected an item
When I add the item to the shopping cart
Then the item should appear in the cart
And the shipping cost should be included in the total price

