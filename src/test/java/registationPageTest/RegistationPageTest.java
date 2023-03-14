package registationPageTest;

import BaseTest.BaseTest;
import libs.TestData;
import org.junit.Test;

public class RegistationPageTest extends BaseTest {

    @Test
    public void notValidLoginNameCheck() {
        registrationPage
                .openRegistrationPage()
                .enterExistLogin(TestData.EXIST_LOGIN)
                .clickOnCheckLoginButton()
                .checkIsNotAvailableMessageAppeared()
                ;
    }
}
