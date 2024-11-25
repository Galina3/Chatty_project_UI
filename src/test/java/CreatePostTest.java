import org.junit.jupiter.api.Test;
import pageObjects.HomePage;

import static org.junit.jupiter.api.Assertions.*;

public class CreatePostTest extends UserRegistrationAndRemoval {
    private final String title = "Post New Title";
    private final String description = "Post New Description";
    private final String content = "Post New Content";
    private final String expectedUrl = "http://chatty.telran-edu.de:8089/draft";

    @Test
    public void CreatePostWithValidDataTest() {
        new HomePage(driver)
                .clickCreatePost()
                .inputTitleEditBox(title)
                .inputDescriptionEditBox(description)
                .inputContentEditBox(content)
                .clickSubmitButton();
        assertTrue(new HomePage(driver).isDisplayedNewCreatePostName());
    }

    @Test
    public void CreateMyDraftsWithValidDateTest() {
       new HomePage(driver)
                .clickCreatePost()
                .inputTitleEditBox(title)
                .inputDescriptionEditBox(description)
                .inputContentEditBox(content)
                .clickSaveAsADraft()
                .clickSubmitButton()
                .clickMyDraftButton();
        assertEquals(driver.getCurrentUrl(),expectedUrl);
    }

    @Test
    public void CreatePostWithEmptyTitleEditBoxTest(){
        new HomePage(driver)
                .clickCreatePost()
                .inputDescriptionEditBox(description)
                .inputContentEditBox(content)
                .clickSubmitButton();
        assertTrue(new HomePage(driver).isDisplayedErrorMessageWhenFieldIsEmpty());
    }
}