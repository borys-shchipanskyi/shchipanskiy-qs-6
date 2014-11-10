package Tests.hotlineTesting;

import Priject.hotlineTesting.pages.SerchPage;
import Priject.hotlineTesting.utils.Log4Test;
import org.testng.Assert;
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
        Log4Test.info("Start : testFindProduct");
        driver.get(strUrl);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        SerchPage sp = new SerchPage(driver, product);
        sp.findProduct(product);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Assert.assertTrue(sp.isPresent(), Log4Test.error("Cannot find product" + product));
        Log4Test.info("Finish successful : testFindProduct");
    }
}
