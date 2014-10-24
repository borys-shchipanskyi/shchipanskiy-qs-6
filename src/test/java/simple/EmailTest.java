package simple;


import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import project.EmailValidator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;


/**
 * Created by boris on 24.10.14.
 */
public class EmailTest {
    @Test
    @Parameters("myName")
    public void EmailTest(String myName) throws FileNotFoundException {
        FileReader fr = new FileReader(myName);
        Scanner scanFile = new Scanner(fr);

        for (;scanFile.hasNextLine();){
            boolean isEmail = EmailValidator.emailValidator(scanFile.nextLine());
            Assert.assertTrue(isEmail);
        }


    }
}
