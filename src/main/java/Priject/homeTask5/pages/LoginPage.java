package Priject.homeTask5.pages;

import Priject.homeTask5.actors.Users;
import org.openqa.selenium.WebDriver;

import static Priject.homeTask5.pages.RegisterPage.*;

/**
 * Created by boris on 03.11.14.
 */
public class LoginPage {
    private String logEmail;
    private String logPassword;
    private WebDriver driver;

    public LoginPage(Users user, WebDriver driver){
        this.logEmail = user.getEmail();
        this.logPassword = user.getPassword();
        this.driver = driver;
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
