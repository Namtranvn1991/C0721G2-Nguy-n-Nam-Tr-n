package case_study.homework2.util;


import case_study.homework2.model.Customer;
import case_study.homework2.model.Receipt;

import java.io.*;
import java.util.Date;
import java.util.LinkedList;

public class ReadReceiptListAndWriteToCSV {
    static final String RECEIPT_PATH = "src\\case_study\\homework2\\data\\Receipt.csv";
    static LinkedList<Customer> customers = ReadCustomerListAndWriteToCSV.getListFromCSV();

    public static void writeToCSV(LinkedList<Receipt> receipts){
        File file = new File(RECEIPT_PATH);
        try {
            FileWriter fileWriter = new FileWriter(file,false);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Receipt receipt : receipts){
                bufferedWriter.write(receipt.toStringToFile());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static LinkedList<Receipt> getListFromCSV(){
        LinkedList<Receipt> receipts = new LinkedList<>();
        File file = new File(RECEIPT_PATH);
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line="";
            String[] array =null;
            String[] arrayDate =null;
            Customer customer = null;
            while ((line=bufferedReader.readLine())!=null){
                array = line.split(",");
                String receiptID = array[0];
                String customerID = array[1];
                for (Customer c:customers) {
                    if(c.getID().equals(customerID)){
                        customer = c;
                    }
                }
                arrayDate = array[2].split("/");
                Date date = new Date(Integer.parseInt(arrayDate[2])-1990,Integer.parseInt(arrayDate[1])-1,Integer.parseInt(arrayDate[0]));
                int quantity = Integer.parseInt(array[3]);
                int unitPrice = Integer.parseInt(array[4]);
                Receipt receipt = new Receipt(receiptID,customer,date,quantity,unitPrice);
                receipts.add(receipt);
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error");
        } catch (Exception e){
            //do nothing
        }
        return receipts;
    }
}
