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

    @FindBy(xpath = "//div[contains(text(), 'Incorrect email')]")
    private WebElement emailErrorMessage;

    @FindBy(xpath = "//div[@class='text-error']")
    private WebElement loginErrorMessage;

    private final WebDriverWait wait;

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

    public HomePage clickLoginButton(){
        wait.until(ExpectedConditions.visibilityOf(loginButton));
        loginButton.click();
        return new HomePage(driver);
    }

    public void loginButtonIsNotClickable() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.not(ExpectedConditions.elementToBeClickable(loginButton)));
    }

    public boolean isLoginButtonClickable() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            wait.until(ExpectedConditions.elementToBeClickable(loginButton));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isEmailErrorMessageVisible() {
        wait.until(ExpectedConditions.visibilityOf(emailErrorMessage));
        return emailErrorMessage.isDisplayed();
    }

    public String getEmailErrorMessageText() {
        return emailErrorMessage.getText();
    }

    public boolean isLoginErrorMessageVisible() {
        wait.until(ExpectedConditions.visibilityOf(loginErrorMessage));
        return loginErrorMessage.isDisplayed();
    }

    public String getLoginErrorMessageText() {
        return loginErrorMessage.getText();
    }
}







