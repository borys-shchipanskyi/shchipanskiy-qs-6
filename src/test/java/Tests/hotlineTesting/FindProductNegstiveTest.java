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
public class FindProductNegstiveTest extends FunctionTest{
    private GoodsPage goodsPage;

    @DataProvider
    public Object[][] testData(){
        return new Object[][] {
                new Object[] {"Nexux"}
        };
    }

    @Test(dataProvider = "testData")
    public void testFindProductNegative(String product){
        Log4Test.start( getClass().getName());
        mainPage = new MainPage(driver);
        mainPage.openPage();
        mainPage.cleanPage();
        goodsPage= new GoodsPage(driver, product);
        mainPage.doSearchProduct(product);
        Assert.assertFalse(goodsPage.isProductPresent(), "Can find  product '" + product + "'!");
        Log4Test.info("SUCCESSFUL");
        Log4Test.end(getClass().getName());

    }

}
