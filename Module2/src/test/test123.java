package test;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.w3c.dom.ls.LSOutput;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

class UseMapCountElement {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws ParseException {
        Date date = new Date(91,5,22);
        Date date1 = new Date(91,4,22);
        System.out.println(date1.compareTo(date));
        System.out.println(date);
        System.out.println(date.getYear());
        System.out.println(date.getMonth());
        System.out.println(date.getDate());
        System.out.println(date1);
        System.out.println(date1.getYear());
        System.out.println(date1.getMonth());
        System.out.println(date1.getDate());


    }


    static Date inputBirthday() throws ParseException {
        while (true){
            System.out.println("Enter birthday (dd/MM/yyyy) ");
            String birthdayStr = scanner.nextLine();
            if (validateJavaDate(birthdayStr)){
                SimpleDateFormat sdfrmt = new SimpleDateFormat("dd/MM/yyyy");
                Date birthday = sdfrmt.parse(birthdayStr);
                return birthday;
            }else {
                System.out.println("Please enter birthday again");
                inputBirthday();
            }
        }
    }

    static public boolean isStringInt(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    public static boolean validateJavaDate(String strDate) {
        if (strDate.trim().equals("")) {
            return false;
        } else {
            SimpleDateFormat sdfrmt = new SimpleDateFormat("dd/MM/yyyy");
            sdfrmt.setLenient(false);
            try {
                Date javaDate = sdfrmt.parse(strDate);
                System.out.println(strDate + " is valid date format");
            } catch (ParseException e) {
                System.out.println(strDate + " is Invalid Date format");
                return false;
            }
            return true;
        }
    }


}

