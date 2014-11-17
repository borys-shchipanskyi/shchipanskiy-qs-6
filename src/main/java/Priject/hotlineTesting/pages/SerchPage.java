package Priject.hotlineTesting.pages;

import Priject.hotlineTesting.selenium.WebDriverWrapper;
import Priject.hotlineTesting.utils.Log4Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by boris on 05.11.14.
 */
public class SerchPage extends Page  {

    private static String PRODUCT ;

    private static By SERCH_PRICE = By.xpath("//span[contains(text(),'Цены')]");
    //private static By SERCH_PRICE = By.xpath("//span[contains(text(),'Ціни')]");


    public SerchPage(WebDriverWrapper driver, String product){
        super(driver);
        this.PRODUCT = product;

    }




   /* public static boolean isPresent(){
        try {
            Log4Test.info("Check if product : " + PRODUCT + " present in search result.");
            driver.findElement(SERCH_PRODUCT);
            sleep(5);
        }catch (Exception e){
            Log4Test.error("Product : " + PRODUCT + " isn't present in search result");
            return false;
        }
        Log4Test.info("Product : " + PRODUCT + " is present in search result");
            return true;

    }*/
    public static boolean isEqualsPrice(){
        Log4Test.info("Start isEqualsPrice");
        List<WebElement> prices;
        try{
            //sleep(10);
            WebElement element = driver.findElement(PRICE_CLASS);
            prices = element.findElements(ORGN_CLASS);

        }catch (Exception e){
            Log4Test.error("Error in isEqualsPrice");
            return false;
        }
        int firstPrice = prices.size() > 0 ? getAvnPrice(prices.get(0)) : -1;
        int secondPrices = prices.size() > 1 ? getAvnPrice(prices.get(1)) : -1;
        if (firstPrice == -1 || secondPrices == -1){
            Log4Test.info((firstPrice == -1) ? "isEqualsPrice: first price = -1" :"isEqualsPrice: second price = -1" );
            return false;
        }
        Log4Test.info("isEqualsPrice: first price = "+ firstPrice);
        Log4Test.info("isEqualsPrice: second price = "+ secondPrices);
        Log4Test.info("Finish isEqualsPrice");
        return (firstPrice != secondPrices);
    }


    /*
    public static boolean comparePrice(){
        String pricesReng = "";
        Log4Test.info("Start compare price.");
        try{
            sleep(5);
            driver.findElement(SERCH_PRODUCT).click();
            sleep(5);
            driver.findElement(SERCH_PRICE).click();
            //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            sleep(5);
            pricesReng = driver.findElement(SERCH_PRICES_RANGE).getText();

        }catch (Exception e){
            Log4Test.error("Cannot find prices range.");
            return false;
        }
        Log4Test.info("Find next price range: " + pricesReng);
        Log4Test.info("Finish compare price.");
        return isNotEqualsPrice(pricesReng);
    }

    private static boolean isNotEqualsPrice(String pricesReng){
        String[] str = pricesReng.split("\\s+");
        int tmp = 0;
        String first = "";
        String second = "";
        for (int i = 0; i < str.length; i++){
            if (tmp == 0) {
                if (str[i].equals("-")) {
                    tmp = -1;

                } else {
                    first += str[i];
                }
            }
            else{
                if(!str[i].equals("грн")){
                    second += str[i];
                }
            }
        }
        return !first.equals(second);

    }*/
}
