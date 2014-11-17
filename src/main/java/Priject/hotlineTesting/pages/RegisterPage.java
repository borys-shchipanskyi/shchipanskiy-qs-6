package Priject.hotlineTesting.pages;

import Priject.hotlineTesting.actors.Users;
import Priject.hotlineTesting.selenium.WebDriverWrapper;
import Priject.hotlineTesting.utils.Log4Test;
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

    public RegisterPage(Users user, WebDriverWrapper driver){
        super(PAGE, driver);
        this.user = user;
    }

    public boolean fillRegistrationForm(){
        try{
            Log4Test.info("Start fill registration form.");
            WebDriverWait wait = new WebDriverWait(driver, 1000);
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(REG_FORM)));

            driver.findElement(REG_EMAIL).sendKeys(user.getEmail());
            driver.findElement(REG_NIC_NAME).sendKeys(user.getNicName());
            driver.findElement(REG_PASSWORD).sendKeys(user.getPassword());
            driver.findElement(REG_PASSWORD2).sendKeys(user.getPassword());
            // what is REG_PASSWORD2
            driver.findElement(REG_BUTTON).click();
            // give to variables a normal_readeble names


        } catch (Exception e){

            Log4Test.error("There are problem(s) with filing registration form");
            return false;
        }
        sleep(5);
        Log4Test.info("Filling complet successful.");
        return true;
    }
    public boolean isRegiststrationSuccses(){
        boolean status = false;
        try{
            Log4Test.info("Check is registration successful.");
            sleep(5);
            if (driver.findElement(REG_IS_SUCCSES).isDisplayed()){
                status = true;
            };
        }catch (Exception e){
            Log4Test.error("Registration isn't successful.");
            status =  false;
        }
        Log4Test.info("Registration is successful.");
        return status;
        // a lot of set of instance status
        // and you can check that something on page and not failure
    }

}