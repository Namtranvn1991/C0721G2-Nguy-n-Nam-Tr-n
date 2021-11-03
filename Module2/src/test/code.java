package test;

import java.lang.reflect.Array;
import java.util.Date;
import java.util.Scanner;

public class code {
    public static void main(String[] args) {
        try {
            boolean a = validate(-4);
            System.out.println(a);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }



    static boolean validate(int number) throws Exception {
        if (number<0){
            throw new Exception("123");
        }
        return true;
    }



    static String dateToString (Date date){
        String dateStr = (date.getYear() + 1900)+"-"+(date.getMonth()+1)+"-"+date.getDay();
        return dateStr;
    }
}
