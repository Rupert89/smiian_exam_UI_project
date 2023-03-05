package pages.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.CommonActionsWithElements;


public class HeaderElement extends CommonActionsWithElements {

    @FindBy (xpath = ".//a[@href='/u882707']")
    private WebElement buttonProfile;

    public HeaderElement (WebDriver webDriver) {  //constructor
        super(webDriver);
    }




}
