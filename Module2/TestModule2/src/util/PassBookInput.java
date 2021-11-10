package util;

import model.*;
import service.ShortTermPBService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.Scanner;

public class PassBookInput {
    static Scanner scanner = new Scanner(System.in);
    public static LinkedList<LongTermPB> longTermPBList = ReadLongTermListAndWriteToCSV.getLongTermListFromCSV();
    static LinkedList<PassBook> shortTermList = ShortTermPBService.getShortTermList();

    public static String bookID() {
        while (true) {
            System.out.println("Enter bookID");
            String bookID = scanner.nextLine();
            if (validateName(bookID)) {
                boolean flag = true;
                for (LongTermPB longTermPB : longTermPBList) {
                    if (bookID.equals(longTermPB.getBookID())) {
                        flag = false;
                    }
                }
                if (flag) {
                    return bookID;
                } else {
                    System.out.println(bookID + " does exist");
                }

            } else {
                System.out.println("Wrong format. Enter again");
            }
        }
    }

    public static String bookIDShort() {
        while (true) {
            System.out.println("Enter bookID");
            String bookID = scanner.nextLine();
            if (validateName(bookID)) {
                boolean flag = true;
                for (PassBook passBook : shortTermList) {
                    if (bookID.equals(passBook.getBookID())) {
                        flag = false;
                    }
                }
                if (flag) {
                    return bookID;
                } else {
                    System.out.println(bookID + " does exist");
                }

            } else {
                System.out.println("Wrong format. Enter again");
            }
        }
    }


    public static Customer inputCustomer() {
        while (true) {
            LinkedList<Customer> customers = ReadCustomerListFromCSV.getCustomerListFromCSV();
            for (Customer c : customers) {
                System.out.println(c);
            }
            System.out.println("Enter customer ID");
            String id = scanner.nextLine();
            for (Customer c : customers) {
                if (id.equals(c.getId())) {
                    return c;
                }
            }
            System.out.println(id + " doesnt exist. Enter again");
        }
    }

    public static Date inputOpenDay() {
        while (true) {
            System.out.println("Enter OpenDay (dd/MM/yyyy) ");
            String openDay = scanner.nextLine();
            if (validateJavaDate(openDay)) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
                try {
                    return simpleDateFormat.parse(openDay);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("Please enter OpenDay again");
            }
        }
    }

    public static Date inputBeginDay() {
        while (true) {
            System.out.println("Enter BeginDay (dd/MM/yyyy) ");
            String beginDay = scanner.nextLine();
            if (validateJavaDate(beginDay)) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
                try {
                    return simpleDateFormat.parse(beginDay);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("Please enter BeginDay again");
            }
        }
    }

    public static String inputGoodwill() {
        System.out.println("Enter goodwill");
        return scanner.nextLine();
    }

    public static int inputBalance() {
        while (true) {
            System.out.println("Enter Balance");
            String balance = scanner.nextLine();
            if (validateBalance(balance)) {
                int balanceInt = Integer.parseInt(balance);
                return balanceInt;
            } else {
                System.out.println("Enter again");
            }
        }
    }

    public static int inputInterestRate() {
        while (true) {
            System.out.println("Enter interest Rate");
            String interestRate = scanner.nextLine();
            if (validateInterestRate(interestRate)) {
                int interestRateInt = Integer.parseInt(interestRate);
                return interestRateInt;
            } else {
                System.out.println("Enter again");
            }
        }
    }

    public static String inputTerm() {
        while (true) {
            System.out.println("1/1 nam. 2/3 nam. 3/ 5 nam. 4/10 nam.");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    return LongTermPB.ONE_YEAR;
                case "2":
                    return LongTermPB.THREE_YEAR;
                case "3":
                    return LongTermPB.FIVE_YEAR;
                case "4":
                    return LongTermPB.TEN_YEAR;
                default:
                    System.out.println("Enter again");
                    break;
            }
        }
    }

    public static String inputShortTerm() {
        while (true) {
            System.out.println("1/3 thang. 2/6 thang");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    return ShortTermLimitPB.THREE_MONTH;
                case "2":
                    return ShortTermLimitPB.SIX_MONTH;
                default:
                    System.out.println("Enter again");
                    break;
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
                System.out.println(strDate + " is valid date format");
            } catch (ParseException e) {
                System.out.println(strDate + " is Invalid Date format");
                return false;
            }
            return true;
        }
    }


    static public boolean validateInterestRate(String s) {
        try {
            int interestRate = Integer.parseInt(s);
            if (interestRate <= 0) {
                System.out.println("Lai xuat la so duong");
                return false;
            } else {
                return true;
            }
        } catch (NumberFormatException ex) {
            return false;
        }
    }


    static public boolean validateBalance(String s) {
        try {
            int balance = Integer.parseInt(s);
            if (balance < 1000000) {
                System.out.println("Tien goi lon hon 1tr");
                return false;
            } else {
                return true;
            }
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    public static boolean validateName(String bookID) {
        String regex = "STK-\\d{4}";
        return bookID.matches(regex);
    }


}
