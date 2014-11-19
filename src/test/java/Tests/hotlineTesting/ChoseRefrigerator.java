package Tests.hotlineTesting;

import Project.hotlineTesting.pages.GoodsPage;
import Project.hotlineTesting.pages.MainPage;
import Project.hotlineTesting.utils.Log4Test;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by boris on 11.11.14.
 */
public class ChoseRefrigerator extends FunctionTest {
    private GoodsPage goodsPage;

    @DataProvider
    public Object[][] testData(){
        return new Object[][] {
                new Object[] {"LG", "возрастанию цены"}
        };
    }

    @Test(dataProvider = "testData")
    public void testComparePrice(String company, String filterPrice) {
        Log4Test.start( getClass().getName());
        mainPage = new MainPage(driver);
        mainPage.openPage();
        mainPage.cleanPage();
        goodsPage= new GoodsPage(driver, company, filterPrice);
        Assert.assertTrue(mainPage.goToRefrigerators(), "Cannot go to Refrigerators!");
        Assert.assertTrue(goodsPage.setCompanyFilters(), "Cannot  set filters for test!");
        Assert.assertTrue(goodsPage.isProductHasTwoPlusValues(0), "product don't sort!");
        Log4Test.end(getClass().getName());
    }
}
