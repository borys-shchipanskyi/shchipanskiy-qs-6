package Tests.hotlineTesting;

import Priject.hotlineTesting.utils.Log4Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.util.concurrent.TimeUnit;

/**
 * Created by bionic on 05.11.14.
 */
public class FunctionTest {
    public static WebDriver driver;

    @BeforeSuite
    public void setInv(){
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
        Log4Test.info("Start Test Suite execution");

    }


    @AfterSuite
    public void cleanEnv(){
        if (driver != null){
            driver.quit();
        }
        Log4Test.info("Tests Suite execution completed.");
    }
}
