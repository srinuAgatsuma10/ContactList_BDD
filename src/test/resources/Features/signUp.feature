@Regression
Feature: SignUp Functionality
  Scenario: Create a new user account
    Given click on signUp button in login page
    When Enter all user details
    Then user shold create account succesfully