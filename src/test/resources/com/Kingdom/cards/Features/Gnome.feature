Feature: Gnome Power

  Scenario: Use the Gnome power with a deck of 3 Cards
    Given A deck with 3 cards
    When I play a Gnome card
    Then My hand has 2 more cards

  Scenario: Use the Gnome power with a deck of 1 Cards
    Given A deck with 1 cards
    When I play a Gnome card
    Then My hand has 1 more cards

  Scenario: Use the Gnome power with a deck of 0 Cards
    Given A deck with 0 cards
    When I play a Gnome card
    Then My hand has 0 more cards
