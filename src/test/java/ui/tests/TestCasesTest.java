package ui.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ui.pages.HomePage;
import ui.pages.TestCasesPage;

public class TestCasesTest extends BaseUiTest {

    @Test
    public void verifyTestCasesPageNavigation() {
        HomePage home = new HomePage(driver);
        TestCasesPage testCases = new TestCasesPage(driver);

        home.open();
        Assert.assertTrue(home.isHomePageVisible(), "Home page is not visible");

        home.clickTestCases();
        Assert.assertTrue(testCases.isTestCasesPageVisible(),
                "User was not navigated to the Test Cases page");
    }
}
