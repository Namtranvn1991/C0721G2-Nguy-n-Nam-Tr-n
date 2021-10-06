package case_study.homework2.service;

import case_study.homework2.model.Customer;
import case_study.homework2.model.CustomerNN;
import case_study.homework2.model.CustomerVN;
import case_study.homework2.util.CustomerInput;
import case_study.homework2.util.ReadCustomerListAndWriteToCSV;

import java.util.LinkedList;
import java.util.Scanner;

public class CustomerService {
    static LinkedList<Customer> customers = ReadCustomerListAndWriteToCSV.getListFromCSV();
    static Scanner scanner = new Scanner(System.in);

    static public void addCustomerVN() {
        String iD = CustomerInput.inputCustomerVNID();
        String name = CustomerInput.inputName();
        String type = CustomerInput.inputCustomerType();
        int consume = CustomerInput.inputConsume();
        CustomerVN customerVN = new CustomerVN(iD, name, type, consume);
        customers.add(customerVN);
        ReadCustomerListAndWriteToCSV.writeToCSV(customers);
    }

    static public void addCustomerNN() {
        String iD = CustomerInput.inputCustomerNNID();
        String name = CustomerInput.inputName();
        String country = CustomerInput.inputCountry();
        CustomerNN customerNN = new CustomerNN(iD, name, country);
        customers.add(customerNN);
        ReadCustomerListAndWriteToCSV.writeToCSV(customers);
    }

    static public void display (){
        for (Customer c:customers) {
            System.out.println(c);
        }
    }


    static public void search(){
        System.out.println("Enter name");
        String name = scanner.nextLine();
        boolean flag = false;
        for (Customer c:customers) {
            if (c.getName().equalsIgnoreCase(name)||c.getName().contains(name)){
                System.out.println(c);
                flag = true;
            }
        }
        if(flag){
            return;
        } else {
            System.out.println("Customer is not found");
        }
    }

}
