package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.elements.HeaderElement;

public class SearchAndOrderPage extends ParentPage {

    @FindBy (xpath = ".//img[@border='0' and @alt='Нова тема']")
    private WebElement buttonNewTopic;

    private String elementWithTopicText = ".//a[@class='topictitle' and contains(text(), '%s')]";


    private HeaderElement headerElement = new HeaderElement(webDriver);



    public SearchAndOrderPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    String getRelativeURL() {
        return "/f13";
    }


//    public HeaderElement getHeaderElement() { return headerElement; }



    public SearchAndOrderPage openSearchAndOrderPage() {
        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.openLoginPage();
        if(!headerElement.isButtonExitDisplayed()) {
            loginPage.fillingLoginFormWithValidCred();
        }
        checkSearchAndOrderPage();
        return this;
    }
    public SearchAndOrderPage checkSearchAndOrderPage() {
        checkURL();
        Assert.assertTrue("SearchAndOrderPage is not loaded", isButtonNewTopicDisplayed());
        return this;
    }
    public boolean isButtonNewTopicDisplayed() {
        return isObjectDisplayed(buttonNewTopic);
    }


    public CreateNewTopicPage clickOnNewTopicButton() {
        clickOnElement(buttonNewTopic);
        return new CreateNewTopicPage(webDriver);
    }

    public PostPage clickOnElementByTopicTitle(String topicText) {
        clickOnElement(webDriver.findElement(By.xpath(String.format(elementWithTopicText, topicText))));
        return new PostPage(webDriver);
    }



}
