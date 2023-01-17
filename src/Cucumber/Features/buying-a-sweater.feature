Feature: Buying a sweater(product)
  Scenario Outline: User bay sweater(product)
    Given User is on the home page and clicks sign in
    And User logs in with email "<email>" and password "<password>"
    When User searches for a product "<productName>"
    And User selects the size "<size>", quantity "<quantity1>" of first product and adds it to the basket
    And User accepts proceed to checkout
    Then User accepts the address and selects the method of delivery, payment
    And User places an order




    Examples:
  | email               |password    | productName                |size|quantity1|
  |czarnajagoda@mail.pl |czarnajagoda| Hummingbird Printed Sweater|M   |5|

