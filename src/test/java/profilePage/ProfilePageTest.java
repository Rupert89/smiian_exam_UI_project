package profilePage;

import BaseTest.BaseTest;
import libs.TestData;
import org.junit.Test;

public class ProfilePageTest extends BaseTest {
    @Test
    public void editingPersonalInformationCheck() {
        profilePage
                .openProfilePage()
                .clickOnEditYourProfileButton()
                .enterDataIntoOccupationField(TestData.OCCUPATION_TEXT)
                .clickOnSubmitButton()
                .getHeaderElement().clickOnProfileButton()
             .checkIsElementContainText(TestData.OCCUPATION_TEXT)
                ;
    }

    @Test
    public void emailContactIsVisible() {
        profilePage
                .openProfilePage()
//                .clickOnEditYourProfileButton()
//                .getHeaderElement().checkIsElementContainText(TestData.NAME_OF_USER)
//                .getHeaderElement().clickOnProfileButton()
                .clickOnEditYourProfileButton()
                .clickOnViewEmailYesRadioButton()
                .clickOnSubmitButton()
        ;
    }

}
