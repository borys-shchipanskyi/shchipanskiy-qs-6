package Priject.hotlineTesting.pages;

import Priject.hotlineTesting.selenium.WebDriverFactory;
import Priject.hotlineTesting.selenium.WebDriverWrapper;
import Priject.hotlineTesting.utils.Log4Test;
import Priject.hotlineTesting.utils.PropertyLoader;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


import java.util.List;


/**
 * Created by boris on 03.11.14.
 */
public class MainPage extends Page {
    public static final String MAIN_PAGE = PropertyLoader.loadProperty("site.url") + '/';

    public static final By PAGE_SEARCHBOX_ID = By.id("searchbox");
    public static final By PAGE_DO_SEARCH_ID = By.id("doSearch");

    public static final By PAGE_CITY_CLOSE = By.cssSelector("a.blue-button.success");
    public static final By PAGE_CLOSE = By.className("close");
    public static final By PAGE_BANER = By.className("lightbox-form");

    public static final By BT = By.xpath("//b[contains(text(),'Бытовая техника')]");
    public static final By BT_HOLOD = By.xpath("//a[@href='/bt/holodilniki/']");
    public static final By FILTER_FIRMA = By.xpath(".//*[@id='filters']/div[5]/p[5]/a");
    public static final By REF_LG = By.xpath(".//*[@id='catalogue']/div[3]/div[2]/div/span");
    public static final By PRICE_UP = By.xpath(".//a[contains(text(),'возрастанию цены')]");


    public MainPage(WebDriverWrapper driver){
        super(driver, MAIN_PAGE);
    }

    // ---new isOpenPage

    public static boolean isOpenPage(){
        if (driver.getCurrentUrl().equals(MAIN_PAGE)) {
            Log4Test.info("MAIN : open -> " + MAIN_PAGE);
            return true;
        }
        Log4Test.info("MAIN : cannot open page -> " + MAIN_PAGE);
        return false;
    }

    //-- end --


    // ---SERCH PARTH---


    public static boolean doSearchProduct(String product){
        Log4Test.info("MAIN -> do search product: " + product);
        try {
            driver.findElement(PAGE_SEARCHBOX_ID).clear();
            driver.findElement(PAGE_SEARCHBOX_ID).sendKeys(product);
            driver.findElement(PAGE_DO_SEARCH_ID).click();
            //
        }catch (Exception e){
            Log4Test.error("MAIN : " + product + " error in do searching!");
            return false;
        }
        Log4Test.info("MAIN : '" + product + "' is search...");
        return true;
    }

    //--- END SERCH PARTH

    //---CLOSE BUNNER---

    public static boolean cleanPage(){
        if(isNeedClean()) {
            try {
                Log4Test.info("Start to close banners.");
                WebElement element = driver.findElement(PAGE_BANER);
                if (element.isDisplayed()) {
                    element.findElement(PAGE_CLOSE).click();
                }
                element = driver.findElement(PAGE_CITY_CLOSE);
                if (element.isDisplayed()) {
                    element.click();
                }
            } catch (Exception e) {
                Log4Test.error("Error in 'close banners' part.");
                return false;

            }
        }
        Log4Test.info("Banners are close successful.");
        return true;
    }
    public static boolean isNeedClean(){
        try{
            driver.findElement(PAGE_BANER);
        }catch (Exception e){
            return false;
        }
        return true;

    }
    //---END CLOSE BUNNER---

    public static boolean goToRefregirators(){
        Log4Test.info("Start goToRefregirator");
        try {
            Actions builder = new Actions(driver.getOriginalDriver());
            builder.moveToElement(driver.findElement(BT)).perform();
            sleep(5);
            driver.findElement(BT_HOLOD).click();
            driver.findElement(REF_LG).click();
            driver.findElement(FILTER_FIRMA).click();
            sleep(5);
            driver.findElement(PRICE_UP).click();
            sleep(5);
        } catch (Exception e){
            Log4Test.error("Error in goToRefregirators");
            return false;
        }
        Log4Test.info("Finish goToRefregirators");
            return true;
    }
    public static boolean isSorted(){
        Log4Test.info("Start isSorted");
        List<WebElement> prices;
        try{
            sleep(5);
            WebElement element = driver.findElement(PRICE_CLASS);
            prices = element.findElements(ORGN_CLASS);
        // do not find element in custom logic
        }catch (Exception e){
            Log4Test.error("Error in isSorted");
            return false;
        }
        int firstPrice = prices.size() > 0 ? getAvnPrice(prices.get(0)) : -1;
        int secondPrices = prices.size() > 1 ? getAvnPrice(prices.get(1)) : -1;
        if (firstPrice == -1 || secondPrices == -1){
            return false;
        }


        //extract compare to other method
        Log4Test.info("isSorted: first price = "+ firstPrice);
        Log4Test.info("isSorted: second price = "+ secondPrices);
        Log4Test.info("Finish isSorted");
        return (firstPrice <= secondPrices);
    }



}