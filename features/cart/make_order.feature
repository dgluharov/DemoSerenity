Feature: Fill Shopping Cart

  @fff
  Scenario Outline: Successful Adding a Product in Cart
    Given John is on the Women's Page
    And he selected the first product from list of products
    When John chose his options from Product Page:
      | quantity   | size   | color   |
      | <quantity> | <size> | <color> |
    And he added them to the cart
    Then he proceeds to Order Page
    And in the cart there are the following products with theirs characteristics:
      | quantity   | size   | color   |
      | <quantity> | <size> | <color> |
    Examples:
      | quantity | size | color |
      | 2        | L    | Blue  |
