Feature: API Testing
  Scenario: Verify a successful response from the API
    Given I have the API endpoint ""
    When I send a GET request to the API
    Then the response status code should be 200
    And the response body should contain "quia et suscipit"

  Scenario: Verify an unsuccessful response from the API
    Given I have the API endpoint ""
    When I send a GET request to the API
    Then the response status code should be 404