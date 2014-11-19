package Project.hotlineTesting.utils;

import Project.hotlineTesting.selenium.WebDriverWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by boris on 18.11.14.
 */
public class CalculationOnPages {
    public static final By PRICE_CLASS = By.xpath("//div[@class='price']");
    public static final By ORGN_CLASS = By.xpath("//span[@class='orng']");


    public static boolean comparePrices(WebDriverWrapper driver, int compareСondition){
        /**
         * compareСondition = 0 -> first < second
         * compareСondition = 1 -> first == second
         * compareСondition = 2 -> first > second
         * compareСondition = 3 -> first != -1 and  second != -1
         * -1 -> number haven't value;
         * */
        Log4Test.info("Start comparePrices");
        boolean returnStatus = false;
        List<WebElement> prices;


        try{
            //sleep(10);
            WebElement element = driver.findElement(PRICE_CLASS);
            prices = element.findElements(ORGN_CLASS);

        }catch (Exception e){
            Log4Test.error("Error in comparePrices");
            return false;
        }

        int firstPrice = prices.size() > 0 ? getAeragePrice(prices.get(0)) : -1;
        int secondPrices = prices.size() > 1 ? getAeragePrice(prices.get(1)) : -1;

        if (firstPrice == -1 || secondPrices == -1){
            Log4Test.info((firstPrice == -1) ? "comparePrices: first price = -1" :"comparePrices: second price = -1" );
            returnStatus =  false;
        }
        if(compareСondition == 0){
            returnStatus =  firstPrice < secondPrices;
        }
        if(compareСondition == 1){
            returnStatus = firstPrice == secondPrices;
        }
        if(compareСondition == 2){
            returnStatus = firstPrice > secondPrices;
        }
        if(compareСondition == 3){
            returnStatus = (firstPrice != -1 && secondPrices != -1);
        }

        Log4Test.info("comparePrices: first price = " + firstPrice);
        Log4Test.info("comparePrices: second price = " + secondPrices);
        Log4Test.info("Finish comparePrices");
        return returnStatus;
    }

    public static int getAeragePrice(WebElement element){
        String[] num = element.getText().split("\\s+");
        String buff = "";
        int i = 0;
        while (!num[i].equals("грн")){
            buff += num[i];
            i++;
        }
        return Integer.valueOf(buff);
    }
}
