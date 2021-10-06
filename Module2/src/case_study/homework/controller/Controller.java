package case_study.homework.controller;

import case_study.homework.services.BikeService;
import case_study.homework.services.CarService;
import case_study.homework.services.TruckService;
import case_study.homework.util.VehicleInput;

import java.util.Scanner;

public class Controller {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        displayMainMenu();
    }

    static void displayMainMenu() {
        while (true) {
            System.out.println("Main Menu\n" +
                    "1. Add vehicle " +
                    "2. Display vehicle " +
                    "3  Remove vehicle " +
                    "4. Exit \n");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    addVehicle();
                    break;
                case "2":
                    display();
                    break;
                case "3":
                    remove();
                    break;
                case "4":
                    return;
                default:
                    System.out.println("Please enter again");
            }
        }
    }

    static void addVehicle (){
        while (true){
            System.out.println("1. Add Car 2. Add bike 3. Add truck 4. Return");
            String choice = scanner.nextLine();
            switch (choice){
                case "1":
                    CarService carService = new CarService();
                    carService.add();
                    break;
                case "2":
                    BikeService bikeService = new BikeService();
                    bikeService.add();
                    break;
                case "3":
                    TruckService truckService = new TruckService();
                    truckService.add();
                    break;
                case "4":
                    return;
                default:
                    System.out.println("Please enter again");
            }
        }
    }

    static void display(){
        while (true){
            System.out.println("1. display car 2. display bike 3. display truck 4. Return");
            String choice = scanner.nextLine();
            switch (choice){
                case "1":
                    CarService carService = new CarService();
                    carService.display();
                    break;
                case "2":
                    BikeService bikeService = new BikeService();
                    bikeService.display();
                    break;
                case "3":
                    TruckService truckService = new TruckService();
                    truckService.display();
                    break;
                case "4":
                    return;
                default:
                    System.out.println("Please enter again");
            }
        }
    }

    static void remove(){
        while (true){
            System.out.println("Enter ID number to remove 0. Return");
            String idNumber = scanner.nextLine();
            if(idNumber.equals("0")){
                return;
            }
            if (VehicleInput.validateIdNumberCar(idNumber)){
                CarService carService = new CarService();
                carService.remove(idNumber);
                return;
            } else if (VehicleInput.validateIdNumberBike(idNumber)){
                BikeService bikeService = new BikeService();
                bikeService.remove(idNumber);
                return;
            } else if (VehicleInput.validateIdNumberTruck(idNumber)){
                TruckService truckService = new TruckService();
                truckService.remove(idNumber);
                return;
            } else {
                System.out.println("ID number is not exist. Enter again");
            }
        }
    }
}
