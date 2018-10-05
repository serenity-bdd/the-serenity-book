Searching by keyword

Meta:
@tag product:search

Narrative:
  In order to find items that I would like to purchase
  As a potential buyer
  I want to be able to search for items containing certain words

Scenario: Should list items related to a specified keyword
Given I want to buy a wool scarf
When I search for local items containing 'wool'
Then I should only see items related to 'wool'

Scenario: Should be able to filter search results by item type
Given I have searched for items containing 'wool'
When I filter results by type 'Handmade'
Then I should only see items containing 'wool' of type 'Handmade'