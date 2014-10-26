package simple;


import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import project.EmailValidator;

/**
 * Created by boris on 24.10.14.
 */
public class EmailTest {


    @Test
    @Parameters("email")
    public void EmailTest(String email) {
        boolean isEmail = EmailValidator.isValid(email);

        Assert.assertEquals(true, isEmail);
        Assert.assertEquals(false, !isEmail);
    }
}


