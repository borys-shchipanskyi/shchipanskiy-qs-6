package Priject.homeTask5.pages;

import Priject.homeTask5.actors.Users;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by boris on 05.11.14.
 */
public class GoodsPage extends Page {
    public GoodsPage(Users user, WebDriver driver){
        super(user, driver);
    }

    public boolean isPresent(String product){
        try {
            driver.findElement(By.xpath("//a[contains(text(),'"+product+"')]"));
        }catch (Exception e){
            System.out.println("error in catalog clearfix");
            return false;
        }
            return true;
    }
}
