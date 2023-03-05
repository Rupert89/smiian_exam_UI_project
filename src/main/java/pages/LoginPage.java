package pages;

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
        return "/login.php?redirect=index.php&";               // check with original??????????
    }

    public void openLoginPage() {
        try {
            webDriver.get(base_url + getRelativeURL());
            logger.info("Toloka LoginPage is opened");
        } catch (Exception e) {
            logger.error("Can't open Toloka Login Page" + e); //Write message into log-file + data from Exception
            Assert.fail("Can't open Toloka Login Page" + e); //Write message into console + data from Exception
        }
    }

    public void enterUserNameIntoInputLogin(String userName) {
        enterTextIntoElement(inputUserNameOrEmail, userName);
    }

    public void enterPasswordIntoPasswordField(String password) {
        enterTextIntoElement(inputPassword, password);
    }

    public void clickOnLoginButton() {
        clickOnElement(buttonLogin);
    }




}
