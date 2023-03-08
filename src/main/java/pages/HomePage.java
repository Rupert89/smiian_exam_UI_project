package pages;

import libs.TestData;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.elements.HeaderElement;


public class HomePage extends ParentPage {






    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    String getRelativeURL() {
        return "/";
    }



    private HeaderElement headerElement = new HeaderElement(webDriver);   // підв'язка ХедерЕлемента

    public HeaderElement getHeaderElement() {
        return headerElement;
    }










}
