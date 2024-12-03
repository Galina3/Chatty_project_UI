import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BaseTest {
    protected WebDriver driver;

    @BeforeEach
    public void setupBrowser() {
        this.driver = new ChromeDriver();
        driver.get("http://chatty.telran-edu.de:8089/registration");
    }

    @AfterEach
    public void quitAfterTest() {
        driver.quit();
    }
}
