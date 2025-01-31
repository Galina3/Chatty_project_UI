import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pageObjects.RegistrationPage;

public class RegisterUserTest extends BaseTest {

    private RegistrationPage registrationPage;

    private final String validPassword = "7269056Gsm";

    private final String validEmail = "mdvgsm9@gmail.com";

    private final String invalidPassword = "7269056G";

    private final String invalidEmail = "test.gmail.com";

    @BeforeEach
    public void setUpBeforeTest() {
        this.registrationPage = new RegistrationPage(driver);
    }

    @Test
    public void testRegistrationUserFailsWithInvalidEmail() {
        registrationPage.inputEmail(invalidEmail)
                .inputPassword(validPassword)
                .inputConfirmPassword(validPassword)
                .registrationButtonIsNotClickable();
        assertTrue(registrationPage.isEmailErrorVisible());
        assertEquals("Incorrect email format", registrationPage.getEmailErrorText());
        assertTrue(registrationPage.getEmailErrorText().contains("Incorrect email"));
    }

    @Test
    public void testRegistrationUserFailsWithInvalidShortPasswords() {
        registrationPage.inputEmail(validEmail)
                .inputPassword(validPassword)
                .inputConfirmPassword(invalidPassword)
                .clickRegistrationButton()
                .registrationButtonIsNotClickable();
        assertTrue(registrationPage.isConfirmPasswordErrorMessageVisible());
        assertEquals("Passwords do not match", registrationPage.getConfirmPasswordErrorText());
        assertTrue(registrationPage.getConfirmPasswordErrorText().contains("do not match"));
    }

    @Test
    public void testContactUsButtonNavigatesToCorrectUrl() {
        registrationPage.clickContactUsButton();
        assertEquals("http://chatty.telran-edu.de:8089/login", registrationPage.getCurrentUrl());
    }

    @Test
    public void testAboutUsButtonNavigatesToCorrectUrl() {
        registrationPage.clickAboutUsButton();
        assertEquals("http://chatty.telran-edu.de:8089/login", registrationPage.getCurrentUrl());
    }

    @Test
    public void testLoginButtonNavigatesToCorrectUrl() {
        registrationPage.clickLoginButton();
        assertEquals("http://chatty.telran-edu.de:8089/login", registrationPage.getCurrentUrl());
    }
}

