package Tests.hotlineTesting;

import Priject.hotlineTesting.selenium.WebDriverFactory;
import Priject.hotlineTesting.selenium.WebDriverWrapper;
import Priject.hotlineTesting.utils.Log4Test;
import Priject.hotlineTesting.utils.PropertyLoader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.util.concurrent.TimeUnit;

/**
 * Created by bionic on 05.11.14.
 */
public class FunctionTest {
    public static WebDriverWrapper driver;

    @BeforeSuite
    public void setEnv(){
        driver = WebDriverFactory.initDriver(PropertyLoader.loadProperty("browser.name"));
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
