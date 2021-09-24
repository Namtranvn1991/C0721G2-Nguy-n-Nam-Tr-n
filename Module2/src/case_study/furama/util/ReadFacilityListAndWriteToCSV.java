package case_study.furama.util;


import case_study.furama.model.facility.Facility;
import case_study.furama.model.facility.House;
import case_study.furama.model.facility.Room;
import case_study.furama.model.facility.Villa;
import case_study.furama.model.person.Employee;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

public class ReadFacilityListAndWriteToCSV {
    public static void readFacilityListAndWriteToCSV(Map<Facility, Integer> facilityList, String pathFile) {
        File file = new File(pathFile);
        try {
            FileWriter fileWriter = new FileWriter(file, false);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            facilityList.forEach((k, v) -> {
                try {
                    bufferedWriter.write(v + "," + k.toStringToFile());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    bufferedWriter.newLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static Map<Facility, Integer> getListEmployeeFromCSV(String pathFile) {
        Map<Facility, Integer> facilityList = new LinkedHashMap<>();
        File file = new File(pathFile);
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line = "";
            String[] array = null;
            while ((line = bufferedReader.readLine()) != null) {
                array = line.split(",");
                String name = array[2];
                double usingArea = Double.parseDouble(array[3]);
                double cost = Double.parseDouble(array[4]);
                int maximumPerson = Integer.parseInt(array[5]);
                String typeOfRent = array[6];

                String type = array[1];
                if (type.equals("Room")) {
                    String freeService = array[7];
                    Room room = new Room(name, usingArea, cost, maximumPerson, typeOfRent, freeService);
                    facilityList.put(room,Integer.parseInt(array[0]));
                } else {
                    int roomStandard = Integer.parseInt(array[7]);
                    int floor = Integer.parseInt(array[8]);
                    if (type.equals("Villa")) {
                        double poolArea = Double.parseDouble(array[9]);
                        Villa villa = new Villa(name, usingArea, cost, maximumPerson, typeOfRent, roomStandard, floor, poolArea);
                        facilityList.put(villa,Integer.parseInt(array[0]));
                    } else {
                        House house = new House(name, usingArea, cost, maximumPerson, typeOfRent, roomStandard, floor);
                        facilityList.put(house,Integer.parseInt(array[0]));
                    }
                }
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error");
        }
        return facilityList;
    }
}
