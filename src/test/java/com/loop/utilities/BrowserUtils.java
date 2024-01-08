package com.loop.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

import static junit.framework.TestCase.assertTrue;


public class BrowserUtils {
    /**
     * validate if driver switched to expected url and title
     * @param driver
     * @param expectedUrl
     * @param expectedTitle
     * @author Emil
     * implements assertion
     */
    public static void switchWindowAndValidate(WebDriver driver,String expectedUrl,String expectedTitle){
        expectedTitle=expectedTitle.toLowerCase();
        expectedUrl=expectedUrl.toLowerCase();

        Set<String> windowHandles = driver.getWindowHandles();
        for (String each:windowHandles){
            driver.switchTo().window(each);
            if (driver.getCurrentUrl().toLowerCase().contains(expectedUrl)) {
                break;
            }
        }
        assertTrue(driver.getTitle().toLowerCase().contains(expectedTitle));
    }

    /**
     * @param driver
     * @param expectedTitle
     * retuns void, assertion is implemented
     * @author Emil
     */
    public static void validateTitle(WebDriver driver,String expectedTitle){
        //String actualTitle  = driver.getTitle();
        assertTrue(driver.getTitle().contains(expectedTitle));
    }
    /**
     * Click any link from loop practice
     * @param nameOfPage
     * @author Emil
     */
    public static void loopLinkClick(String nameOfPage){
        WebElement element = Driver.getdriver().findElement(By.xpath("//a[.='"+nameOfPage+"']"));
        WebDriverWait wait = new WebDriverWait(Driver.getdriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }
    /**
     * Moves the mouse to given element
     * @param element on which to hover
     * @author Emil
     */
    public static void hover(WebElement element){
        Actions actions = new Actions(Driver.getdriver());
        actions.moveToElement(element).perform();
    }
    /**
     * Scrolls down to an element using JavaScript
     * @param element
     * @author Emil
     */
    public static void scrollToElement(WebElement element){
        ((JavascriptExecutor) Driver.getdriver()).executeScript("arguments[0].scrollIntoView(true);", element);
    }
    /**
     * Clicks on an element using JavaScript
     * @param element
     * @author Emil
     */
    public static void clickWithJS(WebElement element){
        ((JavascriptExecutor) Driver.getdriver()).executeScript("arguments[0].scrollIntoView(true);", element);
        ((JavascriptExecutor) Driver.getdriver()).executeScript("arguments[0].click;", element);
    }
    /**
     * Performs double click action on an element
     * @param element
     * @author Emil
     */
    public static void doubleClick(WebElement element){
        new Actions(Driver.getdriver()).doubleClick(element).build().perform();
    }
    /**
     * Waits for the provided element to be visible on the page
     * @param element
     * @param timeToWaitInSec
     * @return
     * @author Emil
     */
    public static WebElement waitForVisibility(WebElement element, int timeToWaitInSec){
        WebDriverWait wait = new WebDriverWait(Driver.getdriver(), Duration.ofSeconds(timeToWaitInSec));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }
    /**
     * Waits for provided element to be clickable
     * @param element
     * @param timeout
     * @return
     * @author Emil
     */
    public static WebElement waitForClickable (WebElement element, int timeout){
        WebDriverWait wait = new WebDriverWait(Driver.getdriver(), Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }






}
