@tag
Feature: Login to FB

  @tag1
  Scenario: Login to the Facebook application with invalid credentials
    Given Open FB URL
    When User enter invalid credentials
    And Click on Login button
    Then Application should display the validation Message

  @tag2
  Scenario: Login to the Facebook application with valid credentials
    Given Open FB URL
    When User enter valid credentials
    And Click on Login button
    Then Application should display the validation Message

 
    