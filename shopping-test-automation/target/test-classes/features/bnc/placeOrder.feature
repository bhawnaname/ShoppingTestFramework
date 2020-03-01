@regression
Feature: End to end customer journey for Order Placement
  As a customer
  I want to place the order as registered user and checking the Placed Order in OrderHistory Page

  @complete
  Scenario: Verify that the order is getting placed successfully as a registered user
    Given I navigate to application
    And I logged in as as registered user
    And I navigate to the Dress ProductListing Page
    When I add Tshirt item to my basket
    And I proceed to checkout
    And I am on the Shipping details
    And I agree to the Terms and Conditions on shipping details
    And I am on the payment details
    When I confirm my order on payment page
    Then I  navigate to the order confirmation page

  @regression
  Scenario: Verify that the order is displaying in Order History Page
    Given I navigate to Order History page
    Then I should see the OrderDetails on the OrderHistoryPage
