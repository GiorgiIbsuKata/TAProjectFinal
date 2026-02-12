package ui.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ui.pages.HomePage;
import ui.pages.SignupPage;

public class CorrectLoginTest extends BaseUiTest {

    @Test(description = "Test Case 2: Login User with correct email and password")
    public void loginUserWithCorrectCredentials() {

        HomePage home = new HomePage(driver);
        SignupPage signup = new SignupPage(driver);

        home.open();
        Assert.assertTrue(home.isHomePageVisible(), "Home page is NOT visible");

        home.clickSignupLogin();

        Assert.assertTrue(signup.isLoginFormVisible(), "'Login to your account' is NOT visible");

        signup.enterLoginEmail("accountfortest@project.final");
        signup.enterLoginPassword("shouldwork");

        signup.clickLoginButton();

        Assert.assertTrue(home.isLoggedIn(), "'Logged in as username' is NOT visible");

        home.clickDeleteAccount();

        Assert.assertTrue(home.isAccountDeletedVisible(), "'ACCOUNT DELETED!' is NOT visible");

        home.clickContinue();
    }
}
