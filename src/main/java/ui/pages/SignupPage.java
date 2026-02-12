package ui.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SignupPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By newUserSignupText = By.xpath("//h2[text()='New User Signup!']");
    private final By nameField = By.xpath("//input[@data-qa='signup-name']");
    private final By emailField = By.xpath("//input[@data-qa='signup-email']");
    private final By signupButton = By.xpath("//button[@data-qa='signup-button']");

    private final By loginEmail = By.xpath("//input[@data-qa='login-email']");
    private final By loginPassword = By.xpath("//input[@data-qa='login-password']");
    private final By loginButton = By.xpath("//button[@data-qa='login-button']");

    private final By incorrectLoginError = By.xpath("//*[contains(text(),'Your email or password is incorrect!')]");

    private final By emailExistsError = By.xpath("//p[contains(text(),'Email Address already exist')]");


    public SignupPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Step("Verify 'New User Signup!' is visible")
    public boolean isNewUserSignupVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(newUserSignupText)).isDisplayed();
    }

    @Step("Enter name: {name}")
    public void enterName(String name) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(nameField)).sendKeys(name);
    }

    @Step("Enter email: {email}")
    public void enterEmail(String email) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailField)).sendKeys(email);
    }

    @Step("Click 'Signup' button")
    public void clickSignup() {
        wait.until(ExpectedConditions.elementToBeClickable(signupButton)).click();
    }

    @Step("Enter login email")
    public void enterLoginEmail(String email) {
        driver.findElement(loginEmail).sendKeys(email);
    }

    @Step("Enter login password")
    public void enterLoginPassword(String password) {
        driver.findElement(loginPassword).sendKeys(password);
    }

    @Step("Click login button")
    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    public boolean isLoginFormVisible() {
        try {
            return driver.findElement(loginEmail).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isIncorrectLoginErrorVisible() {
        try {
            return driver.findElement(incorrectLoginError).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    @Step("Verify 'Email Address already exist!' error is visible")
    public boolean isEmailAlreadyExistsErrorVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(emailExistsError)).isDisplayed();
    }

}
