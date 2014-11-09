package Priject.hotlineTwsting.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by boris on 04.11.14.
 */
public class Page {
    private static By PAGE;
    public static WebDriver driver;

    public static final By PAGE_CITY_CLOSE = By.cssSelector("a.blue-button.success");
    public static final By PAGE_CLOSE = By.className("close");
    //public static final By USER_POPUP = By.xpath(".//div[contains(@class,'region-doubtfulness-popup')]/span[@class='close']");

    public static final By PAGE_SEARCHBOX_ID = By.id("searchbox");
    public static final By PAGE_DO_SEARCH_ID = By.id("doSearch");
    public static final By PAGE_BANER = By.className("lightbox-form");

    public static String CLOSE_BANNER = "close";
    public static String SELECT_PLACE = "blue-button";

    public Page(WebDriver driver){
        this.driver = driver;
        cleanPage();
    }

    public Page(By page, WebDriver driver){
        this.driver = driver;
        PAGE = page;
        cleanPage();
    }

    public static boolean cleanPage(){

        try {
            WebElement element = driver.findElement(PAGE_BANER);
            if (element.isDisplayed()) {
                element.findElement(PAGE_CLOSE).click();
            }
            element = driver.findElement(PAGE_CITY_CLOSE);
            if (element.isDisplayed()) {
                element.click();
            }
        }
        catch (Exception e){
            return false;

        }
        return true;
    }

    public static boolean openPage(){
        try{
            driver.findElement(PAGE).click();
        } catch (Exception e){
            return false;
        }
        return true;
    }

    public static boolean isOpen(){
        try{
            driver.findElement(PAGE);
        } catch (Exception e){
            return false;
        }
        return true;
    }
    public static boolean findProduct(String product){
        try{
            driver.findElement(PAGE_SEARCHBOX_ID).sendKeys(product);
            driver.findElement(PAGE_DO_SEARCH_ID).click();
            Thread.sleep(1000);
        }catch (Exception e){
            return false;
        }
        return true;
    }
}