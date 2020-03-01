$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/bnc/placeOrder.feature");
formatter.feature({
  "name": "End to end customer journey for Order Placement",
  "description": "  As a customer\n  I want to place the order as registered user and checking the Placed Order in OrderHistory Page",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@regression"
    }
  ]
});
formatter.scenario({
  "name": "Verify that the order is getting placed successfully as a registered user",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@regression"
    },
    {
      "name": "@complete"
    }
  ]
});
formatter.step({
  "name": "I navigate to application",
  "keyword": "Given "
});
formatter.match({
  "location": "com.shopping.test.web.stepdefs.PlaceOrderStepDefs.i_navigate_to_application()"
});
formatter.result({
  "status": "passed"
});
formatter.afterstep({
  "status": "passed"
});
formatter.afterstep({
  "status": "passed"
});
formatter.step({
  "name": "I logged in as as registered user",
  "keyword": "And "
});
formatter.match({
  "location": "com.shopping.test.web.stepdefs.PlaceOrderStepDefs.i_logged_in_as_as_registered_user()"
});
formatter.result({
  "status": "passed"
});
formatter.afterstep({
  "status": "passed"
});
formatter.afterstep({
  "status": "passed"
});
formatter.step({
  "name": "I navigate to the Dress ProductListing Page",
  "keyword": "And "
});
formatter.match({
  "location": "com.shopping.test.web.stepdefs.PlaceOrderStepDefs.i_navigate_to_the_Dress_ProductListing_Page()"
});
formatter.result({
  "status": "passed"
});
formatter.afterstep({
  "status": "passed"
});
formatter.afterstep({
  "status": "passed"
});
formatter.step({
  "name": "I add Tshirt item to my basket",
  "keyword": "When "
});
formatter.match({
  "location": "com.shopping.test.web.stepdefs.PlaceOrderStepDefs.i_add_Tshirt_item_to_my_basket()"
});
formatter.result({
  "status": "passed"
});
formatter.afterstep({
  "status": "passed"
});
formatter.afterstep({
  "status": "passed"
});
formatter.step({
  "name": "I proceed to checkout",
  "keyword": "And "
});
formatter.match({
  "location": "com.shopping.test.web.stepdefs.PlaceOrderStepDefs.i_proceed_to_checkout()"
});
formatter.result({
  "status": "passed"
});
formatter.afterstep({
  "status": "passed"
});
formatter.afterstep({
  "status": "passed"
});
formatter.step({
  "name": "I am on the Shipping details",
  "keyword": "And "
});
formatter.match({
  "location": "com.shopping.test.web.stepdefs.PlaceOrderStepDefs.i_am_on_the_Shipping_details()"
});
formatter.result({
  "status": "passed"
});
formatter.afterstep({
  "status": "passed"
});
formatter.afterstep({
  "status": "passed"
});
formatter.step({
  "name": "I agree to the Terms and Conditions on shipping details",
  "keyword": "And "
});
formatter.match({
  "location": "com.shopping.test.web.stepdefs.PlaceOrderStepDefs.i_agree_the_the_Terms_and_Conditions_on_shipping_details()"
});
formatter.result({
  "status": "passed"
});
formatter.afterstep({
  "status": "passed"
});
formatter.afterstep({
  "status": "passed"
});
formatter.step({
  "name": "I am on the payment details",
  "keyword": "And "
});
formatter.match({
  "location": "com.shopping.test.web.stepdefs.PlaceOrderStepDefs.i_am_on_the_payment_details()"
});
formatter.result({
  "status": "passed"
});
formatter.afterstep({
  "status": "passed"
});
formatter.afterstep({
  "status": "passed"
});
formatter.step({
  "name": "I confirm my order on payment page",
  "keyword": "When "
});
formatter.match({
  "location": "com.shopping.test.web.stepdefs.PlaceOrderStepDefs.i_confirm_my_order_on_payment_page()"
});
formatter.result({
  "status": "passed"
});
formatter.afterstep({
  "status": "passed"
});
formatter.afterstep({
  "status": "passed"
});
formatter.step({
  "name": "I  navigate to the order confirmation page",
  "keyword": "Then "
});
formatter.match({
  "location": "com.shopping.test.web.stepdefs.PlaceOrderStepDefs.i_navigate_to_the_order_confirmation_page()"
});
formatter.result({
  "status": "passed"
});
formatter.afterstep({
  "status": "passed"
});
formatter.afterstep({
  "status": "passed"
});
formatter.scenario({
  "name": "Verify that the order is displaying in Order History Page",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@regression"
    },
    {
      "name": "@regression"
    }
  ]
});
formatter.step({
  "name": "I navigate to Order History page",
  "keyword": "Given "
});
formatter.match({
  "location": "com.shopping.test.web.stepdefs.PlaceOrderStepDefs.i_navigate_to_Order_History_page()"
});
formatter.result({
  "status": "passed"
});
formatter.afterstep({
  "status": "passed"
});
formatter.afterstep({
  "status": "passed"
});
formatter.step({
  "name": "I should see the OrderDetails on the OrderHistoryPage",
  "keyword": "Then "
});
formatter.match({
  "location": "com.shopping.test.web.stepdefs.PlaceOrderStepDefs.i_should_see_the_OrderDetails_on_the_OrderHistoryPage()"
});
formatter.result({
  "status": "passed"
});
formatter.afterstep({
  "status": "passed"
});
formatter.afterstep({
  "status": "passed"
});
formatter.uri("file:src/test/resources/features/myAccount/personalInformation.feature");
formatter.feature({
  "name": "Update Personal Information",
  "description": "  As a customer\n  I want to update my personal Information(Name) in my Account",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@regression"
    }
  ]
});
formatter.scenarioOutline({
  "name": "Verify that the user is able to update the Personal Information in My Account Page",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@regression"
    }
  ]
});
formatter.step({
  "name": "I login to the application as signed in user",
  "keyword": "Given "
});
formatter.step({
  "name": "I view the My Account Page",
  "keyword": "And "
});
formatter.step({
  "name": "I view the My Personal Information",
  "keyword": "And "
});
formatter.step({
  "name": "I update the \"\u003cName\u003e\" in \"NameField\"",
  "keyword": "When "
});
formatter.step({
  "name": "I enter \"Password\" in \"passwordField\"",
  "keyword": "And "
});
formatter.step({
  "name": "I click on save",
  "keyword": "And "
});
formatter.step({
  "name": "I should see the successful update personal Information message",
  "keyword": "Then "
});
formatter.step({
  "name": "I should see the updated \"\u003cName\u003e\" on My Account Header",
  "keyword": "And "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "Name"
      ]
    },
    {
      "cells": [
        "Henna"
      ]
    }
  ]
});
formatter.scenario({
  "name": "Verify that the user is able to update the Personal Information in My Account Page",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@regression"
    },
    {
      "name": "@regression"
    }
  ]
});
formatter.step({
  "name": "I login to the application as signed in user",
  "keyword": "Given "
});
formatter.match({
  "location": "com.shopping.test.web.stepdefs.personalInfoStepDefs.i_login_to_the_application_as_signed_in_user()"
});
formatter.result({
  "status": "passed"
});
formatter.afterstep({
  "status": "passed"
});
formatter.afterstep({
  "status": "passed"
});
formatter.step({
  "name": "I view the My Account Page",
  "keyword": "And "
});
formatter.match({
  "location": "com.shopping.test.web.stepdefs.personalInfoStepDefs.i_view_the_My_Account_Page()"
});
formatter.result({
  "status": "passed"
});
formatter.afterstep({
  "status": "passed"
});
formatter.afterstep({
  "status": "passed"
});
formatter.step({
  "name": "I view the My Personal Information",
  "keyword": "And "
});
formatter.match({
  "location": "com.shopping.test.web.stepdefs.personalInfoStepDefs.i_view_the_My_Personal_Information()"
});
formatter.result({
  "status": "passed"
});
formatter.afterstep({
  "status": "passed"
});
formatter.afterstep({
  "status": "passed"
});
formatter.step({
  "name": "I update the \"Henna\" in \"NameField\"",
  "keyword": "When "
});
formatter.match({
  "location": "com.shopping.test.web.stepdefs.personalInfoStepDefs.i_update_the_in(java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.afterstep({
  "status": "passed"
});
formatter.afterstep({
  "status": "passed"
});
formatter.step({
  "name": "I enter \"Password\" in \"passwordField\"",
  "keyword": "And "
});
formatter.match({
  "location": "com.shopping.test.web.stepdefs.personalInfoStepDefs.i_enter_in(java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.afterstep({
  "status": "passed"
});
formatter.afterstep({
  "status": "passed"
});
formatter.step({
  "name": "I click on save",
  "keyword": "And "
});
formatter.match({
  "location": "com.shopping.test.web.stepdefs.personalInfoStepDefs.i_click_on_save()"
});
formatter.result({
  "status": "passed"
});
formatter.afterstep({
  "status": "passed"
});
formatter.afterstep({
  "status": "passed"
});
formatter.step({
  "name": "I should see the successful update personal Information message",
  "keyword": "Then "
});
formatter.match({
  "location": "com.shopping.test.web.stepdefs.personalInfoStepDefs.i_should_see_the_successful_update_personal_Information_message()"
});
formatter.result({
  "status": "passed"
});
formatter.afterstep({
  "status": "passed"
});
formatter.afterstep({
  "status": "passed"
});
formatter.step({
  "name": "I should see the updated \"Henna\" on My Account Header",
  "keyword": "And "
});
formatter.match({
  "location": "com.shopping.test.web.stepdefs.personalInfoStepDefs.i_should_see_the_updated_on_My_Account_Header(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.afterstep({
  "status": "passed"
});
formatter.afterstep({
  "status": "passed"
});
});