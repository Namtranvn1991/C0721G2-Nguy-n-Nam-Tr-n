package case_study.homework.services;

import case_study.homework.model.Bike;
import case_study.homework.model.Car;
import case_study.homework.util.ReadBikeListAndWriteToCSV;
import case_study.homework.util.ReadCarListAndWriteToCSV;
import case_study.homework.util.VehicleInput;

import java.util.LinkedList;
import java.util.Scanner;

public class BikeService implements Service {

    static final String BIKE_PATH = "src\\case_study\\homework\\data\\Bike.csv";
    private static LinkedList<Bike> bikeList = ReadBikeListAndWriteToCSV.getListFromCSV(BIKE_PATH);
    static Scanner scanner = new Scanner(System.in);

    public static LinkedList<Bike> getBikeList() {
        return bikeList;
    }

    public void add(){
        String idNumber = VehicleInput.idNumberBike();
        String brand = VehicleInput.brand();
        int year = VehicleInput.year();
        String owner = VehicleInput.owner();
        int wattage = VehicleInput.wattage();
        Bike bike = new Bike(idNumber,brand,year,owner,wattage);
        bikeList.add(bike);
        ReadBikeListAndWriteToCSV.writeToCSV(bikeList,BIKE_PATH);
    }

    public void display(){
        for (Bike bike:bikeList) {
            System.out.println(bike);
        }
    }

    public void remove(String idNumber) {
        for (Bike bike:bikeList) {
            if (bike.getNumberID().equals(idNumber)) {
                System.out.println(bike);
                System.out.println("Do U want to remove Y/N");
                String choice = scanner.nextLine();
                switch (choice){
                    case "Y":
                    case "y":
                        bikeList.remove(bike);
                        ReadBikeListAndWriteToCSV.writeToCSV(bikeList, BIKE_PATH);
                        return;
                    default:
                        return;
                }
            }
        }
    }
}
