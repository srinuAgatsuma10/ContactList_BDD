@DataDriven
Feature: Data Driven Login Test

  Scenario: Login with multiple users from Excel
    Given user is on login page for data driven test
    When user login using excel data
    Then validate login results
