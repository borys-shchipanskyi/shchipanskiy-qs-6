package Priject.homeTask5.pages;

import Priject.homeTask5.actors.Users;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by boris on 04.11.14.
 */
public class Page {
    private static By PAGE;
    public static WebDriver driver;

    public static final By PAGE_CITY_CLOSE = By.cssSelector("a.blue-button.success");
    public static final By PAGE_CLOSE = By.className("close");

    public Page(WebDriver driver){
        this.driver = driver;
    }
    public Page(By page, WebDriver driver){
        this.driver = driver;
        PAGE = page;

    }

    public static boolean cleanPage(){
        try{
            WebElement element = driver.findElement(PAGE_CLOSE);
            element.click();
            element = driver.findElement(PAGE_CITY_CLOSE);
            element.click();

        }
        catch (Exception e){
            return false;
        }
        return true;
    }
    public static boolean openPage(){
        try{
            driver.findElement(PAGE).click();
        } catch (Exception e){
            return false;
        }
        return true;
    }

    public static boolean isOpen(){
        try{
            driver.findElement(PAGE);
        } catch (Exception e){
            return false;
        }
        return true;
    }
}