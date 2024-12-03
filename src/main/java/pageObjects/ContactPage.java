package pageObjects;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ContactPage extends BasePage {

    @FindBy(xpath = "//a[contains(text(),'Contact')]")
    public WebElement contactButton;

    @FindBy(xpath = "//input[@id='name']")
    public WebElement usernameField;

    @FindBy(xpath = "//input[@id='email']")
    public WebElement emailField;

    @FindBy(xpath = "//textarea[@id='content']")
    public WebElement messageField;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement sendMessageButton;

    @FindBy(xpath = "//p[contains(text(), 'Invalid email format')]")
    public WebElement errorMessage;

    @FindBy(xpath = "//div[contains(text(), 'Feedback submitted successfully')]")
    public WebElement successMessage;

    private WebDriverWait wait;

    public ContactPage(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public ContactPage inputUsername(String username) {
        wait.until(ExpectedConditions.visibilityOf(usernameField));
        usernameField.sendKeys(username);
        return this;
    }

    public ContactPage inputEmail(String email) {
        wait.until(ExpectedConditions.visibilityOf(emailField));
        emailField.sendKeys(email);
        return this;
    }

    public ContactPage inputMessage(String message) {
        wait.until(ExpectedConditions.visibilityOf(messageField));
        messageField.sendKeys(message);
        return this;
    }

    public void clickSendMessageButton() {
        wait.until(ExpectedConditions.visibilityOf(sendMessageButton));
        sendMessageButton.click();
    }

    public boolean isErrorMessageInvalidEmailDisplayed() {
        return errorMessage.isDisplayed();
    }

    public boolean isMessageSent() {
        try {
            wait.until(ExpectedConditions.visibilityOf(successMessage));
            return successMessage.isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }
}
