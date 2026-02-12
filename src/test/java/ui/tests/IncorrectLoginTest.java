package ui.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ui.pages.HomePage;
import ui.pages.SignupPage;


public class IncorrectLoginTest extends BaseUiTest {

    @Test
    public void loginWithIncorrectCredentials() {
        HomePage home = new HomePage(driver);
        SignupPage signup = new SignupPage(driver);

        home.open();
        Assert.assertTrue(home.isHomePageVisible());

        home.clickSignupLogin();
        Assert.assertTrue(signup.isLoginFormVisible());

        signup.enterLoginEmail("wrong@email.com");
        signup.enterLoginPassword("wrongpass");
        signup.clickLoginButton();

        Assert.assertTrue(signup.isIncorrectLoginErrorVisible());
    }
}
