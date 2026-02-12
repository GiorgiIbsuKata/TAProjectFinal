package ui.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TestCasesPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By testCasesHeader = By.xpath("//h2[contains(normalize-space(),'Test Cases')]");


    public TestCasesPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Step("Verify Test Cases page is visible")
    public boolean isTestCasesPageVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(testCasesHeader)).isDisplayed();
    }
}
