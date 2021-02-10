@US_025_API
Feature: System should allow to create new country using api end point

  Scenario Outline: User can Just create each country 1 by 1
    Given get data from country end point "https://www.gmibank.com/api/tp-countries" and create the country using "<Type>" and "<Country>"
    And get data from api end point "https://www.gmibank.com/api/tp-countries"
    And User deserialization all country Json to Java
    Then validate your created all country one by one
    Examples: Create country
      | Type | Country     |
      | name | New Zealand |
      | name | Costa Rica  |
