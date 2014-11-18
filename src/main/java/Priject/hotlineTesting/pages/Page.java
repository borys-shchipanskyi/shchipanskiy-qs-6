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
public abstract class Page {
    private static String PAGE;

    public static By PAGE_ATTRIBUTE;

    public static WebDriverWrapper driver;

    public static final By PRICE_CLASS = By.xpath("//div[@class='price']");
    public static final By ORGN_CLASS = By.xpath("//span[@class='orng']");

    public static String CLOSE_BANNER = "close";
    public static String SELECT_PLACE = "blue-button";
    // this variables is not need

    public Page(WebDriverWrapper driver, String page){
        this.driver = driver;
        this.PAGE = page;
    }

    public Page(WebDriverWrapper driver, By pageAtribute){
        this.driver = driver;
        PAGE_ATTRIBUTE = pageAtribute;
    }

    public static boolean openPage(){
        try{
            Log4Test.info("Start open page.");
            driver.get(PAGE);
        } catch (Exception e){
            Log4Test.error("Error in open page.");
            return false;
        }
        Log4Test.info("Page open successful.");
        return true;
    }

    public static boolean isOpenPage(){
        try{
            Log4Test.info("PAGE: Check is page open. " + PAGE_ATTRIBUTE);
            sleep(5);
            driver.findElement(PAGE_ATTRIBUTE).isDisplayed();
        } catch (Exception e){
            Log4Test.error("PAGE: Error with check page.");
            return false;
        }
        Log4Test.info("PAGE: Page is open.");
        return true;
    }
















    public static boolean findProduct(String product){
        try{
            Log4Test.info("Try to find product : ." + product);

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