package ui.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ui.pages.ContactUsPage;
import ui.pages.HomePage;

import java.nio.file.Paths;

public class ContactUsTest extends BaseUiTest {

    @Test
    public void contactUsFormTest() {
        HomePage home = new HomePage(driver);
        ContactUsPage contact = new ContactUsPage(driver);

        home.open();
        Assert.assertTrue(home.isHomePageVisible(), "Home page is not visible");

        home.clickContactUs();
        Assert.assertTrue(contact.isGetInTouchVisible(), "'GET IN TOUCH' is not visible");

        contact.fillContactForm(
                "Name",
                "Email@email.com",
                "Test",
                "hi"
        );



        contact.uploadFile(Paths.get("src/test/resources/forTest.docx")
                .toAbsolutePath()
                .toString());


        contact.clickSubmit();
        contact.acceptAlert();

        Assert.assertTrue(contact.isSuccessMessageVisible(),
                "Success message was not displayed");

        contact.clickHomeButton();
        Assert.assertTrue(home.isHomePageVisible(),
                "Did not return to home page");
    }
}
