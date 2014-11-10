package Priject.hotlineTesting.selenium;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.testng.Assert;

/**
 * Created by bionic on 10.11.14.
 */
public class WebDriverFactory {
    public static final String FIREFOX = "firefox";
    public static final String HTMLUNIT = "htmlunit";

    public static WebDriverWrapper initDriver( String driverName){
        WebDriverWrapper driverWripper = null;

        if(driverName.equals(FIREFOX)){
            driverWripper = new WebDriverWrapper( new FirefoxDriver());
        }
        if(driverName.equals(HTMLUNIT)){
            driverWripper = new WebDriverWrapper( new HtmlUnitDriver());
        }
        else
            Assert.fail("invalid driver name");

       driverWripper.manage().deleteAllCookies();
       driverWripper.manage().window().maximize();

       return driverWripper;
    }

}
