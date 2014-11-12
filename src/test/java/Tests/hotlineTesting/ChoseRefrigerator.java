package Tests.hotlineTesting;

import Priject.hotlineTesting.pages.MainPage;
import Priject.hotlineTesting.utils.Log4Test;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by boris on 11.11.14.
 */
public class ChoseRefrigerator extends FunctionTest {

    @DataProvider
    public Object[][] testData() {
        return new Object[][]{
                new Object[]{"LG", true}
        };
    }

    @Test(dataProvider = "testData")
    public void testComparePrice(String brend, boolean sortPriceUp) {
        Log4Test.info(MARKER+" START "+getClass().getName()+ " "+MARKER);
        MainPage mp = new MainPage(driver);
        mp.goToRefregirators();
        Assert.assertTrue(mp.isSorted(), "Product don't sort");
        Log4Test.info(MARKER+" Finish "+getClass().getName()+ " "+MARKER);
    }
}
