package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.elements.HeaderElement;


public class HomePage extends ParentPage {

    @FindBy (xpath = ".//a[@rel='nofollow' and  contains(text(), 'Вихід')]")
    private WebElement buttonExit;



    private HeaderElement headerElement = new HeaderElement(webDriver);

    private SearchAndOrderPage searchAndOrderPage = new SearchAndOrderPage(webDriver);

    private SearchPage searchPage = new SearchPage(webDriver);



    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    String getRelativeURL() {
        return "/";
    }



    public HeaderElement getHeaderElement() {
        return headerElement;
    }

    public SearchAndOrderPage getSearchAndOrderPage() { return searchAndOrderPage; }

    public SearchPage getSearchPage() { return searchPage; }



    public HomePage openHomePage() {
        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.openLoginPage();
        if(!headerElement.isButtonExitDisplayed()) {
            loginPage.fillingLoginFormWithValidCred();
        }
        checkIsRedirectToHomePage();
        return this;
    }
    public HomePage checkIsRedirectToHomePage() {
        checkURL();
        Assert.assertTrue("HomePage is not loaded", isButtonExitDisplayed());
        return this;
    }
    public boolean isButtonExitDisplayed() {
        return isObjectDisplayed(buttonExit);
    }


}
