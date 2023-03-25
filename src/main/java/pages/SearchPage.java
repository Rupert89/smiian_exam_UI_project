package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.elements.HeaderElement;

public class SearchPage extends ParentPage {

    @FindBy (xpath = ".//input[@type='submit' and @class='liteoption']")
    private WebElement buttonSearch;

    @FindBy (xpath = ".//a[contains(text(), 'наступна')]")
    private WebElement buttonNext;

    @FindBy (xpath = ".//a[contains(text(), 'попередня')]")
    private WebElement buttonPrevious;

    @FindBy (xpath = ".//span[@class='navigation']//b")
    private WebElement indicatorCurrentPage;

    private String indicatorNotCurrentPage = ".//span[@class='navigation']//a[contains(text(), '%s')]";



    private HeaderElement headerElement = new HeaderElement(webDriver);



    public SearchPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    String getRelativeURL() {
        return "/tracker.php?nm";
    }




    public SearchPage openSearchPage() {
        try {
            webDriver.get(base_url + getRelativeURL());
            loggerExam.info("SearchPage is opened");
        } catch (Exception e) {
            loggerExam.error("Can't open Search Page" + e);
            Assert.fail("Can't open Search Page" + e);
        }
        return this;
    }


    public SearchPage checkIsRedirectToSearchPage() {
        checkURL();
        Assert.assertTrue("HomePage is not loaded", isButtonSearchDisplayed());
        return this;
    }
    public boolean isButtonSearchDisplayed() {
        return isObjectDisplayed(buttonSearch);
    }



    public SearchPage clickOnNextButton() {
        clickOnElement(buttonNext);
        return this;
    }

    public SearchPage checkIsPreviousButtonAppeared() {
        isElementDisplayed(buttonPrevious);
        return this;
    }

    public SearchPage checkCurrentIndicatorNumber(String indicatorNumber){
        Assert.assertEquals("Wrong indicator number", indicatorNumber, indicatorCurrentPage.getText());
        return this;
    }

    public SearchPage checkIsElementContainText(String indicatorNumber) {
        Assert.assertTrue("Element is not displayed", isElementDisplayed(getIndicatorPageByNumber(indicatorNumber)));
        return this;
    }

    public WebElement getIndicatorPageByNumber(String indicatorText){
        return webDriver.findElement(By.xpath(String.format(indicatorNotCurrentPage, indicatorText)));
    }

}
