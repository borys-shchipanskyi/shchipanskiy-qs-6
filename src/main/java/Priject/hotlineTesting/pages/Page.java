package Priject.hotlineTesting.pages;

import Priject.hotlineTesting.selenium.WebDriverWrapper;
import Priject.hotlineTesting.utils.Log4Test;
import Priject.hotlineTesting.utils.PropertyLoader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by boris on 04.11.14.
 */
public class Page {
    private static By PAGE;
    public static WebDriverWrapper driver;

    public static final By PAGE_CITY_CLOSE = By.cssSelector("a.blue-button.success");
    public static final By PAGE_CLOSE = By.className("close");

    public static final By PAGE_SEARCHBOX_ID = By.id("searchbox");
    public static final By PAGE_DO_SEARCH_ID = By.id("doSearch");
    public static final By PAGE_BANER = By.className("lightbox-form");
    public static final By PRICE_CLASS = By.xpath("//div[@class='price']");
    public static final By ORGN_CLASS = By.xpath("//span[@class='orng']");

    public static String CLOSE_BANNER = "close";
    public static String SELECT_PLACE = "blue-button";
    // this variables is not need

    public Page(WebDriverWrapper driver){
        this.driver = driver;
        cleanPage();
        //we clean at start
        driver.get(PropertyLoader.loadProperty("site.url"));
    }

    public Page(By page, WebDriverWrapper driver){
        this.driver = driver;
        PAGE = page;
        cleanPage();
    }

    public static boolean cleanPage(){
        if(isNeedClean()) {
            try {
                Log4Test.info("Start clean page procedure.");
                WebElement element = driver.findElement(PAGE_BANER);
                if (element.isDisplayed()) {
                    element.findElement(PAGE_CLOSE).click();
                }
                element = driver.findElement(PAGE_CITY_CLOSE);
                if (element.isDisplayed()) {
                    element.click();
                }
            } catch (Exception e) {
                Log4Test.error("Error in clean page procedure.");
                return false;

            }
        }
        Log4Test.info("Page clean successful.");
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

    public static boolean openPage(){
        try{
            Log4Test.info("Start open page.");
            driver.findElement(PAGE).click();
        } catch (Exception e){
            Log4Test.error("Error in open page.");
            return false;
        }
        Log4Test.info("Finish open page.");
        return true;
    }

    public static boolean isOpen(){
        try{
            Log4Test.info("Check is page open.");
            driver.findElement(PAGE);
        } catch (Exception e){
            Log4Test.error("Error with check page.");
            return false;
        }
        Log4Test.info("Page is open.");
        return true;
    }
    public static boolean findProduct(String product){
        try{
            Log4Test.info("Try to find product : ."+ product);
            driver.findElement(PAGE_SEARCHBOX_ID).clear();
            driver.findElement(PAGE_SEARCHBOX_ID).sendKeys(product);
            driver.findElement(PAGE_DO_SEARCH_ID).click();
            //Thread.sleep(1000);
        }catch (Exception e){
            Log4Test.error("Cannot find product : " + product);
            return false;
        }
        Log4Test.info("product find successful.");
        return true;
    }
    public static void sleep(int sec){
        try {
            Log4Test.info("Sleap to "+sec+".");
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static int getAvnPrice(WebElement element){
        String[] num = element.getText().split("\\s+");
        String buff = "";
        int i = 0;
        while (!num[i].equals("грн")){
            buff += num[i];
            i++;
        }
        return Integer.valueOf(buff);
        // is main page has prices?
    }

}