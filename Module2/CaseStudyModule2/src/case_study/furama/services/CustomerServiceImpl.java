package case_study.furama.services;

import case_study.furama.util.PersonInput;
import case_study.furama.model.person.Customer;
import case_study.furama.util.ReadCustomerListAndWriteToCSV;

import java.util.Date;
import java.util.LinkedList;
import java.util.Scanner;

public class CustomerServiceImpl implements CustomerService {
    static final String CUSTOMER_LIST_PATH = "src\\case_study\\furama\\data\\CustomerList.csv";
    static LinkedList<Customer> customersList = ReadCustomerListAndWriteToCSV.getListCustomerFromCSV(CUSTOMER_LIST_PATH);
    static Scanner scanner = new Scanner(System.in);

    static {
//        customersList.add(new Customer("Nguyen A", new Date(91, 3, 25), true, 12345671, 80812301, "nguyena@gmail.com", 88801, Customer.DIAMOND, "Ha Noi"));
//        customersList.add(new Customer("Nguyen B", new Date(92, 11, 15), true, 12345672, 80812302, "nguyenb@gmail.com", 88802, Customer.MEMBER, "HCM"));
//        customersList.add(new Customer("Nguyen B", new Date(92, 11, 15), true, 12345333, 80812302, "nguyenb@gmail.com", 88802, Customer.MEMBER, "HCM"));
//        ReadCustomerListAndWriteToCSV.readEmployeeListAndWriteToCSV(customersList,"src\\case_study\\furama\\data\\CustomerList.csv",true);
    }

    public static void add() {
        System.out.println("Enter customer name ");
        String name = PersonInput.inputName();

        Date birthday = PersonInput.inputBirthday();
        boolean gender = PersonInput.inputGender();
        int idCardNumber = PersonInput.inputIDCardNumber();
        int phoneNumber = PersonInput.inputPhoneNumber();
        String email = PersonInput.inputEmail();

        int customerID = inputCustomerID();
        String membershipTier = inputMembershipTier();
        String address = inputAddress();

        Customer customer = new Customer(name,birthday,gender,idCardNumber,phoneNumber,email,customerID,membershipTier,address);
        customersList.add(customer);
        ReadCustomerListAndWriteToCSV.readEmployeeListAndWriteToCSV(customersList,CUSTOMER_LIST_PATH);
    }



    public static void display(){
        int count = 1;
        for (Customer customer: customersList) {
            System.out.println(count+"-"+customer);
            count++;
        }
    }

    public static void edit(){
        while (true){
            System.out.println("Enter customer number to edit. Enter alphabet char to return");
            String indexStr= scanner.nextLine();
            if(isStringInt(indexStr)){
                int index = Integer.parseInt(indexStr)-1;
                if (index<customersList.size()&&index>=0){
                    editIndex(index);
                    ReadCustomerListAndWriteToCSV.readEmployeeListAndWriteToCSV(customersList,CUSTOMER_LIST_PATH);
                } else {
                    System.out.println(indexStr+ " isnt exist. Enter again");
                }
            } else {
                return;
            }
        }
    }


    static void editIndex(int index){
        while (true){
            System.out.println("Edit " + customersList.get(index).toString()+"\n"+
                    "1.Name 2.Birthday 3.Gender 4.IDCardNumber 5.PhoneNumber 6.Email 7.CustomerID 8.MembershipTier 9.Address 0.Return");
            String choice = scanner.nextLine();
            switch (choice){
                case "1":
                    System.out.println("Enter new name");
                    customersList.get(index).setName(PersonInput.inputName());
                    customersList.get(index).toString();
                    break;
                case "2":
                    System.out.println("Enter new birthday");
                    customersList.get(index).setBirthday(PersonInput.inputBirthday());
                    customersList.get(index).toString();
                    break;
                case "3":
                    System.out.println("Enter gender");
                    customersList.get(index).setGender(PersonInput.inputGender());
                    customersList.get(index).toString();
                    break;
                case "4":
                    System.out.println("Enter new ID Card Number");
                    customersList.get(index).setIDCardNumber(PersonInput.inputIDCardNumber());
                    customersList.get(index).toString();
                    break;
                case "5":
                    System.out.println("Enter new phone number");
                    customersList.get(index).setPhoneNumber(PersonInput.inputPhoneNumber());
                    customersList.get(index).toString();
                    break;
                case "6":
                    System.out.println("Enter new email");
                    customersList.get(index).setEmail(scanner.nextLine());
                    customersList.get(index).toString();
                    break;
                case "7":
                    System.out.println("Enter new customer ID");
                    customersList.get(index).setCustomerID(inputCustomerID());
                    customersList.get(index).toString();
                    break;
                case "8":
                    System.out.println("Enter membership tier");
                    customersList.get(index).setMembershipTier(inputMembershipTier());
                    customersList.get(index).toString();
                    break;
                case "9":
                    System.out.println("Enter new address");
                    customersList.get(index).setAddress(inputAddress());
                    customersList.get(index).toString();
                    break;
                default:
                    return;
            }
        }
    }


    static int inputCustomerID() {
        while (true) {
            System.out.println("Enter Customer ID");
            String customerID = scanner.nextLine();
            if (isStringInt(customerID)) {
                return Integer.parseInt(customerID);
            } else {
                System.out.println("Enter again");
            }
        }
    }


    static String inputMembershipTier() {
        while (true) {
            System.out.println("Membership Tier. 1/ DIAMOND 2/ PLATINUM 3/ GOLD 4/ SILVER 5/ MEMBER");
            String degree = scanner.nextLine();
            switch (degree) {
                case "1":
                    return Customer.DIAMOND;
                case "2":
                    return Customer.PLATINUM;
                case "3":
                    return Customer.GOLD;
                case "4":
                    return Customer.SILVER;
                case "5":
                    return Customer.MEMBER;
                default:
                    System.out.println("Enter again");
            }
        }
    }

    static String inputAddress() {
        System.out.println("Enter address");
        String address = scanner.nextLine();
        return address;
    }


    static public boolean isStringInt(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

}
