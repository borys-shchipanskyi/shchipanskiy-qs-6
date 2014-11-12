package Priject.hotlineTesting.pages;

import Priject.hotlineTesting.selenium.WebDriverFactory;
import Priject.hotlineTesting.selenium.WebDriverWrapper;
import Priject.hotlineTesting.utils.Log4Test;
import Priject.hotlineTesting.utils.PropertyLoader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;


/**
 * Created by boris on 03.11.14.
 */
public class MainPage extends Page {
    public static final By BT = By.xpath("//b[contains(text(),'Бытовая техника')]");
    public static final By BT2 = By.xpath("//b[contains(text(),'Бытовая техника')]/div/div/div/div/a[1]");
    public static final By BT3 = By.xpath(".//*[@id='lv-1-548']/div/div/div/div/a[1]");


    public MainPage(WebDriverWrapper driver){
        super(driver);
    }
    public static boolean goToRefregirators(){
        Log4Test.info("Start goToRefregirators");
        try {
            driver.get("http://hotline.ua/bt/holodilniki/");

            driver.findElement(By.xpath(".//*[@id='filters']/div[5]/p[5]/a")).click();
            sleep();
            driver.findElement(By.xpath(".//*[@id='catalogue']/div[3]/div[2]/div/span")).click();
            driver.findElement(By.xpath(".//a[contains(text(),'возрастанию цены')]")).click();
            sleep();
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
            sleep();
            WebElement element = driver.findElement(By.xpath("//div[@class='price']"));
            prices = element.findElements(By.xpath("//span[@class='orng']"));

        }catch (Exception e){
            Log4Test.error("Error in isSorted");
            return false;
        }
        int firstPrice = prices.size() > 0 ? getAvnPrice(prices.get(0)) : -1;
        int secondPrices = prices.size() > 1 ? getAvnPrice(prices.get(1)) : -1;
        if (firstPrice == -1 || secondPrices == -1){
            return false;
        }
        Log4Test.info("isSorted: first price = "+ firstPrice);
        Log4Test.info("isSorted: second price = "+ secondPrices);
        Log4Test.info("Finish isSorted");
        return (firstPrice <= secondPrices);
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
    }


    public static void sleep(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}