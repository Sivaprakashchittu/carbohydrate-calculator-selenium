Feature: Carbohydrate Calculator

  Scenario Outline: Calculate carbohydrate needs for a user
    Given I open the carbohydrate calculator page
    When I select US Standard units
    And I enter age "<age>"
    And I select gender "<gender>"
    And I enter height "<feet>" feet and "<inches>" inches
    And I enter weight "<weight>"
    And I select activity level "<activity>"
    And I click calculate
    Then I should see a result displayed

  Examples:
    | age | gender | feet | inches | weight | activity                        |
    | 30  | Male   | 5    | 10     | 70     | Moderate: exercise 4-5 times/week |
    | 25  | Female | 5    | 5      | 60     | Light: exercise 1-3 times/week  |
    | 40  | Male   | 6    | 2      | 80     | Very Active: intense exercise 6-7 times/week |
