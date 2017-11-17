Feature: Dryad Power

  Scenario: Use the Dryad power with 2 cards on the board
    Given [Dryad]A board with 2 cards
    When I play a Dryad card
    Then My board grew by 1 and enemy srunk by 1

  Scenario: Use the Dryad power with 1 cards on the board
    Given [Dryad]A board with 1 cards
    When I play a Dryad card
    Then My board grew by 1 and enemy srunk by 1

  Scenario: The AI plays a Dryad card with 0 cards on the board
    Given [Dryad]A board with 0 cards
    When I play a Dryad card
    Then My board grew by 0 and enemy srunk by 0