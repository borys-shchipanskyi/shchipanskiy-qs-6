package Tests.hotlineTesting;

import Priject.hotlineTesting.selenium.WebDriverFactory;
import Priject.hotlineTesting.selenium.WebDriverWrapper;
import Priject.hotlineTesting.utils.Log4Test;
import Priject.hotlineTesting.utils.PropertyLoader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

/**
 * Created by bionic on 05.11.14.
 */
public class FunctionTest {
    public static final String MARKER = "###################";
    public static WebDriverWrapper driver;

    //@BeforeSuite
    @BeforeTest
    public void setEnv(){
        driver = WebDriverFactory.initDriver(PropertyLoader.loadProperty("browser.name"));
        driver.get(PropertyLoader.loadProperty("site.url"));
        Log4Test.info("Start Test Suite execution");

    }

    @AfterTest
    public void resetEnv(){
       //driver.get(PropertyLoader.loadProperty("site.url"));
        if (driver != null){
            driver.quit();
        }
        Log4Test.info("Tests Suite execution completed.");

    }

    /*@AfterSuite
    public void cleanEnv(){
        if (driver != null){
            driver.quit();
        }
        Log4Test.info("Tests Suite execution completed.");
    }*/
}
