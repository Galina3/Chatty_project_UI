package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends BasePage{
    @FindBy(xpath = "//a[contains(text(),'Home')]")
    private WebElement homeButton;
    @FindBy(xpath = "//div[@class='header']//p[1]")
    private WebElement headerUserMenuDropDown;
    @FindBy(xpath = "//a[contains(text(),'Logout')]") ////*[@class="__web-inspector-hide-shortcut__"]
    private WebElement logoutButton;

    private WebDriverWait wait;

    public HomePage(WebDriver driver){
        super(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public HomePage openHomePage(){
        wait.until(ExpectedConditions.visibilityOf(homeButton));
        homeButton.click();
        return new HomePage(driver);
    }
    public HomePage moveMouseToDropDownMenu(){
        Actions actions = new Actions(driver);
        wait.until(ExpectedConditions.elementToBeClickable(headerUserMenuDropDown));
        actions.moveToElement(headerUserMenuDropDown).perform();
        return this;
    }
    public LoginPage clickLogoutButton(){
        logoutButton.click();
        return new LoginPage(driver);
    }

}
