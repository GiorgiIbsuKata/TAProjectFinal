package ui.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ContactUsPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By getInTouchHeader = By.xpath("//h2[text()='Get In Touch']");
    private final By nameField = By.xpath("//input[@data-qa='name']");
    private final By emailField = By.xpath("//input[@data-qa='email']");
    private final By subjectField = By.xpath("//input[@data-qa='subject']");
    private final By messageField = By.xpath("//textarea[@data-qa='message']");
    private final By uploadFileInput = By.xpath("//input[@type='file']");
    private final By submitButton = By.xpath("//input[@data-qa='submit-button']");
    private final By successMessage = By.xpath("//*[contains(text(),'Success! Your details have been submitted successfully.')]");

    private final By homeButton = By.xpath("//a[@class='btn btn-success']");

    public ContactUsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Step("Verify 'GET IN TOUCH' is visible")
    public boolean isGetInTouchVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(getInTouchHeader)).isDisplayed();
    }

    @Step("Enter contact form details")
    public void fillContactForm(String name, String email, String subject, String message) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(nameField)).sendKeys(name);
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(subjectField).sendKeys(subject);
        driver.findElement(messageField).sendKeys(message);
    }

    @Step("Upload file: {filePath}")
    public void uploadFile(String filePath) {
        driver.findElement(uploadFileInput).sendKeys(filePath);
    }

    @Step("Click 'Submit' button")
    public void clickSubmit() {
        driver.findElement(submitButton).click();
    }

    @Step("Accept alert popup")
    public void acceptAlert() {
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
    }

    @Step("Verify success message is visible")
    public boolean isSuccessMessageVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage)).isDisplayed();
    }

    @Step("Click 'Home' button")
    public void clickHomeButton() {
        wait.until(ExpectedConditions.elementToBeClickable(homeButton)).click();
    }
}
