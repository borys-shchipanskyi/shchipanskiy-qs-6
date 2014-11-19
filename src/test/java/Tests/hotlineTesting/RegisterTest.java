package Tests.hotlineTesting;

import Project.hotlineTesting.actors.Users;
import Project.hotlineTesting.pages.MainPage;
import Project.hotlineTesting.pages.RegistrationPage;
import Project.hotlineTesting.utils.Log4Test;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;

/**
 * Created by boris on 03.11.14.
 */
public class RegisterTest extends FunctionTest{
    private  RegistrationPage registrationPage;
    private  Users user;

    @DataProvider
    public Object[][] testData(){
        return new Object[][] {
                new Object[] {userInfo("param@gmail.com",  "test", "test"), true}
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
    public void testRegistration(HashMap userInfoHashMap, boolean isGenerateEmail){
        Log4Test.start(getClass().getName());
        mainPage = new MainPage(driver);
        user = new Users(userInfoHashMap, isGenerateEmail);
        mainPage.openPage();
        mainPage.cleanPage();
        registrationPage = new RegistrationPage(user, driver);
        mainPage.goToRegistration();
        Assert.assertTrue(registrationPage.fillRegistrationForm(), "cannot fill registration form");
        Assert.assertTrue(registrationPage.isRegistrationSuccess(), "registration fail!");
        Log4Test.end(getClass().getName());

    }
}

