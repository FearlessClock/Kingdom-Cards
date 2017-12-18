Feature: Game loop

  Scenario: Initialise the game controller
    Given A controller initialised
    Then A board exists, a deck exists, both players exists

  Scenario: The deck contains enough cards
    Given A controller initialised
    Then The deck contains 42 cards

  Scenario: The player holds enough cards
    Given A controller initialised
    Then The player holds 5 cards

  Scenario: The playerAI holds enough cards
    Given A controller initialised
    Then The playerAI holds 5 cards


  Scenario: Play the end of the playerAI turn
    Given A controller initialised
    Given playerHasPlayed true and player turn
    When End the turn
    Then playerTurn is player, playerHasPlayed false, playerHasDrawn false
