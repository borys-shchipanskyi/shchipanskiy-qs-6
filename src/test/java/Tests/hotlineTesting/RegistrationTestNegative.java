package Tests.hotlineTesting;

import Priject.hotlineTesting.actors.Users;
import Priject.hotlineTesting.pages.RegisterPage;
import Priject.hotlineTesting.utils.Log4Test;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;

/**
 * Created by boris on 05.11.14.
 */
public class RegistrationTestNegative extends FunctionTest{

    @DataProvider
    public Object[][] testData(){
        return new Object[][] {
                new Object[] {userInfo("param@gmail.com",  "test", "test"), true}
                // Why it is static data.
                // it should check new data every time
        };
    }
    public HashMap<String, String> userInfo(String email, String nicName, String password){
        HashMap hm = new HashMap();
        hm.put("email", email);
        hm.put("nicName", nicName);
        hm.put("password", password);
        return hm;
    }


    @Test(dataProvider = "testData")
    public void testRegistrationNegative(HashMap hm, boolean isGenerateEmail){
        Log4Test.info(MARKER+" START "+getClass().getName()+ " "+MARKER);
        Users user = new Users(hm, !isGenerateEmail);
        //very dificult logic with new user
        RegisterPage rp = new RegisterPage(user, driver);
        rp.openPage();
        rp.fillRegistrationForm();
        Assert.assertFalse(rp.isRegiststrationSuccses());
        Log4Test.info("SUCCSES");
        Log4Test.info(MARKER+" Finish "+getClass().getName()+ " "+MARKER);
    }

}
