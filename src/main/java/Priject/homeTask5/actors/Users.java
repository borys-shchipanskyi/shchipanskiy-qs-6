package Priject.homeTask5.actors;

import java.util.HashMap;

/**
 * Created by boris on 03.11.14.
 */
public class Users {
    private String email;
    private String nicName;
    private String password;

    public Users(HashMap<String, String> userInfo){
        this.email = userInfo.get("email");
        this.nicName = userInfo.get("nicName");
        this.password = userInfo.get("password");
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
