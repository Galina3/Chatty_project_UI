package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
public class LoginPage extends BasePage {
    @FindBy(xpath = "//input[@placeholder='Email']")
    private WebElement emailLoginFormEditBox;
    @FindBy(xpath = "//input[@placeholder='Password']")
    private WebElement passwordLoginFormEditBox;
    @FindBy(xpath = "//button[contains(text(), 'Login')]")
    private WebElement loginButton;
    private WebDriverWait wait;
    public LoginPage(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    public LoginPage inputEmail(String email) {
        emailLoginFormEditBox.sendKeys(email);
        return this;
    }
    public LoginPage inputPassword(String password) {
        passwordLoginFormEditBox.sendKeys(password);
        return this;
    }
    public void clickLoginButton() {
        wait.until(ExpectedConditions.visibilityOf(loginButton));
        loginButton.click();
        new HomePage(driver);
    }
}

