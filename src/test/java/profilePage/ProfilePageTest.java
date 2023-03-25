package profilePage;

import BaseTest.BaseTest;
import libs.TestData;
import org.junit.Test;

public class ProfilePageTest extends BaseTest {

    @Test
    public void editingPersonalInformationCheck() {
        homePage
                .openHomePage()
                .getHeaderElement().clickOnProfileButton()
             .checkIsRedirectToProfilePage()
                .clickOnEditYourProfileButton()
                .enterDataIntoOccupationField(TestData.OCCUPATION_TEXT)
                .clickOnSubmitButton()
                .getHeaderElement().clickOnProfileButton()
             .checkIsElementContainText(TestData.OCCUPATION_TEXT)
                ;
    }

    @Test
    public void emailContactIsVisible() {
        homePage
                .openHomePage()
                .getHeaderElement().clickOnProfileButton()
             .checkIsRedirectToProfilePage()
                .clickOnEditYourProfileButton()
                .clickOnViewEmailYesRadioButton()
                .clickOnSubmitButton()
                .getHeaderElement().clickOnProfileButton()
             .checkIsUsersEmailButtonDisplayed()
        ;
    }

}
