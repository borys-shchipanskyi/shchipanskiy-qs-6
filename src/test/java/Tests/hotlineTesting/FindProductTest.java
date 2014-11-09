package Tests.hotlineTesting;

import Priject.hotlineTwsting.pages.SerchPage;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by boris on 05.11.14.
 */
public class FindProductTest extends FunctionTest{

    @DataProvider
    public Object[][] testData(){
        return new Object[][] {
                new Object[] {"http://hotline.ua/", "iPhone"}
        };
    }

    @Test(dataProvider = "testData")
    public void testFindProduct(String strUrl, String product){
        driver.get(strUrl);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        SerchPage sp = new SerchPage(driver, product);
        sp.findProduct(product);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Assert.assertTrue(sp.isPresent());
    }
}
