package ui.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ui.pages.HomePage;
import ui.pages.SignupPage;

public class LogoutUserTest extends BaseUiTest {

    @Test
    public void logoutUser() {
        HomePage home = new HomePage(driver);
        SignupPage signup = new SignupPage(driver);

        home.open();
        Assert.assertTrue(home.isHomePageVisible());

        home.clickSignupLogin();
        Assert.assertTrue(signup.isLoginFormVisible());

        signup.enterLoginEmail("testproject2@itestthis.com");
        signup.enterLoginPassword("password");
        signup.clickLoginButton();

        Assert.assertTrue(home.isLoggedIn());

        home.clickLogout();

        Assert.assertTrue(signup.isLoginFormVisible());
    }
}
