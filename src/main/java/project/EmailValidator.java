package project;

/**
 * Created by boris on 23.10.14.
 */
public class EmailValidator {
    public static boolean emailValidator(String email){
        String regExp = "([A-z0-9-_]+[.][A-z-_]+\\@[A-z]+[\\.][A-z]+|[\\.][A-z]+)";

        return true;
    }
}
