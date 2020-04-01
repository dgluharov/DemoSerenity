Feature: Fill Shopping Cart

  @Debug
  Scenario: Add Product to Cart
    Given John is on the Women's Page
    When John selects the first product from products list
    And he adds the product to the cart with order details:
      | quantity | size | color |
      | 2        | L    | blue  |
    Then the product should be added to the cart
    And correct order details are displayed in the cart page
