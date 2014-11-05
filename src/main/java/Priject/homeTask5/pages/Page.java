package Priject.homeTask5.pages;

import Priject.homeTask5.actors.Users;
import org.openqa.selenium.WebDriver;

/**
 * Created by boris on 04.11.14.
 */
public class Page {
    public String logEmail;
    public String logPassword;
    public String nicName;
    public WebDriver driver;

    public final String HOME_URL;
    public String SELECTOR_LOGIN_PAGE = "/user/log_in/";
    public String SELECTOR_BLUE_BUTTON_CLASS = "blue-button";
    public String SELECTOR_EMAIL_FILD = "login";
    public String SELECTOR_PASSWORD_FILD = "password";
    public String SELECTOR_REG_CLASS = "reg";
    public String SELECTOR_ENTER_ERROR_CLASS = "error";
    public String SELECTOR_CLOSE_CLASS = "close";
    public String SELECTOR_CITY_CLASS = "a.blue-button.success";
    public String SELECTOR_T_IMG_CLASS = "lightbox-form";
    public String SELECTOR_REG_SUCCSES_CLASS = "registr-successful";


    public Page(Users user, WebDriver driver){
        this.logEmail = user.getEmail();
        this.logPassword = user.getPassword();
        this.nicName = user.getNicName();
        this.driver = driver;
        this.HOME_URL = driver.getCurrentUrl();
    }
}
