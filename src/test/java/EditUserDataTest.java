import org.junit.jupiter.api.Test;
import pageObjects.*;

import static org.junit.jupiter.api.Assertions.*;

public class EditUserDataTest extends UserRegistrationAndRemoval {

    private final String userName = "Ira";
    private final String surname = "Irova";
    private final String phone = "+123456789";

    @Test
    public void editUserValidTest() {

        new HomePage(driver).openHomePage()
                .moveMouseToDropDownMenu()
                .clickLogoutButton();
        new LoginPage(driver)
                .inputEmail(ADMIN_EMAIL)
                .inputPassword(ADMIN_PASSWORD)
                .clickLoginButton();
        new AdminPanelPage(driver)
                .inputSearchByEmailEditBox(validEmail)
                .clickSearchButton()
                .clickEditingUserButton();
        new UserProfilePage(driver)
                .enterEditButton();
        new UserProfilePage(driver)
                .enterInputFieldName(userName)
                .enterInputFieldSurname(surname)
                .enterFieldPhone(phone)
                .clickSaveButton();
        assertTrue(new UserProfilePage(driver).isLoginButtonClickable());
    }
}
