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
    private WebDriverWait wait;

    public AdminPanelPage(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public AdminPanelPage inputSearchByEmailEditBox(String email) {
        wait.until(ExpectedConditions.visibilityOf(searchByEmailEditBox));
        searchByEmailEditBox.sendKeys(email);
        return this;
    }

    public void clickSearchButton() {
        wait.until(ExpectedConditions.visibilityOf(searchButton));
        searchButton.click();
    }

    public void clickDeleteUserButton() {
        wait.until(ExpectedConditions.visibilityOf(deleteUserButton));
        deleteUserButton.click();
    }
}
