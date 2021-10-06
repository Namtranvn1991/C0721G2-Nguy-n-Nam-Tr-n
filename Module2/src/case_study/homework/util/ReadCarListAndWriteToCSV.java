package case_study.homework.util;


import case_study.furama.model.person.Customer;
import case_study.homework.model.Car;

import java.io.*;
import java.util.Date;
import java.util.LinkedList;

public class ReadCarListAndWriteToCSV {
    public static void writeToCSV(LinkedList<Car> carList, String pathFile){
        File file = new File(pathFile);
        try {
            FileWriter fileWriter = new FileWriter(file,false);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Car car : carList){
                bufferedWriter.write(car.toStringToFile());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static LinkedList<Car> getListFromCSV(String pathFile){
        LinkedList<Car> carList = new LinkedList<>();
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
                int seats = Integer.parseInt(array[4]);
                String type = "";
                if (idNumber.contains("A")){
                    type = Car.TRAVEL;
                } else if (idNumber.contains("B")){
                    type = Car.BUS;
                }
                Car car = new Car(idNumber,brand,year,owner,seats,type);
                carList.add(car);
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error");
        } catch (Exception e){
            //do nothing
        }
        return carList;
    }
}
