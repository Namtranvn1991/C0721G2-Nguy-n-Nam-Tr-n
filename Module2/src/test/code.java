package test;
import java.util.*;
public class code {
    public static void main(String[] args) {
        String input = "33.254.255.2";
        System.out.println(isIPv4Address(input));
        System.out.println("123");

    }

    public static boolean check (String input){
        String regex = "((\\d{1,2}|[01]\\d{1,2}|[0-2][0-4]\\d|25[0-5])\\.){3}(\\d{1,2}|[01]\\d{1,2}|[0-2][0-4]\\d|25[0-5])";
        return input.matches(regex);
    }

    public static boolean isIPv4Address (String input){
        String [] arrays = input.split("\\.");
        if (arrays.length!=4){
            return false;
        }
        boolean flag = true;
        for (String s: arrays) {
            try {
                Integer.parseInt(s);
            } catch (NumberFormatException ex) {
                return false;
            }
            int number = Integer.parseInt(s);
            if (number<0||number>255){
                flag = false;
            }
        }
        return flag;
    }

    static public boolean isStringInt(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }
}
