package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.elements.HeaderElement;

public class RegistrationPage extends ParentPage {

    @FindBy (xpath = ".//input[@type='submit' and @name='submit']")
    private WebElement buttonRegistration;

    @FindBy (xpath = ".//input[@type='text' and @name='username']")
    private WebElement inputFieldOccupation;

    @FindBy (xpath = ".//input[@type='text' and @name='username']")
    private WebElement inputLogin;

    @FindBy (xpath = ".//input[@type='button' and @name='check']")
    private WebElement buttonCheckLogin;

    @FindBy (xpath = ".//div[@id='not_available' and contains(text(), 'Псевдонім вже зайнято')]")
    private WebElement messageNotAvailableLogin;


    private HeaderElement headerElement = new HeaderElement(webDriver);


    public RegistrationPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    String getRelativeURL() {
        return "/profile.php?mode=register";
    }


    public HeaderElement getHeaderElement() { return headerElement; }


    public RegistrationPage openRegistrationPage() {
        try {
            webDriver.get(base_url + getRelativeURL());
            loggerExam.info("Toloka Registration Page is opened");
        } catch (Exception e) {
            loggerExam.error("Can't open Toloka Registration Page" + e); //Write message into log-file + data from Exception
            Assert.fail("Can't open Toloka Registration Page" + e); //Write message into console + data from Exception
        }
        return this;
    }


    public RegistrationPage enterExistLogin(String text) {
        enterTextIntoElement(inputLogin, text);
        return this;
    }

    public RegistrationPage clickOnCheckLoginButton() {
        clickOnElement(buttonCheckLogin);
        return this;
    }


    public RegistrationPage checkIsNotAvailableMessageAppeared() {
        isElementDisplayed(messageNotAvailableLogin);
        return this;
    }

}
