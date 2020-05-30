Feature: To test MakeMytrip

  Scenario: To test features of makemytrip

    Given I login website as a guest user
    When I enter flight names from "Chennai" to "Hyderabad"
    When I select passenger details
    And  I print Daparture and Return flight details
    And I print Daparture and Return flight details after Selecting Non-Stop and one Stop filter options
    And I print Daparture and Return flight details after unselecting non stop and one stop filter
    And I verify price info for Daparture and Return flight details
    And I verify total amount of price
    And I book and continue

