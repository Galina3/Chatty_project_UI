import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

//@TestInstance(TestInstance.Lifecycle.PER_CLASS)//анатация которая позволяет BeforeAll работать без статического метода
public class BaseTest {
    protected WebDriver driver;

    @BeforeEach
    public void setupBrowser() {
        this.driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://chatty.telran-edu.de:8089/registration");
    }

    @AfterEach
    public void quitAfterTest() {
        if (driver != null) {
            driver.quit();
        }
    }
}
