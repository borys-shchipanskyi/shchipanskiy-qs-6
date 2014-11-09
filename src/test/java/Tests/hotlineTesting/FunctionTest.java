package Tests.hotlineTesting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.util.concurrent.TimeUnit;

/**
 * Created by bionic on 05.11.14.
 */
public class FunctionTest {
    public final String ERROR_MSG1  = "Cannot register with this credentials,";
    public final String ERROR_MSG2  = "Login is possible with this credentials, so registration is failed(,";
    public static WebDriver driver;

    @BeforeSuite
    public void setInv(){
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();

    }


    @AfterSuite
    public void cleanEnv(){
        if (driver != null){
            driver.quit();
        }
    }
}
