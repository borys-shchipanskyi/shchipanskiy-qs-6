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
    private static final String MAIN_PAGE = PropertyLoader.loadProperty("site.url") + '/';

    private final By PAGE_SEARCHBOX_ID = By.id("searchbox");
    private final By PAGE_DO_SEARCH_ID = By.id("doSearch");

    private final By PAGE_CITY_CLOSE = By.cssSelector("a.blue-button.success");
    private final By PAGE_CLOSE = By.className("close");
    private final By PAGE_BANER = By.className("lightbox-form");

    private final By BT = By.xpath("//b[contains(text(),'Бытовая техника')]");
    private final By BT_HOLOD = By.xpath("//a[@href='/bt/holodilniki/']");

    private  final By REGISTRATION_PAGE = By.className("reg");

    public MainPage(WebDriverWrapper driver){
        super(driver, MAIN_PAGE);
    }

    // ---new isOpenPage

    public boolean isOpenPage(){
        if (driver.getCurrentUrl().equals(MAIN_PAGE)) {
            Log4Test.info("MAIN : open -> " + MAIN_PAGE);
            return true;
        }
        Log4Test.info("MAIN : cannot open page -> " + MAIN_PAGE);
        return false;
    }

    //-- end isOpenPage--

    // ---SEARCH PART---

    public boolean doSearchProduct(String product){
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

    //--- END SEARCH PART

    //---CLOSE BANNER---

    public boolean cleanPage(){
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
    public boolean isNeedClean(){
        try{
            driver.findElement(PAGE_BANER);
        }catch (Exception e){
            return false;
        }
        return true;

    }
    //---END CLOSE BANNER---

    //--- REGISTRATION TEST PART---
    public boolean goToRegistration(){
        Log4Test.info("Start goToRegistration");
        try{
            driver.findElement(REGISTRATION_PAGE).click();
        } catch (Exception e){
            Log4Test.error("Error in goToRegistration");
            return false;
        }
        Log4Test.info("Finish goToRegistration");
        return true;
    }
    //--- END REGISTRATION TEST PART---

    //---REFRIGERATOR TEST PART---
    public boolean goToRefrigerators(){
        Log4Test.info("Start goToRefrigerator");
        try {
            Actions builder = new Actions(driver.getOriginalDriver());
            builder.moveToElement(driver.findElement(BT)).perform();
            sleep(2);
            driver.findElement(BT_HOLOD).click();
        } catch (Exception e){
            Log4Test.error("Error in goToRefregirators");
            return false;
        }
        Log4Test.info("Finish goToRefregirators");
            return true;
    }
    //--- END REFRIGERATOR TEST PART---

}