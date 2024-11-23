package pageObjects;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DraftPage extends BasePage {

    String currentUrl = driver.getCurrentUrl();

    private WebDriverWait wait;

    public DraftPage(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }




}
