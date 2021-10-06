package case_study.homework2.util;


import case_study.homework.model.Brand;
import case_study.homework2.model.CustomerType;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

public class ReadCustomerTypeListFromCSV {
    final static String BRAND_PATH = "src\\case_study\\homework2\\data\\CustomerType.csv";
    private static ArrayList<CustomerType> customerTypeList = getListBrandFromCSV();

    public static ArrayList<CustomerType> getCustomerTypeList() {
        return customerTypeList;
    }

    public static ArrayList<CustomerType> getListBrandFromCSV() {
        ArrayList<CustomerType> customerTypeList = new ArrayList<>();
        File file = new File(BRAND_PATH);
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line = "";
            String[] array = null;
            String[] arrayDate = null;
            while ((line = bufferedReader.readLine()) != null) {
                array = line.split(",");
                String typeID = array[0];
                String type = array[1];
                CustomerType customerType = new CustomerType(typeID, type);
                customerTypeList.add(customerType);
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error");
        } catch (Exception e) {
            //do nothing
        }
        return customerTypeList;
    }
}
