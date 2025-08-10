package Veeva.SeleniumFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CarbCalculatorPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public CarbCalculatorPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

  
    @FindBy(css = "label[for='csex1']")
    private WebElement genderMaleLabel;

    @FindBy(css = "label[for='csex2']")
    private WebElement genderFemaleLabel;

    @FindBy(id = "cactivity")
    private WebElement activityLevelDropdown;

    @FindBy(xpath = "//input[@value='Calculate']")
    private WebElement calculateButton;

    @FindBy(xpath = "//p[@class='bigtext']")
    public WebElement resultText;

    @FindBy(xpath = "//a[contains(text(),'US Units')]")
    private WebElement usStandardUnitsTab;

    @FindBy(xpath = "//font[@color='red']")
    private WebElement errorMessage;

    public void openPage(String url) {
        driver.get(url);
    }

    public void selectUSStandardUnits() {
        wait.until(ExpectedConditions.elementToBeClickable(usStandardUnitsTab)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cheightfeet")));
    }

    public void enterAge(String age) {
        WebElement ageInput = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("cage"))));
        ageInput.clear();
        ageInput.sendKeys(age);
    }

    public void selectGender(String gender) {
        if (gender.equalsIgnoreCase("male")) {
            wait.until(ExpectedConditions.elementToBeClickable(genderMaleLabel)).click();
        } else {
            wait.until(ExpectedConditions.elementToBeClickable(genderFemaleLabel)).click();
        }
    }

    public void enterHeight(String feet, String inches) {
        WebElement feetInput = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("cheightfeet"))));
        feetInput.clear();
        feetInput.sendKeys(feet);

        WebElement inchInput = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("cheightinch"))));
        inchInput.clear();
        inchInput.sendKeys(inches);
    }

    public void enterWeight(String weight) {
        WebElement weightInput = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("cpound"))));
        weightInput.clear();
        weightInput.sendKeys(weight);
    }

    public void selectActivityLevel(String level) {
        wait.until(ExpectedConditions.visibilityOf(activityLevelDropdown));
        Select select = new Select(activityLevelDropdown);
        select.selectByVisibleText(level);
    }

    public void clickCalculate() {
        wait.until(ExpectedConditions.elementToBeClickable(calculateButton)).click();
    }

    public String getErrorMessage() {
        try {
            return wait.until(ExpectedConditions.visibilityOf(errorMessage)).getText().trim();
        } catch (Exception e) {
            return "";
        }
    }
}
