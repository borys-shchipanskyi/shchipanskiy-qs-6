package Priject.homeTask5.pages;

import Priject.homeTask5.actors.Users;

/**
 * Created by boris on 03.11.14.
 */
public class MainPage {
    private String url;

    public MainPage(String url) {
        this.url = url;
    }

    public static boolean login(Users user){
        LoginPage lp = new LoginPage(user);
        boolean loginStatus = lp.login(user);
        return loginStatus;
    }

    public void logOut(){

    }
}
