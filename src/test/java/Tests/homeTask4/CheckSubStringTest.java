package Tests.homeTask4;

import Priject.homeTask.CheckSubString;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by boris on 28.10.14.
 */
public class CheckSubStringTest {
    private String First;
    private String Second;

    @Parameters("filePath")
    @BeforeSuite
    public void cleanFile(String filePath) throws IOException {
        FileWriter fw = new FileWriter(filePath);
        fw.write("");
        fw.close();
    }

    @DataProvider
    public Object[][] testData(){
        return new Object[][]{  {"Hello", "Hello"},
                                {"Hello", "Word"}
        };
    }

    @Test(dataProvider = "testData")
    public void checkSubString(String first, String second){
        boolean isConsist = CheckSubString.checkSubString(first, second);
        First = first;
        Second = second;
        Assert.assertTrue(isConsist);
    }

    @Parameters("filePath")
    @AfterSuite
    public void writeToFile(String filePath) throws IOException {
        FileWriter fw = new FileWriter(filePath);
        fw.write(First + " ");
        fw.write(Second);
        fw.close();
    }
}
