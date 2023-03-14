package searchPageTest;

import BaseTest.BaseTest;
import org.junit.Test;

public class SearchPageTest extends BaseTest {

    @Test
    public void nextButtonWorkCheck() {
        searchPage
                .openRegistrationPage()
                .clickOnNextButton()
                .checkIsPreviousButtonAppeared()
                ;

    }
}
