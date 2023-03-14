package pages.elements;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.CommonActionsWithElements;
import pages.HomePage;
import pages.ProfilePage;
import pages.RegistrationPage;


public class HeaderElement extends CommonActionsWithElements {

    @FindBy (xpath = ".//a[contains(text(), 'Профіль')]")
    private WebElement buttonProfile;

    @FindBy (xpath = ".//a[@rel='nofollow' and contains(text(), 'Вихід')]")
    private WebElement buttonExit;



    private String buttonEnterWithLoginName = ".//li//a[@rel='nofollow' and contains(text(), '%s')]";


    public HeaderElement (WebDriver webDriver) {  //constructor
        super(webDriver);
    }   // конструктор




    public HomePage checkIsElementContainText(String loginNameText) {
        Assert.assertTrue("Element is not displayed", isElementDisplayed(getElementText(loginNameText)));
        return new HomePage(webDriver);
    }

    public WebElement getElementText(String elementText){
        return webDriver.findElement(By.xpath(String.format(buttonEnterWithLoginName, elementText)));
    }



    public ProfilePage clickOnProfileButton() {
        clickOnElement(buttonProfile);
        return new ProfilePage(webDriver);
    }


    public boolean isButtonExitDisplayed() {
        return isObjectDisplayed(buttonExit);
    }







}
