Feature: Korrigan Power

  Scenario: Korrigan card with enemy hand more than 2
    Given Enemy with only 3 card
    When I play a Korrigan card
    Then I recieve 2 card

  Scenario: Korrigan card with enemy hand less than 2
    Given Enemy with only 1 card
    When I play a Korrigan card
    Then I recieve 1 card

  Scenario: Korrigan card with enemy hand less than 2
    Given Enemy with only 0 card
    When I play a Korrigan card
    Then I recieve 0 card