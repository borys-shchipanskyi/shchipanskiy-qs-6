package Priject.hotlineTwsting.pages;

import Priject.hotlineTwsting.actors.Users;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by boris on 03.11.14.
 */
public class RegisterPage extends Page{

    private static Users user;

    private static final By PAGE = By.className("reg");
    private static final By REG_EMAIL = By.name("email");
    private static final By REG_NIC_NAME = By.name("nick");
    private static final By REG_PASSWORD = By.name("password");
    private static final By REG_PASSWORD2 = By.name("password2");
    private static final By REG_BUTTON = By.className("blue-button");
    private static final By REG_IS_SUCCSES = By.className("registr-successful");
    private static final By REG_FORM = By.className("page-registr-user");

    public RegisterPage(Users user, WebDriver driver){
        super(PAGE, driver);
        this.user = user;
    }

    public boolean fillRegistrationForm(){
        try{
            WebDriverWait wait = new WebDriverWait(driver, 1000);
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(REG_FORM)));

            driver.findElement(REG_EMAIL).sendKeys(user.getEmail());
            driver.findElement(REG_NIC_NAME).sendKeys(user.getNicName());
            driver.findElement(REG_PASSWORD).sendKeys(user.getPassword());
            driver.findElement(REG_PASSWORD2).sendKeys(user.getPassword());
            driver.findElement(REG_BUTTON).click();

        } catch (Exception e){
            System.out.println(e);
            return false;
        }
        return true;
    }
    public boolean isRegiststrationSuccses(){
        try{
            driver.findElement(REG_IS_SUCCSES);
        }catch (Exception e){
            return false;
        }
        return true;
    }

}