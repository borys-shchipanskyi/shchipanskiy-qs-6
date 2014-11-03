package Priject.homeTask5.pages;

import Priject.homeTask5.actors.Users;

import static Priject.homeTask5.pages.RegisterPage.*;

/**
 * Created by boris on 03.11.14.
 */
public class LoginPage {
    private String logEmail;
    private String logPassword;

    public LoginPage(Users user){
        this.logEmail = user.getEmail();
        this.logPassword = user.getPassword();
    }

    private boolean sendLogginCommand(){

        return false;
    }

    public boolean login(Users user){
        boolean loginStatus = sendLogginCommand();
        return loginStatus;

    }


    public void loginUseVk(){

    }
    public void loginUseFb(){

    }
    public void loginUseTw(){

    }
    public void loginUseGl(){

    }

}
