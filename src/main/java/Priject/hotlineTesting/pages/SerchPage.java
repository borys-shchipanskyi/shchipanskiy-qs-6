package Priject.hotlineTesting.pages;

import Priject.hotlineTesting.utils.Log4Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by boris on 05.11.14.
 */
public class SerchPage extends Page  {

    private static String PRODUCT ;
    private static By SERCH_PRODUCT;
    private static By SERCH_PRICE = By.xpath("//span[contains(text(),'Цени')]");
    private static By SERCH_PRICES_RANGE = By.className("orng");


    public SerchPage(WebDriver driver, String product){
        super(driver);
        this.PRODUCT = product;
        setSerchProduct();
    }

    private void setPRODUCT(String product) {
        this.PRODUCT = product;
    }
    private void setSerchProduct(){
        this.SERCH_PRODUCT = By.xpath("//a[contains(text(),'"+this.PRODUCT+"')]");
    }

    public static boolean isPresent(){
        try {
            Log4Test.info("Check if product :" + PRODUCT + " present in search result.");
            driver.findElement(SERCH_PRODUCT);
        }catch (Exception e){
            Log4Test.error("Product :" + PRODUCT + " isn't present in search result");
            return false;
        }
        Log4Test.info("Product :" + PRODUCT + " is present in search result");
            return true;
    }
    public static boolean comparePrice(){
        String pricesReng;
        Log4Test.info("Start compare price.");
        try{
            driver.findElement(SERCH_PRODUCT).click();
            driver.findElement(SERCH_PRICE).click();
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            pricesReng = driver.findElement(SERCH_PRICES_RANGE).getText();

        }catch (Exception e){
            System.out.println(Log4Test.error("Cannot find prices range."));
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

    }
}
