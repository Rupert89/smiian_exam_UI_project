package searchAndOrderTest;

import BaseTest.BaseTest;
import libs.TestData;
import org.junit.After;
import org.junit.Test;

public class SearchAndOrderTest extends BaseTest {

    @Test
    public void newTopicPreviewAndPostCheck() {
        homePage
                .openHomePage()
                .getSearchAndOrderPage().openSearchAndOrderPage()
             .checkSearchAndOrderPage()
                .clickOnNewTopicButton()
                .enterTopicText(TestData.TOPIC_TEXT)
                .enterMessageText(TestData.MESSAGE_TEXT)
                .clickOnPreviewButton()
             .checkIsPreviewHeaderDisplayed()
             .checkIsPreviewTopicDisplayed()
             .checkIsPreviewTopicContainText(TestData.TOPIC_TEXT)
             .checkIsPreviewMessageDisplayed()
             .checkIsPreMessageContainText(TestData.MESSAGE_TEXT)
                .clickOnPostButton()
             .checkIsTopicTitleDisplayed()
             .checkIsTopicTitleContainText(TestData.TOPIC_TEXT)
             .checkMessageContainText(TestData.MESSAGE_TEXT)
                ;
    }

    @After
    public void deletePost() {
        homePage
                .openHomePage()
                .getHeaderElement().clickOnProfileButton()
                .clickOnSearchAndOrderDropDownOption()
                .clickOnElementByTopicTitle(TestData.TOPIC_TEXT)
                .clickOnDeletePostButton()
                .clickOnConfirmDeleteButton()
                ;
    }
}
