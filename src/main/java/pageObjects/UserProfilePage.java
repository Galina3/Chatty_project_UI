package pageObjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class UserProfilePage extends BasePage {

    private WebDriverWait wait;
    @FindBy(xpath = "//span[@data-test='post-header__plus']")
    private WebElement editPlusButton;

    @FindBy(xpath = "//input[@placeholder='Name']")
    private WebElement inputFieldName;

    @FindBy(xpath = "//input[@placeholder='Surname']")
    private WebElement enterFieldSurname;

    //   @FindBy(xpath = "//option[@value='FEMALE']")
    //   private WebElement inputFieldGender;

    @FindBy(xpath = "//input[@value='2001-01-20']")
    private WebElement inputFieldBirthdate;

    @FindBy(xpath = "//input[@name='phone']")
    private WebElement inputFieldPhone;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement saveButton;

    /////


    public UserProfilePage(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    public UserProfilePage enterEditButton() {
        editPlusButton.click();
        return this;
    }

    public UserProfilePage enterInputFieldName(String username) {
        inputFieldName.sendKeys(username);
        return this;
    }

    public UserProfilePage enterInputFieldSurname(String surname) {
        enterFieldSurname.sendKeys(surname);
        return this;
    }

    //  public UserProfilePage enterInputFieldGender(String gender){
    //     inputFieldGender.click();
    //     return this;
    // }

    public UserProfilePage enterInputFieldBirthdate() {
        inputFieldBirthdate.click();
        return this;
    }

    public UserProfilePage enterFieldPhone(String phone) {
        inputFieldPhone.sendKeys(phone);
        return this;
    }

    public UserProfilePage clickSaveButton() {
        saveButton.click();
        return this;
    }

 //   public boolean isElementClickable(WebDriver driver, WebElement element) {
  //      try {
     //       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
       //     wait.until(ExpectedConditions.elementToBeClickable(inputFieldName));
       //     return true;
       // } catch (TimeoutException e) {
        //    return false;
      //  }
   // }
}

