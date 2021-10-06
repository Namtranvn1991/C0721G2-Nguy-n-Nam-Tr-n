package case_study.homework2.util;

import case_study.homework2.model.Customer;
import case_study.homework2.model.CustomerType;

import java.util.LinkedList;
import java.util.Scanner;

public class CustomerInput {
    static Scanner scanner = new Scanner(System.in);
    static LinkedList<Customer> customers = ReadCustomerListAndWriteToCSV.getListFromCSV();

    public static String inputCustomerVNID() {
        while (true) {
            System.out.println("Enter CustomerVNID");
            String customerVNID = scanner.nextLine();
            boolean flag = true;
            if (validateCustomerVNID(customerVNID)) {
                for (Customer c:customers) {
                    if(c.getID().equals(customerVNID)){
                        flag= false;
                    }
                }
                if (flag){
                    return customerVNID;
                }else {
                    System.out.println("Id does exist. Enter again");
                }
            } else {
                System.out.println("Enter again");
            }
        }
    }

    public static String inputCustomerNNID() {
        while (true) {
            System.out.println("Enter CustomerNNID");
            String customerNNID = scanner.nextLine();
            boolean flag = true;
            if (validateCustomerNNID(customerNNID)) {
                for (Customer c:customers) {
                    if(c.getID().equals(customerNNID)){
                        flag= false;
                    }
                }
                if (flag){
                    return customerNNID;
                }else {
                    System.out.println("Id does exist. Enter again");
                }
            } else {
                System.out.println("Enter again");
            }
        }
    }


    public static String inputName() {
        while (true) {
            System.out.println("Enter Name");
            String name = scanner.nextLine();
            if (validateName(name)) {
                return name;
            } else {
                System.out.println("Enter again");
            }
        }
    }

    public static String inputCustomerType() {
        while (true) {
            for (CustomerType type : ReadCustomerTypeListFromCSV.getCustomerTypeList()) {
                System.out.println(type);
            }
            System.out.println("Enter Customer Type ID");
            String customerTypeID = scanner.nextLine();
            if (validateCustomerTypeID(customerTypeID)) {
                for (CustomerType type : ReadCustomerTypeListFromCSV.getCustomerTypeList()) {
                    if (type.getTypeID().equals(customerTypeID)) {
                        return customerTypeID;
                    }
                }
                System.out.println("customerTypeID if not found. Enter again");
            } else {
                System.out.println("Enter again");
            }
        }
    }

    public static int inputConsume() {
        while (true) {
            System.out.println("Enter consume");
            String consume = scanner.nextLine();
            if (isStringIntPositiveNumbers(consume)) {
                return Integer.parseInt(consume);
            } else {
                System.out.println("Enter again");
            }
        }
    }

    public static String inputCountry() {
        while (true) {
            System.out.println("Enter Country");
            String country = scanner.nextLine();
            if (validateCountry(country)) {
                return country;
            } else {
                System.out.println("Enter again");
            }
        }
    }


    public static boolean validateCustomerVNID(String customerVNID) {
        String regex = "KHVN-\\d{5}";
        return customerVNID.matches(regex);
    }

    public static boolean validateCustomerNNID(String customerNNID) {
        String regex = "KHNN-\\d{5}";
        return customerNNID.matches(regex);
    }

    public static boolean validateName(String name) {
        String regex = "^[A-Z][a-z]+\\s([A-Z][a-z]*\\s)*[A-Z][a-z]*$";
        return name.matches(regex);
    }

    public static boolean validateCustomerTypeID(String customerTypeID) {
        String regex = "LKH-\\d{3}";
        return customerTypeID.matches(regex);
    }

    public static boolean validateCountry(String country) {
        String regex = "[A-Z][A-Z]";
        return country.matches(regex);
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

}
