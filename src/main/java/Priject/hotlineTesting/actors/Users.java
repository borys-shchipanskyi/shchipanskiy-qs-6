package Priject.hotlineTesting.actors;

import Priject.hotlineTesting.utils.Log4Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by boris on 03.11.14.
 */
public class Users {
    private String email;
    private String nicName;
    private String password;

    public Users(HashMap<String, String> userInfo, boolean isGenerateEmail){
        Log4Test.info("Creat new user");
        this.email = (isGenerateEmail) ? generateEmail(userInfo.get("email")) : userInfo.get("email");
        this.nicName = userInfo.get("nicName");
        this.password = userInfo.get("password");
    }


    private static String generateEmail(String Email){
        Log4Test.info("Start generate user's email");
        String newEmail = "";
        String email = "param@gmail.com";
        String regExp = "(\\S+)(\\@\\S+)";
        Pattern pt = Pattern.compile(regExp);
        Matcher m = pt.matcher(email);
       if(m.find()) {
           newEmail = m.group(1) + genereteNumber() + m.group(2);
       }
        Log4Test.info("Finish generate user's email");
        return newEmail;
    }
    private static String genereteNumber(){
        String num ;
        Calendar cal = Calendar.getInstance();
        cal.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("YYMMHHmmss");
        num = sdf.format(cal.getTime());
        return num;
    }

    public String getEmail() {
        return email;
    }

    public String getNicName() {
        return nicName;
    }

    public String getPassword() {
        return password;
    }
}