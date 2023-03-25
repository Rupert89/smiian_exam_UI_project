package pages.elements;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.CommonActionsWithElements;
import pages.ProfilePage;



public class HeaderElement extends CommonActionsWithElements {

    @FindBy (xpath = ".//a[contains(text(), 'Профіль')]")
    private WebElement buttonProfile;

    @FindBy (xpath = ".//a[@rel='nofollow' and contains(text(), 'Вихід')]")
    private WebElement buttonExit;

    private String buttonEnterWithLoginName = ".//li//a[@rel='nofollow' and contains(text(), '%s')]";



    public HeaderElement (WebDriver webDriver) {  //constructor
        super(webDriver);
    }




    public ProfilePage clickOnProfileButton() {
        clickOnElement(buttonProfile);
        return new ProfilePage(webDriver);
    }


    public boolean isButtonExitDisplayed() {
        return isObjectDisplayed(buttonExit);
    }







}
