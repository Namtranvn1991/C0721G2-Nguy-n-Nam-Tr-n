package util;

import model.Customer;
import model.Test;

import java.io.*;
import java.util.Date;
import java.util.LinkedList;

public class ReadCustomerListFromCSV {
    static final String PATH = "src\\data\\CustomerList.csv";
    private static LinkedList<Customer> customers = getCustomerListFromCSV();

    public static LinkedList<Customer> getCustomers() {
        return customers;
    }

    public static LinkedList<Customer> getCustomerListFromCSV(){
        LinkedList<Customer> customers = new LinkedList<>();
        File file = new File(PATH);
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line="";
            String[] array =null;
            String[] arrayDate =null;
            while ((line=bufferedReader.readLine())!=null){
                array = line.split(",");
                String id = array[0];
                String name = array[1];
                arrayDate = array[2].split("/");
                Date date = new Date(Integer.parseInt(arrayDate[2])-1990,Integer.parseInt(arrayDate[1])-1,Integer.parseInt(arrayDate[0]));
                String gender = array[3];
                int phoneNumber = Integer.parseInt(array[4]);
                String address = array[5];
                Customer customer = new Customer(id,name,date,gender,phoneNumber,address);
                customers.add(customer);
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error");
        } catch (Exception e){
            System.out.println("File is empty");
        }
        return customers;
    }

    public static void main(String[] args) {
        for (Customer c:customers) {
            System.out.println(c);
        }
    }
}
