package util;

import model.*;

import java.io.*;
import java.util.Date;
import java.util.LinkedList;

public class ReadShortTermListAndWriteToCSV {
    static final String PATH = "src\\data\\ShortTermList.csv";
    private static LinkedList<Customer> customers = ReadCustomerListFromCSV.getCustomers();


    public static void writeToCSV(LinkedList<PassBook> tests){
        File file = new File(PATH);
        try {
            FileWriter fileWriter = new FileWriter(file,false);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (PassBook passBook : tests){
                bufferedWriter.write(passBook.toStringToFile());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static LinkedList<PassBook> getShortTermListFromCSV(){
        LinkedList<PassBook> shortTermList = new LinkedList<>();
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
                String type = array[0];
                String id = array[1];
                String customerID = array[2];
                for (Customer c:customers) {
                    if(customerID.equals(c.getId())){
                        customer = c;
                    }
                }
                arrayDate = array[3].split("/");
                Date openDate = new Date(Integer.parseInt(arrayDate[2])-1990,Integer.parseInt(arrayDate[1])-1,Integer.parseInt(arrayDate[0]));
                arrayDate = array[4].split("/");
                Date beginDate = new Date(Integer.parseInt(arrayDate[2])-1990,Integer.parseInt(arrayDate[1])-1,Integer.parseInt(arrayDate[0]));
                int balance = Integer.parseInt(array[5]);
                int interestRate = Integer.parseInt(array[6]);
                if (type.equals("Limit")){
                    String term = array[7];
                    ShortTermLimitPB shortTermLimitPB = new ShortTermLimitPB(id,customer,openDate,beginDate,balance,interestRate,term);
                    shortTermList.add(shortTermLimitPB);
                } else {
                    ShortTermNoLimitPB shortTermNoLimitPB = new ShortTermNoLimitPB(id,customer,openDate,beginDate,balance,interestRate);
                    shortTermList.add(shortTermNoLimitPB);
                }
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error");
        } catch (Exception e){
            System.out.println("File is empty");
        }
        return shortTermList;
    }
}
