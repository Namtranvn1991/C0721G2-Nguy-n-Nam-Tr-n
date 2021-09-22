package case_study.furama.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class PersonInput {
    static Scanner scanner = new Scanner(System.in);

    public static String inputName() {
        System.out.println("Enter Name");
        String name = scanner.nextLine();
        return name;
    }

    public static String inputEmail() {
        System.out.println("Enter email");
        String email = scanner.nextLine();
        return email;
    }


    public static Date inputBirthday() {
        while (true) {
            System.out.println("Enter birthday (dd/MM/yyyy) ");
            String birthday = scanner.nextLine();
            if (validateJavaDate(birthday)) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
                try {
                    return simpleDateFormat.parse(birthday);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("Please enter birthday again");
            }
        }
    }

    public static boolean inputGender() {
        while (true) {
            System.out.println("Gender. 1/male 2/female");
            String gender = scanner.nextLine();
            switch (gender) {
                case "1":
                    return true;
                case "2":
                    return false;
                default:
                    System.out.println("Enter gender again");
            }
        }
    }

    public static int inputIDCardNumber() {
        while (true) {
            System.out.println("Enter ID Card Number");
            String iDCardNumber = scanner.nextLine();
            if (isStringInt(iDCardNumber)) {
                return Integer.parseInt(iDCardNumber);
            } else {
                System.out.println("Enter again");
            }
        }
    }

    public static int inputPhoneNumber() {
        while (true) {
            System.out.println("Enter Phone Number");
            String phoneNumber = scanner.nextLine();
            if (isStringInt(phoneNumber)) {
                return Integer.parseInt(phoneNumber);
            } else {
                System.out.println("Enter again");
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
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
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
}
