package simple;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by bionic on 10/22/14.
 */
public class FirstTest {

    @Test
    public void firstTest() {
        System.out.println("Hello");
        Assert.assertTrue(true);
    }
}
