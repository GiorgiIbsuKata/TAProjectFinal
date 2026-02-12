package ui.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ui.pages.HomePage;

public class SubscriptionTest extends BaseUiTest {

    @Test
    public void verifySubscriptionInHomePage() {
        HomePage home = new HomePage(driver);

        home.open();
        Assert.assertTrue(home.isHomePageVisible(), "Home page is not visible");

        home.scrollToFooter();
        Assert.assertTrue(home.isSubscriptionTitleVisible(), "'SUBSCRIPTION' title is not visible");

        home.subscribe("testemail@example.com");
        Assert.assertTrue(home.isSuccessMessageVisible(),
                "Success message was not displayed after subscribing");
    }
}
