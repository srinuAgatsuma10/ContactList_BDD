@DataDrivenTwo
Feature: Login Functionality - Data Driven

  Scenario Outline: Validate login with multiple user credentials
    Given user navigates to login page
    When user logs in using username "<username>" and password "<password>"
    Then login outcome should be "<expected_result>"

    Examples:
      | username              | password    | expected_result |
      | abcd1234@gmail.com   | 1234567890  | success         |
      | abcd1@gmail.com      | 12345670    | failure         |
      |                      | 1234567890  | failure         |
      | abcd1234@gmail.com   |             | failure         |