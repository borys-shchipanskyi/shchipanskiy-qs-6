package Tests.hotlineTesting;

import Priject.hotlineTesting.actors.Users;
import Priject.hotlineTesting.pages.RegisterPage;
import Priject.hotlineTesting.utils.Log4Test;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;

/**
 * Created by boris on 03.11.14.
 */
public class RegisterTest extends FunctionTest{

    @DataProvider
    public Object[][] testData(){
        return new Object[][] {
                new Object[] {userInfo("param@gmail.com",  "test", "test"), true}
        };
    }
    public HashMap<String, String> userInfo(String email, String nicName, String password){
        HashMap hm = new HashMap();
        //what is hm.
        hm.put("email", email);
        hm.put("nicName", nicName);
        hm.put("password", password);
        return hm;
    }

    @Test(dataProvider = "testData")
    public void testRegistration(HashMap hm, boolean isGenerateEmail){
        Log4Test.info(MARKER+" START "+getClass().getName()+ " "+MARKER);
       /* Users user = new Users(hm, isGenerateEmail);
        RegisterPage rp = new RegisterPage(user, driver);
        // call class normally
        rp.openPage();
        rp.fillRegistrationForm();
        Assert.assertTrue(rp.isRegiststrationSuccses());
        Log4Test.info("SUCCSES");
       */ Log4Test.info(MARKER+" Finish "+getClass().getName()+ " "+MARKER);

    }
}

