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
                .getHeaderElement().clickOnProfileButton()
                .clickOnEditYourProfileButton()
                .enterDataIntoOccupationField(TestData.OCCUPATION_TEXT)
                .clickOnSubmitButton()
                .getHeaderElement().clickOnProfileButton()
                .checkIsElementContainText(TestData.OCCUPATION_TEXT)
        ;
    }



}
