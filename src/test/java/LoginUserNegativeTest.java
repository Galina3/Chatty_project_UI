import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pageObjects.LoginPage;

import static org.junit.jupiter.api.Assertions.*;

public class LoginUserNegativeTest extends BaseTest {

    private LoginPage loginPage;

    private final String invalidEmail = "mdv2.gmail.com";

    private final String validPassword = "7304227Gsm";

    private final String emptyEmail = "";

    private final String validEmail = "mdvgsm3@gmail.com";

    private final String emptyPassword = "";

    @BeforeEach
    public void setUpBeforeTest() {
        this.loginPage = new LoginPage(driver);
        driver.get("http://chatty.telran-edu.de:8089/login");
    }

    @Test
    public void testLoginFailsWithInvalidEmail() {
        new LoginPage(driver).inputEmail(invalidEmail)
                .inputPassword(validPassword)
                .loginButtonIsNotClickable();
        assertFalse(loginPage.isLoginButtonClickable());
        assertTrue(loginPage.isEmailErrorMessageVisible());
        assertEquals("Incorrect email", loginPage.getEmailErrorMessageText());
        assertTrue(loginPage.getEmailErrorMessageText().contains("Incorrect"));
    }

    @Test
    public void testLoginFailsWithEmptyFields() {
        new LoginPage(driver).inputEmail(emptyEmail)
                .inputPassword(emptyPassword)
                .loginButtonIsNotClickable();
        assertFalse(loginPage.isLoginButtonClickable());
    }

    @Test
    public void testLoginFailsWithEmptyEmail() {
        new LoginPage(driver).inputEmail(emptyEmail)
                .inputPassword(validPassword)
                .loginButtonIsNotClickable();
        assertFalse(loginPage.isLoginButtonClickable());
    }

    @Test
    public void testLoginFailsWithEmptyPassword() {
        new LoginPage(driver).inputEmail(validEmail)
                .inputPassword(emptyPassword)
                .clickLoginButton();
        assertTrue(loginPage.isLoginButtonClickable());
        assertTrue(loginPage.isLoginErrorMessageVisible());
        assertEquals("Invalid email or password. Please try again.", loginPage.getLoginErrorMessageText());
        assertTrue(loginPage.getLoginErrorMessageText().contains("Invalid email or password"));
    }
}
