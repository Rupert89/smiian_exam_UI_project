package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.elements.HeaderElement;

public class ProfilePage extends ParentPage{

    @FindBy (xpath = ".//input[@type='submit' and @class='button']")
    private WebElement buttonEditYourProfile;

    @FindBy (xpath = ".//option[@value='13']")
    private WebElement dropDownOptionSearchAndOrder;

    @FindBy (xpath = ".getHeaderElement().clickOnProfileButton()")
    private WebElement buttonUsersEmail;

    private String textAriaOccupation = ".//tbody//tr[6]//td[2]//span[@class='gen' and contains(text(), '%s')]";



    private HeaderElement headerElement = new HeaderElement(webDriver);



    public ProfilePage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    String getRelativeURL() {
        return "/u882707";
    }



    public ProfilePage openProfilePage() {
        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.openLoginPage();
        if(!headerElement.isButtonExitDisplayed()) {
            loginPage.fillingLoginFormWithValidCred();
        }
        checkProfilePage();
        return this;
    }
    public ProfilePage checkProfilePage() {
        checkURL();
        Assert.assertTrue("SearchAndOrderPage is not loaded", isButtonEditProfileDisplayed());
        return this;
    }
    public boolean isButtonEditProfileDisplayed() {
        return isObjectDisplayed(buttonEditYourProfile);
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


    public SearchAndOrderPage clickOnSearchAndOrderDropDownOption() {
        clickOnElement(dropDownOptionSearchAndOrder);
        return new SearchAndOrderPage(webDriver);
    }

    public ProfilePage checkIsUsersEmailButtonDisplayed() {
        Assert.assertTrue("Element is not displayed", isElementDisplayed(buttonUsersEmail));
        return this;
    }



}
