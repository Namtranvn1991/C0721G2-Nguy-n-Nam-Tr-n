package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

public class Input {
    static Scanner scanner = new Scanner(System.in);

    public static String inputName() {
        while (true){
            System.out.println("Enter Name");
            String name = scanner.nextLine();
            if(validateName(name)){
                return name;
            }else {
                System.out.println("Wrong format. Enter again");
            }
        }
    }


    public static boolean validateEmail(String email) {
        String regex = "^[A-Za-z]+\\w*@\\w+(\\.[A-Za-z0-9]+){1,2}$";
        return email.matches(regex);
    }

    public static boolean validateName(String name) {
        String regex = "^[A-Z][a-z]+\\s([A-Z][a-z]*\\s)*[A-Z][a-z]*$";
        return name.matches(regex);
    }


    static public boolean isStringInt(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    static public boolean isStringIntPositiveNumbers(String s) {
        try {
            if (Integer.parseInt(s) > 0) {
                return true;
            } else {
                return false;
            }
        } catch (NumberFormatException ex) {
            return false;
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
                System.out.println(strDate + " is valid date format");
            } catch (ParseException e) {
                System.out.println(strDate + " is Invalid Date format");
                return false;
            }
            return true;
        }
    }

    public static boolean validateJavaDateBetween(String strDate) {
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
                    System.out.println(strDate + " is valid date");
                } else {
                    System.out.println("Age must be between 18 and 100");
                    return false;
                }
            } catch (ParseException e) {
                System.out.println(strDate + " is Invalid Date format");
                return false;
            }
            return true;
        }
    }

    public static boolean validateJavaDateAfterNow(String strDate) {
        if (strDate.trim().equals("")) {
            return false;
        } else {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
            simpleDateFormat.setLenient(false);
            try {
                Date javaDate = simpleDateFormat.parse(strDate);
                LocalDate localDate = LocalDate.now();
                Date now = java.sql.Date.valueOf(localDate);
                if (javaDate.compareTo(now) < 0) {
                    System.out.println("today: " + localDate);
                    return false;
                }
                System.out.println(strDate + " is valid date format");
            } catch (ParseException e) {
                System.out.println(strDate + " is Invalid Date format");
                return false;
            }
            return true;
        }
    }
}
