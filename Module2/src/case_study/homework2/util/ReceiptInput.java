package case_study.homework2.util;

import case_study.homework2.model.Customer;
import case_study.homework2.model.Receipt;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.Scanner;

public class ReceiptInput {
    static LinkedList<Receipt> receipts = ReadReceiptListAndWriteToCSV.getListFromCSV();
    static LinkedList<Customer> customers = ReadCustomerListAndWriteToCSV.getListFromCSV();
    static Scanner scanner = new Scanner(System.in);

    public static String inputReceiptID(){
        while (true) {
            System.out.println("Enter Receipt ID");
            String receiptID = scanner.nextLine();
            boolean flag = true;
            if (validateReceiptID(receiptID)) {
                for (Receipt receipt:receipts) {
                    if(receipt.getReceiptID().equals(receiptID)){
                        flag= false;
                    }
                }
                if (flag){
                    return receiptID;
                }else {
                    System.out.println("Id does exist. Enter again");
                }
            } else {
                System.out.println("Enter again");
            }
        }
    }

    public static Customer inputCustomer(){
        while (true){
            for (Customer customer: customers) {
                System.out.println(customer);
            }
            System.out.println("Enter Customer ID");
            String customerID = scanner.nextLine();
            if (validateCustomerID(customerID)){
                for (Customer customer: customers) {
                    if(customer.getID().equals(customerID)){
                        return customer;
                    }
                }
                System.out.println("Customer ID doesnt exist. Enter again");
            } else {
                System.out.println("Enter again");
            }
        }
    }


    public static Date inputDate() {
        while (true) {
            System.out.println("Enter Receipt Date (dd/MM/yyyy) ");
            String checkoutDate = scanner.nextLine();
            if (validateJavaDate(checkoutDate)) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
                try {
                    return simpleDateFormat.parse(checkoutDate);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("Please enter Receipt Date again");
            }
        }
    }


    public static int inputQuantity() {
        while (true) {
            System.out.println("Enter Quantity");
            String quantity = scanner.nextLine();
            if (isStringIntPositiveNumbers(quantity)) {
                return Integer.parseInt(quantity);
            } else {
                System.out.println("Enter again");
            }
        }
    }


    public static int inputUnitPrice() {
        while (true) {
            System.out.println("Enter unit Price");
            String unitPrice = scanner.nextLine();
            if (isStringIntPositiveNumbers(unitPrice)) {
                return Integer.parseInt(unitPrice);
            } else {
                System.out.println("Enter again");
            }
        }
    }




    public static boolean validateReceiptID(String receiptID) {
        String regex = "MHD-\\d{3}";
        return receiptID.matches(regex);
    }

    public static boolean validateCustomerID(String customerVNID) {
        String regex = "KH[VN]N-\\d{5}";
        return customerVNID.matches(regex);
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
}
