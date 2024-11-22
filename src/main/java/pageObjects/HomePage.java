package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends BasePage{
    @FindBy(xpath = "//p[@class='post-header__plus-box']")
    private WebElement createPost;

    @FindBy(xpath = "//a[contains(text(),'Home')]")
    private WebElement homeButton;

    @FindBy(xpath = "//a[contains(text(),'Contact')]")
    private WebElement contactButton;
    @FindBy(xpath = "//div[@class='header']//p[1]")
    private WebElement headerUserMenuDropDown;
    @FindBy(xpath = "//a[contains(text(),'Logout')]") ////*[@class="__web-inspector-hide-shortcut__"]
    private WebElement logoutButton;

    @FindBy(xpath = "//a[contains(text(),'Admin Panel')]")
    private WebElement adminPanelButton;


    private WebDriverWait wait;

    public HomePage(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public boolean isCreatePostDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(createPost));
        return createPost.isDisplayed();
    }




    public HomePage createPost(){
        wait.until(ExpectedConditions.visibilityOf(createPost));
        createPost.click();
        return this;
    }
    public HomePage openHomePage(){
        homeButton.click();
        return new HomePage(driver);
    }



    public HomePage moveMouseToDropDownMenu(){
        Actions actions = new Actions(driver);
        wait.until(ExpectedConditions.elementToBeClickable(headerUserMenuDropDown));
        actions.moveToElement(headerUserMenuDropDown).perform();
        return this;
    }

    public AdminPanelPage clickAdminPanelButton(){ // менять
        wait.until(ExpectedConditions.elementToBeClickable(adminPanelButton));
        adminPanelButton.click();
        return new AdminPanelPage(driver);
    }
    public LoginPage clickLogoutButton(){
        logoutButton.click();
        return new LoginPage(driver);
    }


}
