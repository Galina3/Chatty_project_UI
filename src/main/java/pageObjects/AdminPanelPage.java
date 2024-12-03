package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AdminPanelPage extends BasePage {

    @FindBy(xpath = "//input[@placeholder='Search by email...']")
    private WebElement searchByEmailEditBox;

    @FindBy(xpath = "//button[contains(text(), 'Search')]")
    private WebElement searchButton;

    @FindBy(xpath = "//span[@data-test='deleteUserButton']")
    private WebElement deleteUserButton;

    @FindBy(xpath = "//span[@data-test='editUserButton']")
    private WebElement editUserButton;

    private final WebDriverWait wait;

    public AdminPanelPage(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public AdminPanelPage inputSearchByEmailEditBox(String email) {
        wait.until(ExpectedConditions.visibilityOf(searchByEmailEditBox));
        searchByEmailEditBox.sendKeys(email);
        return this;
    }

    public AdminPanelPage clickSearchButton() {
        wait.until(ExpectedConditions.visibilityOf(searchButton));
        searchButton.click();
        return this;
    }

    public AdminPanelPage clickDeleteUserButton() {
        wait.until(ExpectedConditions.visibilityOf(deleteUserButton));
        deleteUserButton.click();
        return this;
    }

    public AdminPanelPage clickEditingUserButton() {
        wait.until(ExpectedConditions.visibilityOf(editUserButton));
        editUserButton.click();
        return this;
    }
}
