package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class HomePage extends BasePage {
    @FindBy(xpath = "//p[@class='post-header__plus-box']")
    private WebElement createPost;
    @FindBy(xpath = "//a[contains(text(),'Home')]")
    private WebElement homeButton;
    @FindBy(xpath = "//a[contains(text(),'Contact')]")
    private WebElement contactButton;
    @FindBy(xpath = "//div[@class='header']//p[1]")
    private WebElement headerUserMenuDropDown;
    @FindBy(xpath = "//a[contains(text(),'Logout')]")
    private WebElement logoutButton;
    private WebDriverWait wait;
    public HomePage(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    public ContactPage openContactPage() {
        wait.until(ExpectedConditions.urlContains("home")); // Проверка, что мы на нужной странице
        wait.until(ExpectedConditions.elementToBeClickable(contactButton));
        contactButton.click();
        wait.until(ExpectedConditions.urlContains("contact"));
        return new ContactPage(driver);
    }
    public HomePage openHomePage() {
        wait.until(ExpectedConditions.urlContains("contact"));
        homeButton.click();
        return new HomePage(driver);
    }
    public HomePage moveMouseToDropDownMenu() {
        Actions actions = new Actions(driver);
        actions.moveToElement(headerUserMenuDropDown).perform();
        return this;
    }
    public void clickLogoutButton() {
        logoutButton.click();
        new LoginPage(driver);
    }
}
