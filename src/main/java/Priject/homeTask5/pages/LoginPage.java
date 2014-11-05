package Priject.homeTask5.pages;

import Priject.homeTask5.actors.Users;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import sun.rmi.runtime.Log;

import static Priject.homeTask5.pages.RegisterPage.*;

/**
 * Created by boris on 03.11.14.
 */
public class LoginPage extends Page{
    public LoginPage(Users user, WebDriver driver){
        super(user, driver);

    }

    public void openPage(){
        driver.get(HOME_URL+SELECTOR_LOGIN_PAGE);
    }

    public boolean login(){
        driver.findElement(By.name(SELECTOR_EMAIL_FILD)).sendKeys(logEmail);
        driver.findElement(By.name(SELECTOR_PASSWORD_FILD)).sendKeys(logPassword);
        driver.findElement(By.className(SELECTOR_BLUE_BUTTON_CLASS)).click();


        try{
            driver.findElement(By.className(SELECTOR_ENTER_ERROR_CLASS));
        } catch (Exception e){
            System.out.println("login catch");
            return true;
        }
        return false;

    }

    public void closePage(){
        driver.get(HOME_URL);
    }


    public void loginUseVk(){

    }
    public void loginUseFb(){

    }
    public void loginUseTw(){

    }
    public void loginUseGl(){

    }

}
