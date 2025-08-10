# Carbohydrate Calculator Test Automation

This project automates testing of the [Carbohydrate Calculator](https://www.calculator.net/carbohydrate-calculator.html) web application using Selenium WebDriver, Cucumber (BDD), and TestNG in Java. It includes tests for both valid inputs and negative validation scenarios.

## Project Structure

- **Page Object Model:** `CarbCalculatorPage` contains web element locators and interaction methods.
- **Step Definitions:** Glue code mapping Gherkin steps to Selenium actions.
- **Feature files:** Contain test scenarios written in Gherkin syntax.
- **TestNG Runner:** To execute Cucumber feature files.

## Prerequisites

- Java JDK 11 or above installed
- Maven installed and configured (`mvn` command available)
- Chrome browser installed
- ChromeDriver executable available in system path or configured in your environment

## Setup

1. Clone the repository (or download the project files).
2. Ensure ChromeDriver matches your Chrome version. Download from [ChromeDriver](https://chromedriver.chromium.org/downloads) if needed.
3. Update ChromeDriver path (if required) in your code or add it to system PATH environment variable.

## How to Run Tests

1. Open terminal or command prompt in the project root folder.
2. Run the following Maven command to execute all tests:

    ```bash
    mvn test
    ```

3. Maven will compile the project, launch Chrome, and run the Cucumber scenarios.
4. After test execution, results will be generated at:

    ```
    target/cucumber.html
    ```

5. Open this HTML file in a browser to view detailed test reports.

## Features Covered

- Selecting US Standard units for inputs
- Entering age, gender, height (feet/inches), weight
- Selecting activity level
- Calculating carbohydrate needs
- Validation of error messages for negative and out-of-bound inputs
- Verification of result display on valid inputs

## Test Execution Details

- The tests use the **Page Object Model** to abstract UI interaction.
- Synchronization is handled by explicit waits.
- Tests cover both **positive** and **negative** scenarios for input validation.
- The browser closes automatically after each scenario.

## Notes

- If you want to run specific feature files, modify the `features` path in the `TestNGrunner` class.
- Adjust timeout durations or ChromeDriver path as needed.
- For other browsers, replace ChromeDriver with the appropriate WebDriver and driver binary.

---

Happy Testing! 🚀
