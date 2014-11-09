package Priject.hotlineTwsting.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by boris on 05.11.14.
 */
public class SerchPage extends Page  {

    private static String PRODUCT ;
    private static By SERCH_PRODUCT;
    private static By SERCH_PRICE = By.xpath("//span[contains(text(),'Ціни')]");
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
            driver.findElement(SERCH_PRODUCT);
        }catch (Exception e){
           return false;
        }
            return true;
    }
    public static boolean comparePrice(){
        String pricesReng;
        try{
            driver.findElement(SERCH_PRODUCT).click();
            driver.findElement(SERCH_PRICE).click();
            pricesReng = driver.findElement(SERCH_PRICES_RANGE).getText();
        }catch (Exception e){
            return false;
        }
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
