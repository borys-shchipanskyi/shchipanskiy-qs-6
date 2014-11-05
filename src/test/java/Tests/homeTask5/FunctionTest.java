package Tests.homeTask5;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

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
    }


    @AfterSuite
    public void cleanEnv(){
        if (driver != null){
            driver.quit();
        }
    }
}
