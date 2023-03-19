package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateNewTopicPage extends ParentPage {

    @FindBy (xpath = ".//input[@type='text' and @name='subject']")
    public WebElement inputTopic;

    @FindBy (xpath = ".//textarea[@wrap='virtual' and @name='message']")
    public WebElement inputMessage;

    @FindBy (xpath = ".//input[@type='submit' and @name='preview']")
    public WebElement buttonPreview;

    @FindBy (xpath = ".//th[@class='thHead' and contains(text(), 'Перегляд')]")
    public WebElement headPreview;

    @FindBy (xpath = ".//span[@class='postdetails']")
    public WebElement textTopicPreview;

    @FindBy (xpath = ".//span[@class='postbody']")
    public WebElement textMessagePreview;

    @FindBy (xpath = ".//input[@type='submit' and @class='mainoption' and @name='add_attachment']")
    public WebElement buttonPost;








    public CreateNewTopicPage(WebDriver webDriver) {
        super(webDriver);
    }
    @Override
    String getRelativeURL() {
        return "posting.php?mode=newtopic&f=13";
    }



    public CreateNewTopicPage enterTopicText (String text) {
        enterTextIntoElement(inputTopic, text);
        return this;
    }

    public CreateNewTopicPage enterMessageText (String text) {
        enterTextIntoElement(inputMessage, text);
        return this;
    }

    public CreateNewTopicPage clickOnPreviewButton() {
        clickOnElement(buttonPreview);
        return this;
    }

    public CreateNewTopicPage checkIsPreviewHeaderDisplayed() {
        isObjectDisplayed(headPreview);
        return this;
    }

    public CreateNewTopicPage checkIsPreviewTopicDisplayed() {
        isObjectDisplayed(textTopicPreview);
        return this;
    }

    public CreateNewTopicPage checkIsPreviewTopicContainText(String compareText) {
        Assert.assertEquals("Element doesn't contain the text", compareText, textTopicPreview.getText());
        return this;
    }

    public CreateNewTopicPage checkIsPreviewMessageDisplayed() {
        isObjectDisplayed(textMessagePreview);
        return this;
    }

    public CreateNewTopicPage checkIsPreMessageContainText(String compareText) {
        Assert.assertEquals("Element doesn't contain the text", compareText, textMessagePreview.getText());
        return this;
    }

    public PostPage clickOnPostButton() {
        clickOnElement(buttonPost);
        return new PostPage(webDriver);
    }




}
