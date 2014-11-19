package Project.hotlineTesting.pages;

import Project.hotlineTesting.selenium.WebDriverWrapper;
import Project.hotlineTesting.utils.Log4Test;
import org.openqa.selenium.By;

/**
 * Created by boris on 04.11.14.
 */
public abstract class Page {
    private String PAGE;

    public By PAGE_ATTRIBUTE;

    public WebDriverWrapper driver;

    public Page(WebDriverWrapper dr, String page){
        driver = dr;
        PAGE = page;
    }

    public Page(WebDriverWrapper dr, By pageAtribute){
        driver = dr;
        PAGE_ATTRIBUTE = pageAtribute;
    }
    public Page(WebDriverWrapper dr){
        driver = dr;
    }

    public boolean openPage(){
        try{
            Log4Test.info("Start open page.");
            driver.get(PAGE);
        } catch (Exception e){
            Log4Test.error("Error in open page.");
            return false;
        }
        Log4Test.info("Page open successful.");
        return true;
    }

    public boolean isOpenPage(){
        try{
            Log4Test.info("PAGE: Check is page open. " + PAGE_ATTRIBUTE);
            sleep(5);
            driver.findElement(PAGE_ATTRIBUTE).isDisplayed();
        } catch (Exception e){
            Log4Test.error("PAGE: Error with check page.");
            return false;
        }
        Log4Test.info("PAGE: Page is open.");
        return true;
    }

    public void sleep(int sec){
        try {
            Log4Test.info("Sleap "+sec+" sec.");
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}