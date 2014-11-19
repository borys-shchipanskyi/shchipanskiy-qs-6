package Tests.hotlineTesting;

import Project.hotlineTesting.pages.GoodsPage;
import Project.hotlineTesting.pages.MainPage;
import Project.hotlineTesting.utils.Log4Test;
import Project.hotlineTesting.utils.ScreenShotMaker;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by boris on 19.11.14.
 */
public class ScreenshotTest extends FunctionTest {
    private GoodsPage goodsPage;

    @DataProvider
    public Object[][] testData(){
        return new Object[][] {
                new Object[] {"Nexux"}
        };
    }

    @Test(dataProvider = "testData")
    public void testFindProductNegative(String product){
        Log4Test.start(getClass().getName());
        mainPage = new MainPage(driver);
        mainPage.openPage();
        mainPage.cleanPage();
        goodsPage= new GoodsPage(driver, product);
        mainPage.doSearchProduct(product);
        Assert.assertTrue(goodsPage.isProductPresent(), "Can find  product '" + product + "'!");
        Log4Test.info("SUCCESSFUL");
        Log4Test.end(getClass().getName());
    }
    @AfterMethod
    public void tearDown(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            System.out.println("it is work!!!");
            ScreenShotMaker scrnMaker = new ScreenShotMaker(driver);
            scrnMaker.takeScreenShot("fail_"+getClass().getName());
        }
    }
}
