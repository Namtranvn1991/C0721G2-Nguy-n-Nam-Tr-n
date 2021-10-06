package case_study.homework2.util;


import case_study.homework.model.Car;
import case_study.homework2.model.Customer;
import case_study.homework2.model.CustomerNN;
import case_study.homework2.model.CustomerVN;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;

public class ReadCustomerListAndWriteToCSV {
    static final String CUSTOMER_PATH = "src\\case_study\\homework2\\data\\Customer.csv";

    public static void writeToCSV(LinkedList<Customer> customers){
        File file = new File(CUSTOMER_PATH);
        try {
            FileWriter fileWriter = new FileWriter(file,false);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Customer customer : customers){
                bufferedWriter.write(customer.toStringToFile());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static LinkedList<Customer> getListFromCSV(){
        LinkedList<Customer> customers = new LinkedList<>();
        File file = new File(CUSTOMER_PATH);
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
                if(id.contains("VN")){
                    String type = array[2];
                    int consume = Integer.parseInt(array[3]);
                    CustomerVN customerVN = new CustomerVN(id,name,type,consume);
                    customers.add(customerVN);
                } else {
                    String country = array[2];
                    CustomerNN customerNN = new CustomerNN(id,name,country);
                    customers.add(customerNN);
                }
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error");
        } catch (Exception e){
            //do nothing
        }
        return customers;
    }
}
