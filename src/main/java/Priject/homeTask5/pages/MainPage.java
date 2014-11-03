package Priject.homeTask5.pages;

import Priject.homeTask5.actors.Users;
import org.openqa.selenium.WebDriver;

/**
 * Created by boris on 03.11.14.
 */
public class MainPage {
    private String url;
    private WebDriver driver;

    public MainPage(String ur, WebDriver driver) {
        this.url = url;
        this.driver = driver;
    }

    public boolean cleanHome(){

    return true;
    }

    public boolean login(Users user){
        LoginPage lp = new LoginPage(user, this.driver);
        boolean loginStatus = lp.login(user);
        return loginStatus;
    }

    public void logOut(){

    }
}
