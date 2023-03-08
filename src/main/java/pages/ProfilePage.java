package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfilePage extends ParentPage{

    @FindBy (xpath = ".//input[@type='submit' and @class='button']")
    private WebElement buttonEditYourProfile;

    private String textAriaOccupation = ".//span[contains(text(), 'Рід занять')]//..//..//td[2]//b//span, '%s')]";




    public ProfilePage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    String getRelativeURL() {
        return "/u882707";
    }



    public EditProfilePage clickOnEditYourProfileButton() {
        clickOnElement(buttonEditYourProfile);
        return new EditProfilePage(webDriver);
    }

    public ProfilePage checkIsElementContainText(String loginNameText) {
        Assert.assertTrue("Element is not displayed", isElementDisplayed(getElementText(loginNameText)));
        return this;
    }

    public WebElement getElementText(String elementText){
        return webDriver.findElement(By.xpath(String.format(textAriaOccupation, elementText)));
    }



}
