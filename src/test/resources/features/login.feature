Feature: Verify Login Page Navigation

  Background:
    Given I am on the Zudu AI Landing Page

  @smoke
#    Scenario: Successful navigate from landing page to login page
  Scenario Outline:
    When I click the Login button
    And I enter email "<email>"
    And I click the Continue button
    Then I should be navigate to the password page
    Examples:
      | email                |
      | qateam@zudu.ai       |
      | mohamedh@zudu.ai     |
      | invalidemail@zudu.ai |

