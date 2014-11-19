package Tests.hotlineTesting;

import Priject.hotlineTesting.pages.MainPage;
import Priject.hotlineTesting.selenium.WebDriverFactory;
import Priject.hotlineTesting.selenium.WebDriverWrapper;
import Priject.hotlineTesting.utils.Log4Test;
import Priject.hotlineTesting.utils.PropertyLoader;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;


/**
 * Created by bionic on 05.11.14.
 */
public class FunctionTest {
    public static final String MARKER = "###################";
    public static WebDriverWrapper driver;
    public MainPage mainPage;

    @BeforeSuite
    public void setEnv(){
        driver = WebDriverFactory.initDriver(PropertyLoader.loadProperty("browser.name"));
        Log4Test.info("Start Test Suite execution");

    }

    @AfterSuite
    public void resetEnv(){
        if (driver != null){
            driver.quit();
        }
        Log4Test.info("Tests Suite execution completed.");

    }
}

