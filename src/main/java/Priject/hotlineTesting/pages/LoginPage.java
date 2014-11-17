package Priject.hotlineTesting.pages;

import Priject.hotlineTesting.actors.Users;
import Priject.hotlineTesting.selenium.WebDriverWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by boris on 03.11.14.
 */
public class LoginPage extends Page{
    private static Users user;
    //private static final By PAGE = By.xpath("//a[contains(text(), 'Войти')]");
    private static final String PAGE = "/user/log_in/";
    private static final By LOGIN_EMAIL = By.name("login");
    private static final By LOGIN_PASSWORD = By.name("password");
    private static final By LOGIN_BUTTON = By.className("blue-button");
    private static final By LOGIN_IS_SUCCSES = By.className("blue-button");

    public LoginPage(Users user, WebDriverWrapper driver){
        super(driver);
        this.user = user;
    }


    public static boolean openPage(){
        driver.get(driver.getCurrentUrl()+PAGE);
        return true;
    }
    public static boolean fillLoginForm(){
        try{
            driver.findElement(LOGIN_EMAIL).sendKeys(user.getEmail());
            driver.findElement(LOGIN_PASSWORD).sendKeys(user.getPassword());
            driver.findElement(LOGIN_BUTTON).click();
        } catch (Exception e){
            return false;
        }
        return true;
    }
    public boolean isLoginSuccses(){
        try{
            driver.findElement(LOGIN_IS_SUCCSES);
        }catch (Exception e){
            return false;
        }
        return true;
//        what for this method and other methods in this class
    }
}