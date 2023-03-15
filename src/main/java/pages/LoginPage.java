package pages;

import libs.TestData;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends ParentPage {

    @FindBy (xpath = ".//input[@type='text' and @class='post']")
    private WebElement inputUserNameOrEmail;

    @FindBy (xpath = ".//input[@type='password' and @class='post']")
    private WebElement inputPassword;

    @FindBy (xpath = ".//input[@type='submit' and @name='login']")
    private WebElement buttonLogin;

    @FindBy (xpath = ".//a[@href=\"/login.php?logout=true&sid=f18478b302368d0cf6da7565fbd0b8f9\" and @rel='nofollow']")  // Вихід [ <userName> ]
    private WebElement buttonExit;



    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    String getRelativeURL() {
        return "/login.php?redirect=index.php&";
    }



    public LoginPage openLoginPage() {
        try {
            webDriver.get(base_url + getRelativeURL());
            loggerExam.info("Toloka LoginPage is opened");
        } catch (Exception e) {
            loggerExam.error("Can't open Toloka Login Page" + e); //Write message into log-file + data from Exception
            Assert.fail("Can't open Toloka Login Page" + e); //Write message into console + data from Exception
        }
        return this;
    }

    public HomePage fillingLoginFormWithValidCred() {
        enterUserNameIntoInputLogin(TestData.VALID_LOGIN);
        enterPasswordIntoPasswordField(TestData.VALID_PASSWORD);
        clickOnLoginButton();
        return new HomePage(webDriver);
    }

    public void enterUserNameIntoInputLogin(String userName) {
        enterTextIntoElement(inputUserNameOrEmail, userName);
    }

    public void enterPasswordIntoPasswordField(String userName) {
        enterTextIntoElement(inputPassword, userName);
    }

    public void clickOnLoginButton() {
        clickOnElement(buttonLogin);
    }




}
