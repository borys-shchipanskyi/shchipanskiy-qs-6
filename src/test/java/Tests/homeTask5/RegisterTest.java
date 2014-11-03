package Tests.homeTask5;

import Priject.homeTask5.actors.Users;
import Priject.homeTask5.pages.MainPage;
import Priject.homeTask5.pages.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;

/**
 * Created by boris on 03.11.14.
 */
public class RegisterTest {

    @DataProvider
    public Object[][] testData(){
        HashMap hm = new HashMap();
        hm.put("email", "param@gmail.com");
        hm.put("nicName", "test");
        hm.put("password", "test");
        Object[][] obj = {{"http://http://hotline.ua/", hm}};
        return obj;
    }

    @Test(dataProvider = "testData")
    public void testRegistration(String strUrl, HashMap hm){
        Users user = new Users(hm);
        MainPage mp = new MainPage(strUrl);
        boolean loginStatus =  mp.login(user);

        if (!loginStatus){
            Assert.assertEquals(RegisterPage.register(), true);
        }
        else Assert.assertFalse(loginStatus);
    }
}
