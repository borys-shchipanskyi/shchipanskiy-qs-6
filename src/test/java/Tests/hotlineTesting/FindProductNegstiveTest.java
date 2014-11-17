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
public class FindProductNegstiveTest extends FunctionTest{
    @DataProvider
    public Object[][] testData(){
        return new Object[][] {
                new Object[] {"Nexux"}
        };
    }

    @Test(dataProvider = "testData")
    public void testFindProductNegative(String product){
        Log4Test.info(MARKER+" START "+getClass().getName()+ " "+MARKER);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        SerchPage sp = new SerchPage(driver, product);
        //is searchPage and Main page is differend pages
        //find logic on mainPage, why it not in searchPage
        sp.findProduct(product);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Assert.assertFalse(sp.isPresent(), Log4Test.error("Can find product " + product));
        Log4Test.info(MARKER+" Finish "+getClass().getName()+ " "+MARKER);
        // a lot of wait/ extract it into a method
    }

}
