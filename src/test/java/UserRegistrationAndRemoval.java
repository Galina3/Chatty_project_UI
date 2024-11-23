import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import pageObjects.AdminPanelPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.RegistrationPage;
import randomGenerator.RandomDataUtil;


public class UserRegistrationAndRemoval extends BaseTest {
    protected String validEmail;
    protected String password = "12345678909876543210Gsm";
    protected final static String ADMIN_EMAIL = "admintest@gmail.com";
    protected final static String ADMIN_PASSWORD = "Admin1234567890";
   // LoginPage loginPage = new LoginPage(driver);
    //AdminPanelPage adminPanelPage = new AdminPanelPage(driver);
    private AdminPanelPage adminPanelPage;
    private HomePage homePage;
    private LoginPage loginPage;



    @BeforeEach
    public void registerUser() {
        this.validEmail = RandomDataUtil.getRandomValidEmail();

        new RegistrationPage(driver)
                .inputEmail(validEmail)
                .inputPassword(password)
                .inputConfirmPassword(password)
                .clickRegistrationButton();
    }

    @AfterEach
    public void adminLoginDeleteUser() {
        new HomePage(driver)
                .openHomePage()
                .moveMouseToDropDownMenu()
                .clickLogoutButton();
        new LoginPage(driver).inputEmail(ADMIN_EMAIL)
                .inputPassword(ADMIN_PASSWORD)
                .clickLoginButton();
        new AdminPanelPage(driver).inputSearchByEmailEditBox(validEmail).clickSearchButton();
        new AdminPanelPage(driver).clickDeleteUserButton();
    }
}