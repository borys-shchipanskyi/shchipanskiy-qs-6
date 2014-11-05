package Priject.homeTask5.pages;

import Priject.homeTask5.actors.Users;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.management.timer.Timer;

/**
 * Created by boris on 03.11.14.
 */
public class MainPage extends Page {

    public MainPage(Users user, WebDriver driver) {
        super(user, driver);
    }

    public boolean cleanHome(){
        try {
            WebElement element = driver.findElement(By.className(SELECTOR_T_IMG_CLASS));
            element.findElement(By.className(SELECTOR_CLOSE_CLASS)).click();
            element = driver.findElement(By.cssSelector(SELECTOR_CITY_CLASS));
            element.click();
        } catch (Exception e){
            return false;
        }
        return true;
    }

    public boolean login(Users user){
        LoginPage lp = new LoginPage(user, driver);
        boolean logStat;
        try{
            lp.openPage();
            logStat = lp.login();
            lp.closePage();
        } catch (Exception e){
            System.out.println("paramExp");
            return false;
        }
        return logStat;
    }
    public boolean register(Users user){
        RegisterPage rp = new RegisterPage(user, driver);
        boolean isRegister = true;
        rp.opennPage();
        rp.register();

        try {
            isRegister = rp.checkIsRegister();
            //rp.closePage();
        } catch (Exception e){
            return false;
        }
        return isRegister;
    }

    public boolean findProduct(Users user,String product){
        driver.findElement(By.id(SELECTOR_SEARCHBOX_ID)).sendKeys(product);
        driver.findElement(By.id(SELECTOR_DO_SEARCH_ID)).click();
        GoodsPage gp = new GoodsPage(user, driver);
        boolean isSearch;
        try{
            isSearch = gp.isPresent(product);
        } catch (Exception e){
            return false;
        }
        return isSearch;
    }

}