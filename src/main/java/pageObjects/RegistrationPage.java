package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegistrationPage extends BasePage {
    @FindBy(xpath = "//input [@placeholder='Email']")
    public WebElement emailRegistrationEditBox;
   
    @FindBy(xpath = "//input[@placeholder='Password']")
    public WebElement passwordRegistrationEditBox;
   
    @FindBy(xpath = "//input[@placeholder='Confirm password']")
    public WebElement confirmPasswordRegistrationEditBox;
   
    @FindBy(xpath = "//button[@class='registration-btn']")
    public WebElement registrationButton;

    @FindBy(xpath = "//a[contains(text(), 'Login')]")
    public WebElement loginButton;

    @FindBy(xpath = "//div[contains(text(), 'Incorrect email format')]")
    public WebElement emailErrorMessage;

    @FindBy(xpath = "//div[contains(text(), 'Passwords do not match')]")
    public WebElement confirmPasswordErrorMessage;

    @FindBy(xpath = "//a[contains(text(),'Contact us')]")
    public WebElement contactUsButton;

    @FindBy(xpath = "//a[contains(text(),'About us')]")
    public WebElement aboutUsButton;

    private final WebDriverWait wait;

    public RegistrationPage(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public RegistrationPage inputEmail(String email) {
        emailRegistrationEditBox.sendKeys(email);
        return this;
    }

    public RegistrationPage inputPassword(String password) {
        passwordRegistrationEditBox.sendKeys(password);
        return this;
    }

    public RegistrationPage inputConfirmPassword(String confirmPassword) {
        confirmPasswordRegistrationEditBox.sendKeys(confirmPassword);
        return this;
    }

    public boolean isEmailErrorVisible() {
        wait.until(ExpectedConditions.visibilityOf(emailErrorMessage));
        return emailErrorMessage.isDisplayed();
    }

    public String getEmailErrorText() {
        return emailErrorMessage.getText();
    }

    public boolean isConfirmPasswordErrorMessageVisible() {
        wait.until(ExpectedConditions.visibilityOf(confirmPasswordErrorMessage));
        return confirmPasswordErrorMessage.isDisplayed();
    }

    public String getConfirmPasswordErrorText() {
        return confirmPasswordErrorMessage.getText();
    }

    public RegistrationPage clickRegistrationButton() {
        registrationButton.click();
        return this;
    }
    public HomePage clickRegistrationButtonHomePage(){
        wait.until(ExpectedConditions.visibilityOf(registrationButton));
        registrationButton.click();
        return new HomePage(driver);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public void clickContactUsButton() {
        contactUsButton.click();
    }

    public void clickAboutUsButton() {
        aboutUsButton.click();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public void registrationButtonIsNotClickable() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.not(ExpectedConditions.elementToBeClickable(registrationButton)));
    }
}

