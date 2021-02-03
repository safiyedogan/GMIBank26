@US_024_API
Feature: System should allow to create new states using api end point

  Scenario Outline: User can Just create each state 1 by 1
    Given Get data from states end point "https://www.gmibank.com/api/tp-states" and create the states using "<Type>" and "<States>"
    And Get data from api end point "https://www.gmibank.com/api/tp-states"
    And user deserialization all states Json to Java
    Then Validate your created all states one by one
    Examples: Create states
      | Type | States |
      | name | Igdir  |
      | name | Van    |
