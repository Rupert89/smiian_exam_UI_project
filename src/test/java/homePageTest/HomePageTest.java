package homePageTest;

import BaseTest.BaseTest;
import libs.TestData;
import org.junit.Test;

public class HomePageTest extends BaseTest {

    @Test
    public void validLogin() {
        loginPage
                .openLoginPage()
                .fillingLoginFormWithValidCred()
             .getHeaderElement().checkIsElementContainText(TestData.NAME_OF_USER)
//             .getHeaderElement().checkIsElementContainText("Вихід [ testerArt ]")
                .getHeaderElement().clickOnProfileButton()
                .clickOnEditYourProfileButton()
                .enterDataIntoOccupationField(TestData.OCCUPATION_TEXT)
//                .enterDataIntoOccupationField("test engineer")
                .clickOnSubmitButton()
                .getHeaderElement().clickOnProfileButton()
                .checkIsElementContainText(TestData.OCCUPATION_TEXT)
//                .checkIsElementContainText("test engineer")
        ;
    }



}
