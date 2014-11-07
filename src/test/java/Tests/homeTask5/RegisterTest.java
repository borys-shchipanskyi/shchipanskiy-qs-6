package Tests.homeTask5;

import Priject.homeTask5.actors.Users;
import Priject.homeTask5.pages.LoginPage;
import Priject.homeTask5.pages.MainPage;
import Priject.homeTask5.pages.RegisterPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;

/**
 * Created by boris on 03.11.14.
 */
public class RegisterTest extends FunctionTest{

    @DataProvider
    public Object[][] testData(){
        return new Object[][] {
                new Object[] {"http://hotline.ua/", userInfo("param@gmail.com",  "test", "test"), true}
        };
    }
    public HashMap<String, String> userInfo(String email, String nicName, String password){
        HashMap hm = new HashMap();
        hm.put("email", email);
        hm.put("nicName", nicName);
        hm.put("password", password);
        return hm;
    }


    @Test(dataProvider = "testData")
    public void test(String strUrl, HashMap hm, boolean isGenerateEmail){
        driver.get(strUrl);
        Users user = new Users(hm, isGenerateEmail);
        LoginPage lp = new LoginPage(user, driver);
        lp.cleanPage();
        lp.openPage();
        lp.fillLoginForm();
        //WebDriverWait wait = new WebDriverWait(driver, 1000);
       // wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[contains(text(), 'Войти')]"))));
       // driver.findElement(By.xpath("//a[contains(text(), 'Войти')]")).click();

    }/*

    @Test(dataProvider = "testData")
    public void testRegistration(String strUrl, HashMap hm, boolean isGenerateEmail){
        driver.get(strUrl);
        Users user = new Users(hm, isGenerateEmail);
        RegisterPage rp = new RegisterPage(user, driver);
        rp.openPage();
        rp.cleanPage();
        rp.fillRegistrationForm();
        Assert.assertTrue(rp.isRegiststrationSuccses(), ERROR_MSG1);

    }
    @Test(dataProvider = "testData")
    public void testRegistrationNegative(String strUrl, HashMap hm, boolean isGenerateEmail){
        driver.get(strUrl);
        Users user = new Users(hm, !isGenerateEmail);
        RegisterPage rp = new RegisterPage(user, driver);
        rp.openPage();
        rp.cleanPage();
        rp.fillRegistrationForm();
        Assert.assertFalse(rp.isRegiststrationSuccses(), ERROR_MSG1);

    }*/
    @AfterSuite
    public void cleanEnv(){
        //if (driver != null){
        //    driver.quit();
        //}
    }

}