package ui.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ui.pages.HomePage;
import ui.pages.SignupPage;

public class RegisterExistingUserTest extends BaseUiTest {

    @Test
    public void registerUserWithExistingEmail() {
        HomePage home = new HomePage(driver);
        SignupPage signup = new SignupPage(driver);

        home.open();
        Assert.assertTrue(home.isHomePageVisible(), "Home page is not visible");

        home.clickSignupLogin();
        Assert.assertTrue(signup.isNewUserSignupVisible(), "'New User Signup!' text is not visible");

        signup.enterName("aaaa");
        signup.enterEmail("correct@email.taproject2");
        signup.clickSignup();

        Assert.assertTrue(signup.isEmailAlreadyExistsErrorVisible(),
                "Expected error 'Email Address already exist!' was not displayed");
    }
}
