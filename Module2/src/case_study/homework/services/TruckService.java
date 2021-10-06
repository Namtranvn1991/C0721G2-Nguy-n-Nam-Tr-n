package case_study.homework.services;


import case_study.homework.model.Truck;
import case_study.homework.util.ReadTruckListAndWriteToCSV;
import case_study.homework.util.VehicleInput;

import java.util.LinkedList;
import java.util.Scanner;

public class TruckService implements Service {
    static final String TRUCK_PATH = "src\\case_study\\homework\\data\\Truck.csv";
    private static LinkedList<Truck> truckList = ReadTruckListAndWriteToCSV.getListFromCSV(TRUCK_PATH);
    static Scanner scanner = new Scanner(System.in);

    public static LinkedList<Truck> getTruckList() {
        return truckList;
    }

    public void add(){
        String idNumber = VehicleInput.idNumberTruck();
        String brand = VehicleInput.brand();
        int year = VehicleInput.year();
        String owner = VehicleInput.owner();
        int tonnage = VehicleInput.tonnage();
        Truck truck = new Truck(idNumber,brand,year,owner,tonnage);
        truckList.add(truck);
        ReadTruckListAndWriteToCSV.writeToCSV(truckList, TRUCK_PATH);
    }

    public void display(){
        for (Truck truck:truckList) {
            System.out.println(truck);
        }
    }

    public void remove(String idNumber) {
        for (Truck truck:truckList) {
            if (truck.getNumberID().equals(idNumber)) {
                System.out.println(truck);
                System.out.println("Do U want to remove Y/N");
                String choice = scanner.nextLine();
                switch (choice){
                    case "Y":
                    case "y":
                        truckList.remove(truck);
                        ReadTruckListAndWriteToCSV.writeToCSV(truckList, TRUCK_PATH);
                        return;
                    default:
                        return;
                }
            }
        }
    }
}
