import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pageObjects.RegistrationPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class RegisterUserTest extends BaseTest{
    private RegistrationPage registrationPage;
    private String noValidEmail = "mdv.gmail.com";
    private String password ="7269056Gsm";




    @BeforeEach
    public void setUpBeforeTest() {
        this.registrationPage = new RegistrationPage(driver);
        driver.get("http://chatty.telran-edu.de:8089/registration");
    }



    @Test
    public void userRegistrationTestWithInvalidEmail(){
        registrationPage.inputEmail(noValidEmail);
        assertTrue(registrationPage.isErrorMessageInvalidEmailDisplayed());
//      String errorMessage = personalDataPage.getInvalidEmailErrorText("");
//        assertEquals(personalDataPage.invalidEmailRegistrationEditBox, errorMessage);
        //text proverit
    }
    public void userRegistrationTestWithInvalidConfirmPassword(){
        registrationPage.inputPassword(password);
        assertTrue(registrationPage.isErrorMessageInvalidEmailDisplayed());
    }
    //  @AfterEach  admin delete user
}
