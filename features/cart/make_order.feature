Feature: Fill Shopping Cart

  @fff
  Scenario: Successful Adding a Product in Cart
    Given John is on the Women's Page
    And he has selected the first product from list of products
    When John selects his options from Product Page:
      | quantity | size | color |
      | 2        | L    | blue  |
    Then he adds them to the cart
    When John proceeds to Order Page
    Then he should see the summary of his purchase:
      | name                        | quantity | size | color | price |
      | Faded Short Sleeve T-shirts | 2        | L    | Blue  | 33.02 |
