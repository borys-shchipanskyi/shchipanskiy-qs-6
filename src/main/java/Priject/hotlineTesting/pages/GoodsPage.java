package Priject.hotlineTesting.pages;

import Priject.hotlineTesting.selenium.WebDriverWrapper;
import Priject.hotlineTesting.utils.CalculationOnPages;
import Priject.hotlineTesting.utils.Log4Test;
import org.openqa.selenium.By;

/**
 * Created by bionic on 17.11.14.
 */

public class GoodsPage extends Page{
    private  By SERCH_PRODUCT;
    private  String PRODUCT;
    public  static By PAGE_ATTRIBUTE = By.className("catalog");
    public   By FILTER_PRISE_SHOW = By.xpath(".//*[@id='catalogue']/div[3]/div[2]/div/span");
    public   By FILTER_COMPANY;
    public   By FILTER_PRICE;

    public GoodsPage(WebDriverWrapper driver, String product){
        super(driver, PAGE_ATTRIBUTE);
        setSerchProduct(product);
    }

    public GoodsPage(WebDriverWrapper driver, String company, String filterPrice){
        super(driver);
        setByForFilter(company);
        setPriceFilter(filterPrice);
    }

    private void setSerchProduct(String product){
        SERCH_PRODUCT = By.xpath("//a[contains(text(),'"+product+"')]");
        PRODUCT = product;
    }

    public boolean isProductPresent(){
        Log4Test.info("GOODS -> check is product : '" + PRODUCT + "' can find");
        try{
            driver.findElement(SERCH_PRODUCT);
        }catch (Exception e){
            Log4Test.error("GOODS : " + PRODUCT + " isn't present in search result");
            return false;
        }
        Log4Test.info("GOODS -> product : '" + PRODUCT + "' find successful!");
        return true;
    }
    public boolean isProductHasTwoPlusValues(int compareСondition){
        boolean status;
        status = CalculationOnPages.comparePrices(driver, compareСondition);
        return status;
    }

    private void setByForFilter(String company){

        FILTER_COMPANY = By.xpath(".//*[@id='filters']/div/p/a[contains(text(),'"+company+"')]");
        Log4Test.info("GOODS -> company : "+ company);
        Log4Test.info("GOODS -> company : "+ FILTER_COMPANY);
    }
    private void setPriceFilter(String filterPrice){
        FILTER_PRICE = By.xpath(".//a[contains(text(),'"+filterPrice+"')]");
        Log4Test.info("GOODS -> price : "+ filterPrice);
        Log4Test.info("GOODS -> price : "+ FILTER_PRICE);
    }

    public boolean setCompanyFilters(){
        Log4Test.info("GOODS -> setCompanyFilters : start!");

        try{
            driver.findElement(FILTER_COMPANY).click();
            sleep(5);
            driver.findElement(FILTER_PRISE_SHOW).click();
            sleep(1);
            driver.findElement(FILTER_PRICE).click();
            sleep(1);
        }catch (Exception e){
            Log4Test.info("GOODS -> setCompanyFilters : error!");
            return false;
        }
        Log4Test.info("GOODS -> setCompanyFilters : successful!");
        return true;
    }
}
