package case_study.homework.util;


import case_study.homework.model.Bike;

import java.io.*;
import java.util.LinkedList;

public class ReadBikeListAndWriteToCSV {
    public static void writeToCSV(LinkedList<Bike> bikeList, String pathFile){
        File file = new File(pathFile);
        try {
            FileWriter fileWriter = new FileWriter(file,false);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Bike bike : bikeList){
                bufferedWriter.write(bike.toStringToFile());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static LinkedList<Bike> getListFromCSV(String pathFile){
        LinkedList<Bike> bikeList = new LinkedList<>();
        File file = new File(pathFile);
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line="";
            String[] array =null;
            String[] arrayDate =null;
            while ((line=bufferedReader.readLine())!=null){
                array = line.split(",");
                String idNumber = array[0];
                String brand = array[1];
                int year = Integer.parseInt(array[2]);
                String owner = array[3];
                int wattage = Integer.parseInt(array[4]);
                Bike bike = new Bike(idNumber,brand,year,owner,wattage);
                bikeList.add(bike);
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error");
        } catch (Exception e){
            //do nothing
        }
        return bikeList;
    }
}
