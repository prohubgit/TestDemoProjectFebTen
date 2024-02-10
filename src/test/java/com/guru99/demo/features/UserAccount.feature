#@AllTest
Feature: Create New User Account
  As customer i want the ability to
  create new user Account
  so that i can use the available features on this website.

#Background:
#  Given I navigate to Guru99 home page
#  And I click on AcceptAll button on Manage your Privacy
#===================================================================
#Scenario No.1:
#  @userAccount
#  Scenario Outline: User can create a new account
#
#    When I click on BankProject link
#    And I click on here link under the Steps To Generate Access header
#    And I enter my "<Email ID>" in to Email ID text box
#    And I click on Submit button
#    Then User ID and Password are displayed on Access Page
#
#    Examples:
#      |Email ID                  |
#      |shaikkh12223344@gmail.com |
##   |turaid4321@outlook.com|
#
##===================================================================
##Scenario No.2:
#  @DeleteUserAccount
#  Scenario: User can successfully delete a user account
#
#    When I click on BankProject link
#    And I enter "<Manager ID>" in to user id text box
#    And I enter "<Manager Password>" in to password field
#    And I click on login button
#    And I click on Delete Customer link
#    And I enter "<customer ID>" in to customer id field
#    And click on submit button
#
#
##===================================================================
##Scenario No.3:
#  @newUserCredential
#  Scenario Outline: New User credential are generated using e-mail and user move back to Bank Home page
#    Given I navigate to Guru99Com-popup page
#    When I click on here link
#    And I enter user "<Email ID>" in to Email ID field
#    And I click on SubmitBttn button
#    And User ID and Password are displayed after few seconds
#    Then user closed all open tabs and move back to Bank HomePage.
#
#    Examples:
#      |Email ID                  |
#      |shaikkh12223344@gmail.com |
#    #===================================================================
##Scenario No.1: