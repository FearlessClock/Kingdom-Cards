Feature: Elf Power

  Scenario: Use the Elf power with 2 cards on the board
    Given [Elf]A board with 2 cards
    When I play a Elf card
    Then My board grew by 2 and enemy srunk by 2

  Scenario: Use the Elf power with 1 cards on the board
    Given [Elf]A board with 1 cards
    When I play a Elf card
    Then My board grew by 1 and enemy srunk by 1

  Scenario: The AI plays a Elf card with 0 cards on the board
    Given [Elf]A board with 0 cards
    When I play a Elf card
    Then My board grew by 0 and enemy srunk by 0