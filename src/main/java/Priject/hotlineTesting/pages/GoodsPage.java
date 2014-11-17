package Priject.hotlineTesting.pages;

import Priject.hotlineTesting.selenium.WebDriverWrapper;
import Priject.hotlineTesting.utils.Log4Test;
import org.openqa.selenium.By;

import java.util.NoSuchElementException;

/**
 * Created by bionic on 17.11.14.
 */
public class GoodsPage extends Page{
    private static By SERCH_PRODUCT;
    private static final By PAGE_ATTRIBUTE = By.className("catalog");

    public GoodsPage(WebDriverWrapper driver, String product){
        super(driver);
        setSerchProduct(product);
    }
    private static void setSerchProduct(String product){
        SERCH_PRODUCT = By.xpath("//a[contains(text(),'"+product+"')]");
    }

    public static boolean isProductPresent(String product){
        Log4Test.info("GOODS -> check is product : '" + product + "' find");
        try{
            driver.findElement(SERCH_PRODUCT);
        }catch (NoSuchElementException e){
            Log4Test.error("Product : " + product + " isn't present in search result");
            return false;
        }
        Log4Test.info("GOODS -> product : '" + product + "' find sucsses!");
        return true;
    }
}
