@test
  Feature: Test API
    Scenario: Test API
      Given get guest token
      Then register a player
      And authorize as created player
      And request details of player
      And request detials of another player