package case_study.furama.util;


import case_study.furama.model.person.Customer;
import case_study.furama.model.person.Employee;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;

public class ReadCustomerListAndWriteToCSV {
    public static void readEmployeeListAndWriteToCSV(LinkedList<Customer> customersList, String pathFile){
        File file = new File(pathFile);
        try {
            FileWriter fileWriter = new FileWriter(file,false);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Customer customer : customersList){
                bufferedWriter.write(customer.toStringToFile());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void clear(String pathFile){
        File file = new File(pathFile);
        try {
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write("");
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static LinkedList<Customer> getListCustomerFromCSV(String pathFile){
        LinkedList<Customer> customersList = new LinkedList<>();
        File file = new File(pathFile);
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line="";
            String[] array =null;
            String[] arrayDate =null;
            while ((line=bufferedReader.readLine())!=null){
                array = line.split(",");
                String name = array[0];
                arrayDate = array[1].split("/");
                Date date = new Date(Integer.parseInt(arrayDate[2])-1990,Integer.parseInt(arrayDate[1])-1,Integer.parseInt(arrayDate[0]));
                boolean gender= true;
                if (array[2].equals("Male")){
                    gender = true;
                } else {
                    gender =false;
                }
                int iDCardNumber = Integer.parseInt(array[3]);
                int phoneNumber = Integer.parseInt(array[4]);
                String email = array[5];
                int customerID = Integer.parseInt(array[6]);
                String membershipTier = array[7];
                String address = array[8];

                Customer customer = new Customer(name,date,gender,iDCardNumber,phoneNumber,email,customerID,membershipTier,address);
                customersList.add(customer);
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error");
        }
        return customersList;
    }
}
