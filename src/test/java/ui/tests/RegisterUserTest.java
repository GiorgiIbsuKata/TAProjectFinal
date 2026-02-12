package ui.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ui.pages.*;

public class RegisterUserTest extends BaseUiTest {

    @Test
    public void registerUser() {

        HomePage home = new HomePage(driver);
        SignupPage signup = new SignupPage(driver);
        SignupFormPage form = new SignupFormPage(driver);
        AccountCreatedPage created = new AccountCreatedPage(driver);

        home.open();
        Assert.assertTrue(home.isHomePageVisible(), "Home page not visible");

        home.clickSignupLogin();
        Assert.assertTrue(signup.isNewUserSignupVisible(), "'New User Signup!' not visible");

        signup.enterName("TestUser");

        String email = "testuser" + (int)(Math.random() * 10000) + "@test.com";
        signup.enterEmail(email);

        signup.clickSignup();

        Assert.assertTrue(form.isEnterAccountInfoVisible(), "'ENTER ACCOUNT INFORMATION' not visible");

        form.fillAccountInfo();
        form.selectCheckboxes();
        form.fillAddressInfo();
        form.clickCreateAccount();

        Assert.assertTrue(created.isAccountCreatedVisible(), "'ACCOUNT CREATED!' not visible");

        created.clickContinue();

        Assert.assertTrue(home.isLoggedIn(), "'Logged in as username' not visible");
        home.clickDeleteAccount();
        Assert.assertTrue(home.isAccountDeletedVisible(), "'ACCOUNT DELETED!' not visible");
        home.clickContinue();
    }
}
