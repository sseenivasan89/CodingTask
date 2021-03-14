@feature
Feature: Countdown The Timer
  
  @smoke @regression
  Scenario: Counting The Timer in Eggtimer
  Given I launch the application
  Then I enter the time in '25' seconds
  And I validate the time counter