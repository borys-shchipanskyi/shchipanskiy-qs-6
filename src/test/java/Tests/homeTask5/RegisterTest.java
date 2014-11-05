package Tests.homeTask5;

import Priject.homeTask5.actors.Users;
import Priject.homeTask5.pages.MainPage;
import Priject.homeTask5.pages.RegisterPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
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
public class RegisterTest {
    public static WebDriver driver;


    @BeforeSuite
    public void setInv(){
        driver = new FirefoxDriver();
    }
    @DataProvider
    public Object[][] testData(){
        return new Object[][] {
        new Object[] {"http://hotline.ua/", userInfo("param@gmail.com",  "test", "test")},
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
    public void testRegistration(String strUrl, HashMap hm){

        /*WebDriverWait wait = new WebDriverWait(driver, 1000);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.className("close"))));
        driver.get(strUrl);
        driver.findElement(By.className("blue-button")).click();
        driver.findElement(By.className("reg")).click();
        Assert.assertTrue(true);
        */
        Users user = new Users(hm);
        MainPage mp = new MainPage(strUrl, driver);
        mp.cleanHome();
<<<<<<< HEAD
        boolean loginStat = mp.login(user);

        Assert.assertTrue((!loginStat) ? mp.register(user) : false, (!loginStat) ? ERROR_MSG1 : ERROR_MSG2);
    }
    @Test(dataProvider = "testData")
    public void testRegistrationNegative(String strUrl, HashMap hm, boolean isGenerateEmail){
        driver.get(strUrl);
        Users user = new Users(hm, isGenerateEmail);
        MainPage mp = new MainPage(user, driver);
        mp.cleanHome();
        boolean loginStat = mp.login(user);

        Assert.assertFalse((!loginStat) ? mp.register(user) : false, (!loginStat) ? ERROR_MSG1 : ERROR_MSG2);
=======
        boolean loginStatus =  mp.login(user);
>>>>>>> 2140876a1b8a17695b9254dda6e1cbf7b12555e1

        if (!loginStatus){
            Assert.assertEquals(RegisterPage.register(), true);
        }
        else Assert.assertFalse(loginStatus);
    }
<<<<<<< HEAD


=======
    /*
>>>>>>> 2140876a1b8a17695b9254dda6e1cbf7b12555e1
    @AfterSuite
    public void cleanEnv(){
        if (driver != null){
            driver.quit();
        }
    }*/
}
