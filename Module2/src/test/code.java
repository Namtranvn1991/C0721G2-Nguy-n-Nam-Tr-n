package test;

import java.lang.reflect.Array;
import java.util.Date;
import java.util.Scanner;

public class code {
    public static void main(String[] args) {
        Date date = new Date(99,2,8);
        System.out.println(dateToString(date));
        System.out.println(date.toString());

    }


    static String dateToString (Date date){
        String dateStr = (date.getYear() + 1900)+"-"+(date.getMonth()+1)+"-"+date.getDay();
        return dateStr;
    }
}
