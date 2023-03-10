Feature: Add Address
  Scenario Outline: user can add address
    Given  User is on main site and clicks in sign in
    And User is logged in with email "<email>" and password "<password>"
    When User clicks Addresses
    When User clicks Create new address
    Then User fills New address form with "<alias>","<address>","<city>","<zip>","<country>","<phone>"
    And Check if form contains proper details "<alias>","<address>","<city>","<zip>","<country>","<phone>"
    And User deletes added address

    Examples:
      | email               |password    |alias| address     | city   |zip    |country        |phone|
      |czarnajagoda@mail.pl|czarnajagoda|jago| Kaszmirowa 5| Olsztyn| 02-201| United Kingdom|5023652451|
