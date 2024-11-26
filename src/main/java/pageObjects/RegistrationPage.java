package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegistrationPage extends BasePage{
    @FindBy(xpath = "//input [@placeholder='Email']")
    public WebElement emailRegistrationEditBox;
    @FindBy(xpath = "//input[@placeholder='Password']")
    public WebElement passwordRegistrationEditBox;
    @FindBy(xpath = "//input[@placeholder='Confirm password']")
    public WebElement confirmPasswordRegistrationEditBox;
    @FindBy(xpath = "//button[@class='registration-btn']")
    public WebElement registrationButton;
    private WebDriverWait wait;
    public RegistrationPage(WebDriver driver){
        super(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    public RegistrationPage inputEmail(String email){
        emailRegistrationEditBox.sendKeys(email);
        return this;
    }
    public RegistrationPage inputPassword(String password){
        passwordRegistrationEditBox.sendKeys(password);
        return this;
    }
    public RegistrationPage inputConfirmPassword(String confirmPassword) {
        confirmPasswordRegistrationEditBox.sendKeys(confirmPassword);
        return this;
    }
    public HomePage clickRegistrationButton(){
        wait.until(ExpectedConditions.visibilityOf(registrationButton));
        registrationButton.click();
        return new HomePage(driver);
    }
}
