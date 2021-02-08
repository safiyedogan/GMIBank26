@US030
Feature: All users (user, employee, manager or admin) should
  be printed as a pdf file

  Scenario: You should have all users' info as Name, last name and role on a pdf document
    Given all user provides the api end point to set the response "https://www.gmibank.com/api/tp-customers"
    Then All users should be printed as a pdf file
