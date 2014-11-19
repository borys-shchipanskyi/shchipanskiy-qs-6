package Tests.hotlineTesting;

import Project.hotlineTesting.pages.MainPage;
import Project.hotlineTesting.selenium.WebDriverFactory;
import Project.hotlineTesting.selenium.WebDriverWrapper;
import Project.hotlineTesting.utils.Log4Test;
import Project.hotlineTesting.utils.PropertyLoader;
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

