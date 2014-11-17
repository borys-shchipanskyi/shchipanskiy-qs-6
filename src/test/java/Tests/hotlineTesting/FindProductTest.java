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
    private SerchPage serchPage;

    @DataProvider
    public Object[][] testData(){
        return new Object[][] {
                new Object[] {"iPhone"}
        };
    }

    @Test(dataProvider = "testData")
    public void testFindProduct( String product){
        Log4Test.info(MARKER+" START "+getClass().getName()+ " "+MARKER);
        serchPage= new SerchPage(driver, product);
        serchPage.findProduct(product);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Assert.assertTrue(serchPage.isPresent());
        Log4Test.info("SUCCSES find product:" +  product);
        Log4Test.info(MARKER+" Finish "+getClass().getName()+ " "+MARKER);
    }
}
