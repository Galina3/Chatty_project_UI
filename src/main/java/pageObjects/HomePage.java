package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends BasePage {

    @FindBy(xpath = "//span[@data-test=\"post-header__plus\"]")
    private WebElement createPost;

    @FindBy(xpath = "//input[@name=\"title\"]")
    private WebElement titleEditBox;

    @FindBy(xpath = "//input[@name=\"description\"]")
    private WebElement descriptionEditBox;

    @FindBy(xpath = "//textarea[@name=\"content\"]")
    private WebElement contentEditBox;

    @FindBy(xpath = "//button[@type=\"submit\"]")
    public WebElement submitButton;

    @FindBy(xpath = "/html/body/div[1]/div[2]/div[2]/div[1]/div/div[1]/div[1]/div[1]/span")
    public WebElement displayedNameInNewPost;

    @FindBy(xpath = "//*[@id=\"root\"]/div[2]/div[3]/div/div/div/div[2]/a[2]/span")
    public WebElement myDraftButton;

    @FindBy(xpath = "//label[@for=\"draftCheckbox\"]")
    public WebElement saveAsADraftButton;

    @FindBy(xpath = "//*[@id=\"root\"]/div[2]/div[2]/div/form/div[1]/p")
    public WebElement errorMessageWhenFieldIsEmpty;

    @FindBy(xpath = "//a[contains(text(),'Home')]")
    private WebElement homeButton;

    @FindBy(xpath = "//a[contains(text(),'Contact')]")
    private WebElement contactButton;

    @FindBy(xpath = "//div[@class='header']//p[1]")
    private WebElement headerUserMenuDropDown;

    @FindBy(xpath = "//a[contains(text(),'Logout')]")
    private WebElement logoutButton;

    private final WebDriverWait wait;

    public HomePage(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public boolean isCreatePostDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(createPost));
        return createPost.isDisplayed();
    }

    public boolean isDisplayedErrorMessageWhenFieldIsEmpty() {
        wait.until(ExpectedConditions.visibilityOf(errorMessageWhenFieldIsEmpty));
        return errorMessageWhenFieldIsEmpty.isDisplayed();
    }

    public HomePage openHomePage() {
        wait.until(ExpectedConditions.visibilityOf(homeButton));
        homeButton.click();
        return new HomePage(driver);
    }

    public HomePage createPost() {
        wait.until(ExpectedConditions.visibilityOf(createPost));
        createPost.click();
        return this;
    }

    public HomePage moveMouseToDropDownMenu() {
        Actions actions = new Actions(driver);
        wait.until(ExpectedConditions.visibilityOf(headerUserMenuDropDown));
        actions.moveToElement(headerUserMenuDropDown).perform();
        return this;
    }

    public LoginPage clickLogoutButton() {
        logoutButton.click();
        return new LoginPage(driver);
    }

    public HomePage inputTitleEditBox(String title) {
        wait.until(ExpectedConditions.visibilityOf(titleEditBox));
        titleEditBox.sendKeys(title);
        return this;
    }

    public HomePage inputDescriptionEditBox(String description) {
        wait.until(ExpectedConditions.visibilityOf(descriptionEditBox));
        descriptionEditBox.sendKeys(description);
        return this;
    }

    public HomePage inputContentEditBox(String content) {
        wait.until(ExpectedConditions.visibilityOf(contactButton));
        contentEditBox.sendKeys(content);
        return this;
    }

    public HomePage clickCreatePost() {
        wait.until(ExpectedConditions.urlContains("home"));
        createPost.click();
        return new HomePage(driver);
    }

    public HomePage clickSubmitButton() {
        submitButton.click();
        return new HomePage(driver);
    }

    public boolean isDisplayedNewCreatePostName() {
        wait.until(ExpectedConditions.visibilityOf(displayedNameInNewPost));
        return displayedNameInNewPost.isDisplayed();
    }

    public HomePage clickSaveAsADraft() {
        wait.until(ExpectedConditions.visibilityOf(saveAsADraftButton));
        wait.until(ExpectedConditions.urlContains("home"));
        saveAsADraftButton.click();
        return new HomePage(driver);
    }

    public DraftPage clickMyDraftButton() {
        wait.until(ExpectedConditions.urlContains("home"));
        wait.until(ExpectedConditions.visibilityOf(myDraftButton));
        myDraftButton.click();
        return new DraftPage(driver);
    }

    public ContactPage openContactPage() {
        wait.until(ExpectedConditions.urlContains("home"));
        wait.until(ExpectedConditions.elementToBeClickable(contactButton));
        contactButton.click();
        wait.until(ExpectedConditions.urlContains("contact"));
        return new ContactPage(driver);
    }
}
