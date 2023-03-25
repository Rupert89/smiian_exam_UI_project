package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PostPage extends ParentPage {

    @FindBy (xpath = ".//a[@class='maintitle']")
    public WebElement titleTopic;

    @FindBy (xpath = ".//td[@nowrap='nowrap']//a[3]")
    public WebElement buttonDeleteMessage;

    @FindBy (xpath = ".//input[@type='submit' and @name='confirm']")
    public WebElement buttonConfirmDelete;

    private String bodyMessageText = ".//span[@class='postbody' and contains(text(), '%s')]";




    public PostPage(WebDriver webDriver) {
        super(webDriver);
    }
    @Override
    String getRelativeURL() {
        return null;
    }




    public PostPage checkIsTopicTitleDisplayed() {
        isObjectDisplayed(titleTopic);
        return this;
    }

    public PostPage checkIsTopicTitleContainText(String compareText) {
        Assert.assertTrue("Topic post doesn't contain the text", titleTopic.getText().contains(compareText));
        return this;
    }

    public PostPage checkMessageContainText(String bodyMessageText){
        Assert.assertTrue("Message is not displayed", isElementDisplayed(getBodyMessage(bodyMessageText)));
        return this;
    }

    public WebElement getBodyMessage(String messageText){
        return webDriver.findElement(By.xpath(String.format(bodyMessageText, messageText)));
    }

    public PostPage clickOnDeletePostButton() {
        clickOnElement(buttonDeleteMessage);
        return this;
    }

    public SearchAndOrderPage clickOnConfirmDeleteButton() {
        clickOnElement(buttonConfirmDelete);
        return new SearchAndOrderPage(webDriver);
    }

}
