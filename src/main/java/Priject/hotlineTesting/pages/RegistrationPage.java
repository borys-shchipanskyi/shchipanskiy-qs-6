package Priject.hotlineTesting.pages;

import Priject.hotlineTesting.actors.Users;
import Priject.hotlineTesting.selenium.WebDriverWrapper;
import Priject.hotlineTesting.utils.Log4Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by boris on 03.11.14.
 */
public class RegistrationPage extends Page{

    private Users USER;


    private final By REG_EMAIL = By.name("email");
    private final By REG_NIC_NAME = By.name("nick");
    private final By REG_PASSWORD = By.name("password");
    private final By REG_PASSWORD2 = By.name("password2");
    private final By REG_BUTTON = By.className("blue-button");
    private final By REG_IS_SUCCSES = By.className("registr-successful");
    private final By REG_FORM = By.className("page-registr-user");

    public static By PAGE_ATTRIBUTE = By.className("catalog");

    public RegistrationPage(Users user, WebDriverWrapper driver){
        super(driver, PAGE_ATTRIBUTE);
        USER = user;
    }


    public boolean fillRegistrationForm(){
        try{
            Log4Test.info("Start fill registration form.");
            WebDriverWait wait = new WebDriverWait(driver, 1000);
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(REG_FORM)));
            driver.findElement(REG_EMAIL).sendKeys(USER.getEmail());
            driver.findElement(REG_NIC_NAME).sendKeys(USER.getNicName());
            driver.findElement(REG_PASSWORD).sendKeys(USER.getPassword());
            driver.findElement(REG_PASSWORD2).sendKeys(USER.getPassword());
            driver.findElement(REG_BUTTON).click();

        } catch (Exception e){

            Log4Test.error("There are problem(s) with filing registration form");
            return false;
        }
        sleep(5);
        Log4Test.info("Filling complet successful.");
        return true;
    }


    public boolean isRegistrationSuccses(){
        boolean status = false;
        try{
            Log4Test.info("Check is registration successful.");
            sleep(5);
            if (driver.findElement(REG_IS_SUCCSES).isDisplayed()){
                status = true;
            }
        }catch (Exception e){
            Log4Test.error("Registration isn't successful.");
            status =  false;
        }
        Log4Test.info("Registration is successful.");
        return status;
    }

}