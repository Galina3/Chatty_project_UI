import org.junit.jupiter.api.Test;
import pageObjects.ContactPage;
import pageObjects.HomePage;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ContactUsFormTest extends UserRegistrationAndRemoval {

    private final String username = "tester";

    private final String validEmail = "tester5689@gmail.com";

    @Test
    public void submitContactUsFormWithValidDataTest() {
        new HomePage(driver)
                .openContactPage();
        new ContactPage(driver)
                .inputUsername(username)
                .inputEmail(validEmail)
                .inputMessage("Lorem hdhjdkdh")
                .clickSendMessageButton();
        assertTrue(new ContactPage(driver).isMessageSent());
    }

    @Test
    public void submitContactUsFormWithEmptyMessageFieldTest() {
        new HomePage(driver)
                .openContactPage();
        new ContactPage(driver)
                .inputUsername(username)
                .inputEmail(validEmail);
        assertFalse(new ContactPage(driver).isMessageSent());
    }

    @Test
    public void submitContactUsFormWithInvalidEmailTest() {
        new HomePage(driver)
                .openContactPage();
        new ContactPage(driver)
                .inputEmail("InValidEmail");
        assertTrue(new ContactPage(driver).isErrorMessageInvalidEmailDisplayed());
    }
}