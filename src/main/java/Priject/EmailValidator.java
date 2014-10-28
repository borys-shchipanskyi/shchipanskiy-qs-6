package Priject;

/**
 * Created by boris on 28.10.14.
 */
public class EmailValidator {
    public static boolean  isValid(final String email) {
        String regExp = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"; ;
        return email.matches(regExp);
    }

}
