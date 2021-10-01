package test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

public class DateTest {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date javaDate = simpleDateFormat.parse("4/9/2021");
            date = javaDate;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Date date1 = new Date(121,8,5);
        System.out.println(date);
        System.out.println(date1);
        System.out.println(date.getYear());
        System.out.println(LocalDate.now().getYear());


    }



    public static boolean validateJavaDate(String strDate) {
        if (strDate.trim().equals("")) {
            return false;
        } else {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
            simpleDateFormat.setLenient(false);
            try {
                Date javaDate = simpleDateFormat.parse(strDate);
                int yearOld = LocalDate.now().getYear()-javaDate.getYear()-1900;
                System.out.println(yearOld);
                if (yearOld>17&&yearOld<100) {
                    System.out.println(strDate + " is valid date format");
                } else {
                    System.out.println(strDate + " is Invalid Date format");
                    return false;
                }
            } catch (ParseException e) {
                System.out.println(strDate + " is Invalid Date format");
                return false;
            }
            return true;
        }
    }
}
