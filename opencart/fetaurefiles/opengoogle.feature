Feature: Open Google.com

  Scenario: Open site and go to Register page
    Given open browser
    When click on the register
    Then verify user moved to register page
