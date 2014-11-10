package Priject.hotlineTesting.pages;

import Priject.hotlineTesting.actors.Users;
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

    public RegisterPage(Users user, WebDriver driver){
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
            driver.findElement(REG_BUTTON).click();

        } catch (Exception e){

            Log4Test.error("There are problem(s) with filing registration form");
            return false;
        }
        Log4Test.info("Filling complet successful.");
        return true;
    }
    public boolean isRegiststrationSuccses(){
        try{
            Log4Test.info("check is registration successful.");
            driver.findElement(REG_IS_SUCCSES);
        }catch (Exception e){
            Log4Test.error("Registration isn't successful.");
            return false;
        }
        Log4Test.info("Registration is successful.");
        return true;
    }

}