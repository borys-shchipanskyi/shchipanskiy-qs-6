package Priject.homeTask5.actors;

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
        this.email = (isGenerateEmail) ? generateEmail(userInfo.get("email")) : userInfo.get("email");
        this.nicName = userInfo.get("nicName");
        this.password = userInfo.get("password");
    }

    private String generateEmail(String Email){
        String newEmail = "";
        String email = "param@gmail.com";
        String regExp = "(\\S+)(\\@\\S+)";
        Pattern pt = Pattern.compile(regExp);
        Matcher m = pt.matcher(email);
        m.find();
        newEmail = m.group(1)+genereteNumber()+m.group(2);

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
