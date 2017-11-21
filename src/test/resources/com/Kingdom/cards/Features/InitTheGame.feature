Feature: Initialise the game enviroment

  Scenario: When the game starts
    Given A new field controller
    When The game is setup
    Then I have a deck wih 46 cards, two players with 5 cards each and 2 empty fields