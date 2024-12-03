import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;

public class LoginUserTest extends UserRegistrationAndRemoval {

    @Test
    public void testLoginSuccessfulWithValidData() {
        new HomePage(driver)
                .moveMouseToDropDownMenu()
                .clickLogoutButton();
        new LoginPage(driver)
                .inputEmail(validEmail)
                .inputPassword(password)
                .clickLoginButton();
        assertTrue(new HomePage(driver).isCreatePostDisplayed());
    }
}
