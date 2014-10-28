package Priject.homeTask;

/**
 * Created by boris on 28.10.14.
 */
public class CheckSubString {
    public static boolean checkSubString(String first, String second){
        int isConsist;
        if(first.length() > second.length()){
            isConsist = first.indexOf(second);
        } else
            isConsist = second.indexOf(first);
        if (isConsist != -1)
            return true;
        return false;
    }

    public static void main(String[] args) {
        System.out.print(checkSubString("Hello word", "Hello"));
    }
}
