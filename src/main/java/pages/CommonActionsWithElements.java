package pages;

import io.opentelemetry.sdk.autoconfigure.spi.ConfigProperties;

import org.aeonbits.owner.ConfigFactory;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;

public class CommonActionsWithElements {
    protected WebDriver webDriver;
    Logger logger = Logger.getLogger(getClass());
    WebDriverWait webDriverWait10, webDriverWait15;
//    public static ConfigProperties configProperties = ConfigFactory.create(ConfigProperties.class);

    public CommonActionsWithElements(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);

//        webDriverWait10 = new WebDriverWait(webDriver, Duration.ofSeconds(configProperties.TIME_FOR_EXPLICIT_WAIT_LOW()));     // додаємо в конструкор драйвери для використання методів очікування
//        webDriverWait15 = new WebDriverWait(webDriver, Duration.ofSeconds(configProperties.TIME_FOR_EXPLICIT_WAIT_HIGH()));    // + підтягуємо дані з config.Properties
    }



    protected void enterTextIntoElement(WebElement webElement, String text) {
        try {
            webDriverWait15.until(ExpectedConditions.visibilityOf(webElement)); //виокористання очікування 15
            webElement.clear();
            webElement.sendKeys(text);
            logger.info(text + " was inputted into element " + getElementName(webElement));
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

    protected void clickOnElement(WebElement webElement){
        try {
            webDriverWait10.until(ExpectedConditions.elementToBeClickable(webElement));   //виокористання очікування 10
            String name = getElementName(webElement);
            webElement.click();
            logger.info(name + " Element was clicked");
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

    private String getElementName (WebElement webElement) {      //дістає ім'я елемента. Потім це додаєм до повідомлень, на випадок помилок.
        try {
            return webElement.getAccessibleName();
        } catch (Exception e) {
            return "";
        }
    }








    protected void printErrorAndStopTest (Exception e) {
        logger.error("Can't work with element" + e);
        Assert.fail("Can't work with element" + e);
    }

}
