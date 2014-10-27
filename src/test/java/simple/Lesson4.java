package simple;




import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.testng.Assert;
import org.testng.annotations.*;

/**
 * Created by bionic on 27.10.14.
 */
public class Lesson4 {
    public static WebDriver driver;


    @DataProvider
    public Object[][] filters(){
        return new Object[][]{
                new Object[] {"http://testng.org/doc/index.html", "TestNG"},
                new Object[] {"http://google.com", "Google"},
                new Object[] {"http://testng.org", "user"}

        };
    }



    @BeforeSuite
    public void initEnv(){
        driver = new HtmlUnitDriver();
    }

    @Test(dataProvider = "filters")
    public void numberOfFilteredElementsTest(String strUrl, String text){
        driver.get(strUrl);
        Assert.assertTrue(driver.findElements(By.linkText(text)).size() > 0);
    }

    @AfterSuite
    public void shutEnv(){
        if (driver != null)
            driver.quit();
    }
}
