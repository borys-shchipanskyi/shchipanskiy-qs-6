package Tests.hotlineTesting;

import Priject.hotlineTesting.pages.GoodsPage;
import Priject.hotlineTesting.pages.MainPage;
import Priject.hotlineTesting.utils.Log4Test;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


/**
 * Created by boris on 05.11.14.
 */
public class FindProductTest extends FunctionTest{
    private GoodsPage goodsPage;

    @DataProvider
    public Object[][] testData(){
        return new Object[][] {
                new Object[] {"iPhone"}
        };
    }

    @Test(dataProvider = "testData")
    public void testFindProduct( String product){
        Log4Test.info(MARKER + " START " + getClass().getName() + " " + MARKER);
        mainPage = new MainPage(driver);
        mainPage.openPage();
        mainPage.cleanPage();
        goodsPage= new GoodsPage(driver, product);
        mainPage.doSearchProduct(product);
        Assert.assertTrue(goodsPage.isOpenPage(), "Page with search result isn't load");
        Assert.assertTrue(goodsPage.isProductPresent(), "Product '" + product + "' doesn't find!");
        Log4Test.info("SUCCSES");
        Log4Test.info(MARKER+" Finish "+getClass().getName()+ " "+MARKER);
    }

}
