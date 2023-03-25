package searchPageTest;

import BaseTest.BaseTest;
import org.junit.Test;

public class SearchPageTest extends BaseTest {

    @Test
    public void nextButtonWorkCheck() {
        homePage
                .openHomePage()
                .getSearchPage().openSearchPage()
              .checkIsRedirectToSearchPage()
             .checkCurrentIndicatorNumber("1")
                .clickOnNextButton()
             .checkIsPreviousButtonAppeared()
             .checkCurrentIndicatorNumber("2")
             .checkIsElementContainText("1")
                ;
    }
}
