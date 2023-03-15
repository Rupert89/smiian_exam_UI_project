package searchPageTest;

import BaseTest.BaseTest;
import org.junit.Test;

public class SearchPageTest extends BaseTest {

    @Test
    public void nextButtonWorkCheck() {
        searchPage
                .openRegistrationPage()
             .checkCurrentIndicatorNumber("1")
                .clickOnNextButton()
             .checkIsPreviousButtonAppeared()
             .checkCurrentIndicatorNumber("2")
                .checkIndicatorNumberText("1")
                ;

    }
}
