package Tests.homeTask5;

import Priject.homeTask5.actors.Users;
import Priject.homeTask5.pages.MainPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;

/**
 * Created by boris on 05.11.14.
 */
public class RegistrationTestNegative extends FunctionTest{

    public HashMap<String, String> userInfo(String email, String nicName, String password){
        HashMap hm = new HashMap();
        hm.put("email", email);
        hm.put("nicName", nicName);
        hm.put("password", password);
        return hm;
    }


    @Test(dataProvider = "testData")
    public void testRegistrationNegative(String strUrl, HashMap hm, boolean isGenerateEmail){
        System.out.println(strUrl);
        driver.get(strUrl);
        Users user = new Users(hm, !isGenerateEmail);
        MainPage mp = new MainPage(user, driver);
        mp.cleanHome();
        boolean loginStat = mp.login(user);
        Assert.assertFalse((!loginStat) ? mp.register(user) : false, (!loginStat) ? ERROR_MSG1 : ERROR_MSG2);
    }

}
