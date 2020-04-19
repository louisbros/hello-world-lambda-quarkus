Feature: Hello World
  As a developer I want to call my lambda function so that I can demonstrate an acceptance test.

  Scenario: Can request
    Given I have a function
    When I call the function
    Then I should receive an output