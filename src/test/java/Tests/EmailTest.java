package Tests;

import Priject.EmailValidator;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by boris on 28.10.14.
 */
public class EmailTest {

    @Test
    public void EmailTest(){
        boolean isEmail = EmailValidator.isValid("test@gmail.com");

        Assert.assertTrue(isEmail);
    }
}
