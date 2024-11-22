import org.junit.jupiter.api.Test;
import pageObjects.*;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class EditUserDataTest extends UserRegistrationAndRemoval {

    private final String userName = "Ira";
    private final String surname = "Irova";
    private final String phone = "+123456789";


    @Test
    public void editUserValidTest() {

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

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

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        new UserProfilePage(driver)
                .enterInputFieldName(userName)
                .enterInputFieldSurname(surname)
                //  .enterInputFieldGender()
                //  .enterInputFieldBirthdate()
                .enterFieldPhone(phone)
                .clickSaveButton();
    //    assertFalse(new UserProfilePage(driver).isElementClickable(driver, ), "Entry field is clickable, but it should not be!");


    }
}
