package ui.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By homePageVisible = By.cssSelector(".features_items");
    private final By signupLoginButton = By.xpath("//a[@href='/login']");
    private final By deleteAccountButton = By.xpath("//a[normalize-space()='Delete Account']");
    private final By accountDeletedText = By.xpath("//b[text()='Account Deleted!']");
    private final By continueButton = By.xpath("//a[@data-qa='continue-button']");
    private final By loggedInAs = By.xpath("//a[contains(text(),'Logged in as')]");

    private final By logoutButton = By.xpath("//a[@href='/logout']");

    private final By contactUsButton = By.xpath("//a[text()=' Contact us']");

    private final By testCasesButton = By.xpath("//a[text()=' Test Cases']");

    private final By productsButton = By.xpath("//a[text()=' Products']");

    private final By subscriptionTitle = By.xpath("//h2[contains(text(),'Subscription')]");
    private final By emailInput = By.id("susbscribe_email");
    private final By subscribeButton = By.id("subscribe");
    private final By successMessage = By.xpath("//div[contains(text(),'You have been successfully subscribed!')]");


    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private void tinyPause(long millis) {
        long end = System.currentTimeMillis() + millis;
        while (System.currentTimeMillis() < end) {}
    }

    private void closeAdIfPresent() {
        By adClose = By.cssSelector(".close-modal, .close, .modal-close, .popup-close");
        try {
            var ad = driver.findElement(adClose);
            if (ad.isDisplayed()) ad.click();
        } catch (Exception ignored) {}
    }

    private void safeClick(By locator) {
        for (int i = 0; i < 3; i++) {
            closeAdIfPresent();
            try {
                driver.findElement(locator).click();
                return;
            } catch (Exception ignored) {}
            tinyPause(120);
        }
        throw new RuntimeException("Failed to click element after 3 attempts: " + locator);
    }

    public boolean waitUntilLoggedIn() {
        for (int i = 0; i < 20; i++) {
            try {
                if (driver.findElement(loggedInAs).isDisplayed()) return true;
            } catch (Exception ignored) {}
            tinyPause(80);
        }
        return false;
    }

    @Step("Open AutomationExercise homepage")
    public void open() {
        driver.get("https://automationexercise.com");
    }

    @Step("Verify home page is visible")
    public boolean isHomePageVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(homePageVisible)).isDisplayed();
    }

    @Step("Click 'Signup / Login'")
    public void clickSignupLogin() {
        safeClick(signupLoginButton);
    }

    @Step("Click 'Delete Account' button")
    public void clickDeleteAccount() {
        waitUntilLoggedIn();
        safeClick(deleteAccountButton);
    }

    @Step("Verify 'ACCOUNT DELETED!' is visible")
    public boolean isAccountDeletedVisible() {
        try {
            return driver.findElement(accountDeletedText).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    @Step("Click 'Continue'")
    public void clickContinue() {
        safeClick(continueButton);
    }

    @Step("Check if user is logged in")
    public boolean isLoggedIn() {
        try {
            return driver.findElement(loggedInAs).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    @Step("Click 'Logout' button")
    public void clickLogout() {
        wait.until(ExpectedConditions.elementToBeClickable(logoutButton)).click();
    }

    @Step("Click on 'Contact Us' button")
    public void clickContactUs() {
        wait.until(ExpectedConditions.elementToBeClickable(contactUsButton)).click();
    }

    @Step("Click on 'Test Cases' button")
    public void clickTestCases() {
        wait.until(ExpectedConditions.elementToBeClickable(testCasesButton)).click();
    }

    @Step("Click on 'Products' button")
    public void clickProducts() {
        wait.until(ExpectedConditions.elementToBeClickable(productsButton)).click();
    }

    @Step("Scroll to footer")
    public void scrollToFooter() {
        WebElement footer = wait.until(ExpectedConditions.visibilityOfElementLocated(subscriptionTitle));
        scrollToElement(footer);
    }

    @Step("Verify 'SUBSCRIPTION' title is visible")
    public boolean isSubscriptionTitleVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(subscriptionTitle)).isDisplayed();
    }

    @Step("Enter email '{email}' and click subscribe")
    public void subscribe(String email) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailInput)).sendKeys(email);
        wait.until(ExpectedConditions.elementToBeClickable(subscribeButton)).click();
    }

    @Step("Verify subscription success message is visible")
    public boolean isSuccessMessageVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage)).isDisplayed();
    }

    @Step("Scroll to element")
    public void scrollToElement(WebElement element){
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", element
        );
    }

}
