package veeva.stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.en.*;
import org.testng.Assert;
import Veeva.SeleniumFramework.CarbCalculatorPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class StepDefinitionImpl {

    private WebDriver driver;
    private CarbCalculatorPage carbCalculatorPage;

    @Given("I open the carbohydrate calculator page")
    public void openCarbCalculatorPage() {
        driver = new ChromeDriver();
        carbCalculatorPage = new CarbCalculatorPage(driver);
        carbCalculatorPage.openPage("https://www.calculator.net/carbohydrate-calculator.html");
    }

    @When("I select US Standard units")
    public void selectUSStandardUnits() {
        carbCalculatorPage.selectUSStandardUnits();
    }

    @When("I enter age {string}")
    public void enterAge(String age) {
        carbCalculatorPage.enterAge(age);
    }

    @When("I select gender {string}")
    public void selectGender(String gender) {
        carbCalculatorPage.selectGender(gender);
    }

    @When("I enter height {string} feet and {string} inches")
    public void enterHeight(String feet, String inches) {
        carbCalculatorPage.enterHeight(feet, inches);
    }

    @When("I enter weight {string}")
    public void enterWeight(String weight) {
        carbCalculatorPage.enterWeight(weight);
    }

    @When("I select activity level {string}")
    public void selectActivityLevel(String level) {
        carbCalculatorPage.selectActivityLevel(level);
    }

    @When("I click calculate")
    public void clickCalculate() {
        carbCalculatorPage.clickCalculate();
    }

    @Then("I should see an error message containing {string}")
    public void verifyErrorMessage(String expectedMessage) {
        String actualMessage = carbCalculatorPage.getErrorMessage();
        Assert.assertTrue(actualMessage.contains(expectedMessage),
                "Expected error message to contain: " + expectedMessage + " but was: " + actualMessage);
    }

    @Then("I should see a result displayed")
    public void verifyResultDisplayed() {
        String result = carbCalculatorPage.resultText.getText().trim();
        Assert.assertFalse(result.isEmpty(), "Expected result text but it was empty");
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
