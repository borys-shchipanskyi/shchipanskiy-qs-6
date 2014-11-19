package Tests.hotlineTesting;

import Priject.hotlineTesting.pages.GoodsPage;
import Priject.hotlineTesting.pages.MainPage;
import Priject.hotlineTesting.utils.Log4Test;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


/**
 * Created by matafix on 09.11.14.
 */

public class ComparePricesTest extends FunctionTest{
    public static final String FAIL_MSG = "FAIL: There is only one price";
    private GoodsPage goodsPage;

    @DataProvider
    public Object[][] testData(){
        return new Object[][] {
                new Object[] {"iPhone"}
        };
    }

    @Test(dataProvider = "testData")
    public void testComparePrice(String product) {
        Log4Test.info(MARKER + " START " + getClass().getName() + " " + MARKER);
        mainPage = new MainPage(driver);
        mainPage.openPage();
        mainPage.cleanPage();
        goodsPage = new GoodsPage(driver, product);
        mainPage.doSearchProduct(product);
        Assert.assertTrue(goodsPage.isOpenPage(), "Page with search result isn't load");
        Assert.assertTrue(goodsPage.isProductPresent(), "Product '" + product + "' doesn't find!");
        Assert.assertTrue(goodsPage.isProductHasTwoPlusValues(3), "Product '" + product + "' Havent two+ values!");
        Log4Test.info("SUCCESSFUL");
        Log4Test.info(MARKER+" Finish "+getClass().getName()+ " "+MARKER);
    }

}
