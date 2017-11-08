Feature: Goblin Power

  Scenario: Goblin card with enemy hand with 3
    Given [Goblin]Enemy with only 3 card
    When I play a Goblin card
    Then I recieve a Hand with 3 card

  Scenario: Goblin card with enemy hand with 1
    Given [Goblin]Enemy with only 1 card
    When I play a Goblin card
    Then I recieve a Hand with 1 card

  Scenario: Goblin card with enemy hand with 0
    Given [Goblin]Enemy with only 0 card
    When I play a Goblin card
    Then I recieve a Hand with 0 card