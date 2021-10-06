package case_study.homework.util;


import case_study.homework.model.Brand;
import case_study.homework.model.Car;

import java.io.*;
import java.util.LinkedList;

public class ReadBrandListFromCSV {
    final static String BRAND_PATH = "src\\case_study\\homework\\data\\Brand.csv";

    public static LinkedList<Brand> getListBrandFromCSV(){
        LinkedList<Brand> brandLinkedList = new LinkedList<>();
        File file = new File(BRAND_PATH);
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line="";
            String[] array =null;
            String[] arrayDate =null;
            while ((line=bufferedReader.readLine())!=null){
                array = line.split(",");
                String ID = array[0];
                String brandName = array[1];
                String country = array[2];
                Brand brand = new Brand(ID,brandName,country);
                brandLinkedList.add(brand);
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error");
        } catch (Exception e){
            //do nothing
        }
        return brandLinkedList;
    }
}
