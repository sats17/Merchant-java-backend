Feature: merchantsearch

Scenario: no data found
Given user is on 'merchanthome' page
When user searches in inventory
Then displays 'Empty'