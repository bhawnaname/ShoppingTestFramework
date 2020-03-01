@regression
Feature: Update Personal Information
  As a customer
  I want to update my personal Information(Name) in my Account

  @regression
  Scenario Outline: Verify that the user is able to update the Personal Information in My Account Page
    Given I login to the application as signed in user
    And I view the My Account Page
    And I view the My Personal Information
    When I update the "<Name>" in "NameField"
    And I enter "Password" in "passwordField"
    And I click on save
    Then I should see the successful update personal Information message
    And I should see the updated "<Name>" on My Account Header

    Examples: 
      | Name  |
      | Henna |
