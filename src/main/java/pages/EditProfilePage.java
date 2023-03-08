package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditProfilePage extends ParentPage {

    @FindBy (xpath = ".//input[@type='text' and @name='occupation']")
    private WebElement inputFieldOccupation;

    @FindBy (xpath = ".//input[@type='submit' and @name='submit']")
    private WebElement buttonSubmit;




    public EditProfilePage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    String getRelativeURL() {
        return "/profile.php?mode=editprofile";
    }


    public EditProfilePage enterDataIntoOccupationField(String text) {
        enterTextIntoElement(inputFieldOccupation, text);
        return this;
    }

    public HomePage clickOnSubmitButton() {
        clickOnElement(buttonSubmit);
        return new HomePage(webDriver);
    }


}
