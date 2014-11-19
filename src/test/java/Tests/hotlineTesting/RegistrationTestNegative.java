package Tests.hotlineTesting;

import Priject.hotlineTesting.actors.Users;
import Priject.hotlineTesting.pages.MainPage;
import Priject.hotlineTesting.pages.RegistrationPage;
import Priject.hotlineTesting.utils.Log4Test;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;

/**
 * Created by boris on 05.11.14.
 */
public class RegistrationTestNegative extends FunctionTest{
    private RegistrationPage registrationPage;
    private  Users user;

    @DataProvider
    public Object[][] testData(){
        return new Object[][] {
                new Object[] {userInfo("param@gmail.com",  "test", "test"), false},
        };
    }
    public HashMap<String, String> userInfo(String email, String nicName, String password){
        HashMap userInfoHashMap = new HashMap();
        userInfoHashMap.put("email", email);
        userInfoHashMap.put("nicName", nicName);
        userInfoHashMap.put("password", password);
        return userInfoHashMap;
    }


    @Test(dataProvider = "testData")
    public void testRegistrationNegative(HashMap userInfoHashMap, boolean isGenerateEmail){
        Log4Test.info(MARKER+" START "+getClass().getName()+ " "+MARKER);
        user = new Users(userInfoHashMap, isGenerateEmail);
        mainPage = new MainPage(driver);
        mainPage.openPage();
        mainPage.cleanPage();
        registrationPage = new RegistrationPage(user, driver);
        mainPage.goToRegistration();
        Assert.assertTrue(registrationPage.fillRegistrationForm(), "cannot fill registration form");
        Assert.assertFalse(registrationPage.isRegistrationSuccses(), "registration fail!");
        Log4Test.info(MARKER+" Finish "+getClass().getName()+ " "+MARKER);
    }

}
