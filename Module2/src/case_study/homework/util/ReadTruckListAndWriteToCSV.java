package case_study.homework.util;

import case_study.homework.model.Truck;

import java.io.*;
import java.util.LinkedList;

public class ReadTruckListAndWriteToCSV {
    public static void writeToCSV(LinkedList<Truck> truckLinkedList, String pathFile){
        File file = new File(pathFile);
        try {
            FileWriter fileWriter = new FileWriter(file,false);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Truck truck : truckLinkedList){
                bufferedWriter.write(truck.toStringToFile());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static LinkedList<Truck> getListFromCSV(String pathFile){
        LinkedList<Truck> truckList = new LinkedList<>();
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
                int tonnage = Integer.parseInt(array[4]);
                Truck truck = new Truck(idNumber,brand,year,owner,tonnage);
                truckList.add(truck);
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error");
        } catch (Exception e){
            //do nothing
        }
        return truckList;
    }
}
