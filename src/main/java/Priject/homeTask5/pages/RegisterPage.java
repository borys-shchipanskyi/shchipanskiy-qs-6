package Priject.homeTask5.pages;

import Priject.homeTask5.actors.Users;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by boris on 03.11.14.
 */
public class RegisterPage extends Page{

    public RegisterPage(Users user, WebDriver driver){
        super(user, driver);
    }
    public void opennPage(){
        driver.findElement(By.className(SELECTOR_REG_CLASS)).click();
    }
    public boolean register(){
        try{
            driver.findElement(By.name("email")).sendKeys(logEmail);
            driver.findElement(By.name("nick")).sendKeys(nicName);
            driver.findElement(By.name("password")).sendKeys(logPassword);
            driver.findElement(By.name("password2")).sendKeys(logPassword);
            driver.findElement(By.className("blue-button")).click();

        } catch (Exception e){
            return false;
        }
        return true;
    }
    public boolean checkIsRegister(){
        try{
            driver.findElement(By.className(SELECTOR_REG_SUCCSES_CLASS));
        }catch (Exception e){
            return false;
        }
        return true;
    }

    public void closePage(){
        driver.get(HOME_URL);
    }
}
