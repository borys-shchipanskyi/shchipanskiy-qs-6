package Priject.homeTask5.pages;

import Priject.homeTask5.actors.Users;

/**
 * Created by boris on 03.11.14.
 */
public class RegisterPage {
    private String regEmail;
    private String regNicName;
    private String regPassword;

    public RegisterPage(Users user){
        this.regEmail = user.getEmail();
        this.regNicName = user.getNicName();
        this.regPassword = user.getPassword();
    }
    public static boolean register(){
        return true;
    }
}
