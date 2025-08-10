Feature: Carbohydrate Calculator - Negative Input Validation

  Scenario: Negative age input
    Given I open the carbohydrate calculator page
    When I select US Standard units
    And I enter age "-5"
    And I select gender "Male"
    And I enter height "5" feet and "10" inches
    And I enter weight "-150"
    And I select activity level "Moderate: exercise 4-5 times/week"
    And I click calculate
    Then I should see an error message containing "Please provide an age between 18 and 80"

  Scenario: Negative feet input
    Given I open the carbohydrate calculator page
    When I select US Standard units
    And I enter age "30"
    And I select gender "Female"
    And I enter height "-1" feet and "5" inches
    And I enter weight "140"
    And I select activity level "Light: exercise 1-3 times/week"
    And I click calculate
    Then I should see an error message containing "Please provide positive height value"

  Scenario: Negative inches input
    Given I open the carbohydrate calculator page
    When I select US Standard units
    And I enter age "25"
    And I select gender "Male"
    And I enter height "5" feet and "-3" inches
    And I enter weight "160"
    And I select activity level "Very Active: intense exercise 6-7 times/week"
    And I click calculate
    Then I should see an error message containing "Please provide positive height value"

  Scenario: Negative weight input
    Given I open the carbohydrate calculator page
    When I select US Standard units
    And I enter age "40"
    And I select gender "Female"
    And I enter height "5" feet and "6" inches
    And I enter weight "-100"
    And I select activity level "Moderate: exercise 4-5 times/week"
    And I click calculate
    Then I should see an error message containing "Please provide positive weight value"
    
  Scenario: Boundary age check below 18
    Given I open the carbohydrate calculator page
    When I select US Standard units
    And I enter age "17"
    And I select gender "Female"
    And I enter height "5" feet and "6" inches
    And I enter weight "100"
    And I select activity level "Moderate: exercise 4-5 times/week"
    And I click calculate
    Then I should see an error message containing "Please provide an age between 18 and 80"

    
  
