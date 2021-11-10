package util;

import model.Customer;
import model.LongTermPB;
import model.Test;

import java.io.*;
import java.util.Date;
import java.util.LinkedList;

public class ReadLongTermListAndWriteToCSV {
    static final String PATH = "src\\data\\LongTermList.csv";
    private static LinkedList<Customer> customers = ReadCustomerListFromCSV.getCustomers();

    public static void writeToCSV(LinkedList<LongTermPB> tests){
        File file = new File(PATH);
        try {
            FileWriter fileWriter = new FileWriter(file,false);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (LongTermPB longTermPB : tests){
                bufferedWriter.write(longTermPB.toStringToFile());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static LinkedList<LongTermPB> getLongTermListFromCSV(){
        LinkedList<LongTermPB> longTermPBS = new LinkedList<>();
        File file = new File(PATH);
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line="";
            String[] array =null;
            String[] arrayDate =null;
            Customer customer = null;
            while ((line=bufferedReader.readLine())!=null){
                array = line.split(",");
                String id = array[0];
                String customerID = array[1];
                for (Customer c:customers) {
                    if(customerID.equals(c.getId())){
                        customer = c;
                    }
                }
                arrayDate = array[2].split("/");
                Date openDate = new Date(Integer.parseInt(arrayDate[2])-1990,Integer.parseInt(arrayDate[1])-1,Integer.parseInt(arrayDate[0]));
                arrayDate = array[3].split("/");
                Date beginDate = new Date(Integer.parseInt(arrayDate[2])-1990,Integer.parseInt(arrayDate[1])-1,Integer.parseInt(arrayDate[0]));
                int balance = Integer.parseInt(array[4]);
                int interestRate = Integer.parseInt(array[5]);
                String term = array[6];
                String goodwill= array[7];
                LongTermPB longTermPB = new LongTermPB(id,customer,openDate,beginDate,balance,interestRate,term,goodwill);

                longTermPBS.add(longTermPB);
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error");
        } catch (Exception e){
            System.out.println("File is empty");
        }
        return longTermPBS;
    }
}
