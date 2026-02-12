package ui.tests;

import config.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import io.qameta.allure.Description;
import io.qameta.allure.Story;
import io.qameta.allure.Step;
import utils.DriverUtils;

public class BaseUiTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = DriverFactory.getDriver();
    }

    @AfterMethod
    @Story("Failing of Test")
    @Description("Failed Test")
    @Step("Failed Test")
    public void afterFail(ITestResult result) {
        if (!result.isSuccess()) {
            DriverUtils.screenshot(driver);
        }
        DriverFactory.quitDriver();
    }
}
