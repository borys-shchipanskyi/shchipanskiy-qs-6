package Tests.hotlineTesting;

import Priject.hotlineTesting.pages.SerchPage;
import Priject.hotlineTesting.utils.Log4Test;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by matafix on 09.11.14.
 */
public class ComparePricesTest extends FunctionTest{
    public static final String FAIL_MSG = "FAIL: There is only one price";

    @DataProvider
    public Object[][] testData(){
        return new Object[][] {
                new Object[] {"iPhone"}
        };
    }

    @Test(dataProvider = "testData")
    public void testComparePrice(String product) {
        Log4Test.info(MARKER+" START "+getClass().getName()+ " "+MARKER);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        SerchPage sp = new SerchPage(driver, product);
        sp.findProduct(product);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Assert.assertTrue(sp.comparePrice(), Log4Test.error(FAIL_MSG));
        Log4Test.info(MARKER+" Finish "+getClass().getName()+ " "+MARKER);
    }

}
