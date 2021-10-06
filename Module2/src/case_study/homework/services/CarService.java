package case_study.homework.services;

import case_study.furama.model.person.Customer;
import case_study.furama.util.ReadCustomerListAndWriteToCSV;
import case_study.homework.model.Car;
import case_study.homework.model.Vehicle;
import case_study.homework.util.ReadCarListAndWriteToCSV;
import case_study.homework.util.VehicleInput;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class CarService implements Service {
    static final String CAR_PATH = "src\\case_study\\homework\\data\\Car.csv";
    private static LinkedList<Car> carList = ReadCarListAndWriteToCSV.getListFromCSV(CAR_PATH);
    static Scanner scanner = new Scanner(System.in);

    public static LinkedList<Car> getCarList() {
        return carList;
    }

    public void add() {
        String idNumber = VehicleInput.idNumberCar();
        String brand = VehicleInput.brand();
        int year = VehicleInput.year();
        String owner = VehicleInput.owner();
        int seats = VehicleInput.seats();
        String type = "";
        if (idNumber.contains("A")) {
            type = Car.TRAVEL;
        } else if (idNumber.contains("B")) {
            type = Car.BUS;
        }
        Car car = new Car(idNumber, brand, year, owner, seats, type);
        carList.add(car);
        ReadCarListAndWriteToCSV.writeToCSV(carList, CAR_PATH);
    }

    public void display() {
        for (Car car : carList) {
            System.out.println(car);
        }
    }

    public void remove(String idNumber) {
        for (Car car : carList) {
            if (car.getNumberID().equals(idNumber)) {
                System.out.println(car);
                System.out.println("Do U want to remove Y/N");
                String choice = scanner.nextLine();
                switch (choice){
                    case "Y":
                    case "y":
                        carList.remove(car);
                        ReadCarListAndWriteToCSV.writeToCSV(carList, CAR_PATH);
                        return;
                    default:
                        return;
                }
            }
        }
    }
}
