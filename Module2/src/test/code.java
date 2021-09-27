package test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

public class code {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        while (true){
            String date = scanner.nextLine();
            if (validateJavaDate(date)){
                return;
            }else {
                System.out.println("123");
            }
        }





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
