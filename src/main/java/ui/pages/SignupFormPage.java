package ui.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SignupFormPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By enterAccountInfoText = By.xpath("//b[text()='Enter Account Information']");
    private final By titleMr = By.id("id_gender1");
    private final By passwordField = By.id("password");
    private final By days = By.id("days");
    private final By months = By.id("months");
    private final By years = By.id("years");

    private final By newsletterCheckbox = By.id("newsletter");
    private final By offersCheckbox = By.id("optin");

    private final By firstName = By.id("first_name");
    private final By lastName = By.id("last_name");
    private final By company = By.id("company");
    private final By address1 = By.id("address1");
    private final By address2 = By.id("address2");
    private final By country = By.id("country");
    private final By state = By.id("state");
    private final By city = By.id("city");
    private final By zipcode = By.id("zipcode");
    private final By mobile = By.id("mobile_number");

    private final By createAccountButton = By.xpath("//button[@data-qa='create-account']");

    public SignupFormPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Step("Verify 'ENTER ACCOUNT INFORMATION' is visible")
    public boolean isEnterAccountInfoVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(enterAccountInfoText)).isDisplayed();
    }

    @Step("Fill account information")
    public void fillAccountInfo() {
        wait.until(ExpectedConditions.elementToBeClickable(titleMr)).click();
        driver.findElement(passwordField).sendKeys("Password123");
        driver.findElement(days).sendKeys("10");
        driver.findElement(months).sendKeys("May");
        driver.findElement(years).sendKeys("1999");
    }

    @Step("Select newsletter and offers checkboxes")
    public void selectCheckboxes() {
        driver.findElement(newsletterCheckbox).click();
        driver.findElement(offersCheckbox).click();
    }

    @Step("Fill address information")
    public void fillAddressInfo() {
        driver.findElement(firstName).sendKeys("TestUser");
        driver.findElement(lastName).sendKeys("Automation");
        driver.findElement(company).sendKeys("TestCompany");
        driver.findElement(address1).sendKeys("Rustaveli Avenue 15");
        driver.findElement(address2).sendKeys("Apartment 4");
        driver.findElement(country).sendKeys("Georgia");
        driver.findElement(state).sendKeys("Tbilisi");
        driver.findElement(city).sendKeys("Tbilisi");
        driver.findElement(zipcode).sendKeys("0108");
        driver.findElement(mobile).sendKeys("+995555123456");
    }

    @Step("Click 'Create Account'")
    public void clickCreateAccount() {
        wait.until(ExpectedConditions.elementToBeClickable(createAccountButton)).click();
    }
}
