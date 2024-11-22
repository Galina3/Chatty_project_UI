import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;

public class LoginUserTest extends UserRegistrationAndRemoval {

    @BeforeEach
    public void setUpBeforeTest() {
        LoginPage loginPage = new LoginPage(driver);
    }

    @Test
    public void testLoginSuccessfulWithValidData() {
        new HomePage(driver)
                .moveMouseToDropDownMenu()
                .clickLogoutButton();
        new LoginPage(driver).inputEmail(validEmail)
                .inputPassword(password)
                .clickLoginButton();
        assertTrue(new HomePage(driver).isCreatePostDisplayed());
    }
}
