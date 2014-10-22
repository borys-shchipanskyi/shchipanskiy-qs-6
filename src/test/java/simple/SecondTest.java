package simple;

import org.testng.Assert;
import org.testng.annotations.Test;
import project.Sum;

/**
 * Created by bionic on 10/22/14.
 */
public class SecondTest {

    @Test
    public void Test(){
        int a = 4;
        int b = 5;
        Sum s = new Sum();
        Assert.assertTrue(a + b == s.sum(a,b));

    }


}
