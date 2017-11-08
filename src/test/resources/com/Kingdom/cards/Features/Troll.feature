Feature: Troll Power

  Scenario: Use the Troll power with 3 cards on the board
    Given A board with 3 cards
    When I play a Troll card
    Then The boards are swapped

  Scenario: Use the Troll power with 0 cards on the board
    Given A board with 0 cards
    When I play a Troll card
    Then The boards are swapped