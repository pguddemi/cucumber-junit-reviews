Feature: Login Functionality tests

  @validLogin
  Scenario: Login with valid credential
    Given the user is on the login page
    When the user enter valid username
    And the user enter valid password
    And the user clicks the "Log in" button
    Then the user should be able to log in
