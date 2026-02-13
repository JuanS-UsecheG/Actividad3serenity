Feature: User authentication, search and purchase flow

  Background:
    Given that the user opens DemoShop

  Scenario Outline: Successful login, search, add to cart and pay
    When the user logs in with username "<user>" and password "<pass>"
    And the user searches for "<term>"
    And the user adds the first product to the cart
    And the user selects size "<size>", color "<color>" and quantity "<qty>" and adds to cart
    And the user goes to the cart
    Then the product should be visible in the cart
    When the user proceeds to checkout
    And the user completes the payment with method "Bank Deposit"
    Then the user should see the successful payment message
    And the user goes back to dashboard
    And the user opens orders
    Then the user should see the purchased product "<term>" in orders

    Examples:
      | user                          | pass     | term    | size             | color | qty |
      | miguel.saldarriagar@autonoma.edu.co | uam_123* | Crystal | One Size for All | Gold  | 2   |

  Scenario Outline: Successful login, search, add to cart and pay
    When the user logs in with username "<user>" and password "<pass>"
    And the user searches for "<term>"
    And the user adds the first product to the cart
    And the user selects size "<size>", color "<color>" and quantity "<qty>" and adds to cart
    And the user goes to the cart
    Then the product should be visible in the cart
    When the user proceeds to checkout
    And the user completes the payment with method "Bank Deposit"
    Then the user should see the successful payment message
    And the user goes back to dashboard
    And the user opens orders
    Then the user should see the purchased product "<term>" in orders

    Examples:
      | user                          | pass     | term    | size             | color | qty |
      | sara.cadavidg@autonoma.edu.co | uam_123* | Crystal | One Size for All | Gold  | 2   |

  Scenario Outline: Successful login, search, add to cart and pay
    When the user logs in with username "<user>" and password "<pass>"
    And the user searches for "<term>"
    And the user adds the first product to the cart
    And the user selects size "<size>", color "<color>" and quantity "<qty>" and adds to cart
    And the user goes to the cart
    Then the product should be visible in the cart
    When the user proceeds to checkout
    And the user completes the payment with method "Bank Deposit"
    Then the user should see the successful payment message
    And the user goes back to dashboard
    And the user opens orders
    Then the user should see the purchased product "<term>" in orders

    Examples:
      | user                          | pass     | term    | size      | color | qty |
      | juans.usecheg@autonoma.edu.co | uam_123* | Amazfit | Free Size | White  | 3  |