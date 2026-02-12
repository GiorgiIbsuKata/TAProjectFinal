package ui.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AccountCreatedPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By accountCreatedText = By.xpath("//b[text()='Account Created!']");
    private final By continueButton = By.xpath("//a[@data-qa='continue-button']");

    public AccountCreatedPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Step("Verify 'ACCOUNT CREATED!' is visible")
    public boolean isAccountCreatedVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(accountCreatedText)).isDisplayed();
    }

    @Step("Click 'Continue'")
    public void clickContinue() {
        driver.findElement(continueButton).click();
    }

}
