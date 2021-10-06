package case_study.homework.util;

import case_study.homework.model.Bike;
import case_study.homework.model.Brand;
import case_study.homework.model.Car;
import case_study.homework.model.Truck;
import case_study.homework.services.BikeService;
import case_study.homework.services.CarService;
import case_study.homework.services.TruckService;

import java.util.LinkedList;
import java.util.Scanner;

public class VehicleInput {
    static Scanner scanner = new Scanner(System.in);
    static final int YEAR_NOW = 2021;
    static final int SEATS_MAX = 20;


    public static String idNumberCar() {
        while (true) {
            System.out.println("Enter car id Number");
            String idNumberCar = scanner.nextLine();
            if (validateIdNumberCar(idNumberCar)) {
                boolean flag = true;
                for (Car car : CarService.getCarList()) {
                    if (car.getNumberID().equals(idNumberCar)) {
                        flag = false;
                    }
                }
                if (flag) {
                    return idNumberCar;
                } else {
                    System.out.println("id Number is exist");
                }
            } else {
                System.out.println("Enter again");
            }
        }
    }

    public static String idNumberBike() {
        while (true) {
            System.out.println("Enter bike id Number");
            String idNumberBike = scanner.nextLine();
            if (validateIdNumberBike(idNumberBike)) {
                boolean flag = true;
                for (Bike bike : BikeService.getBikeList()) {
                    if (bike.getNumberID().equals(idNumberBike)) {
                        flag = false;
                    }
                }
                if (flag) {
                    return idNumberBike;
                } else {
                    System.out.println("id Number is exist");
                }
            } else {
                System.out.println("Enter again");
            }
        }
    }

    public static String idNumberTruck() {
        while (true) {
            System.out.println("Enter truck id Number");
            String idNumberTruck = scanner.nextLine();
            if (validateIdNumberTruck(idNumberTruck)) {
                boolean flag = true;
                for (Truck truck : TruckService.getTruckList()) {
                    if (truck.getNumberID().equals(idNumberTruck)) {
                        flag = false;
                    }
                }
                if (flag) {
                    return idNumberTruck;
                } else {
                    System.out.println("id Number is exist");
                }
            } else {
                System.out.println("Enter again");
            }
        }
    }

    public static String brand() {
        while (true) {
            LinkedList<Brand> brands = ReadBrandListFromCSV.getListBrandFromCSV();
            for (Brand b : brands) {
                System.out.println(b);
            }
            System.out.println("Enter brand id");
            String brand = scanner.nextLine();
            if (validateBrand(brand)) {
                for (Brand b : brands) {
                    if (b.getBrandID().equals(brand)) {
                        return b.getBrandName();
                    }
                }
                System.out.println("Enter again");
            } else {
                System.out.println("Enter again");
            }
        }
    }

    public static int year() {
        while (true) {
            System.out.println("Enter year Of Manufacture");
            String yearOfManufacture = scanner.nextLine();
            int year;
            if (isStringIntPositiveNumbers(yearOfManufacture)) {
                year = Integer.parseInt(yearOfManufacture);
                if (year > 1900 && year <= YEAR_NOW) {
                    return year;
                } else {
                    System.out.println("Enter again");
                }
            } else {
                System.out.println("Enter again");
            }
        }
    }

    public static String owner() {
        while (true) {
            System.out.println("Enter owner name");
            String owner = scanner.nextLine();
            if (validateOwnerName(owner)) {
                return owner;
            } else {
                System.out.println("Enter again");
            }
        }
    }


    public static int seats() {
        while (true) {
            System.out.println("Enter car seats");
            String seats = scanner.nextLine();
            int seatsInt;
            if (isStringIntPositiveNumbers(seats)) {
                seatsInt = Integer.parseInt(seats);
                if (seatsInt <= SEATS_MAX) {
                    return seatsInt;
                } else {
                    System.out.println("Enter again");
                }
            } else {
                System.out.println("Enter again");
            }
        }
    }

    public static String carType() {
        while (true) {
            System.out.println("Enter car type 1. Travel 2. Bus");
            String type = scanner.nextLine();
            switch (type) {
                case "1":
                    return Car.TRAVEL;
                case "2":
                    return Car.BUS;
                default:
                    System.out.println("Enter again");
            }
        }
    }

    public static int tonnage() {
        while (true) {
            System.out.println("Enter truck tonnage");
            String tonnage = scanner.nextLine();
            if (isStringIntPositiveNumbers(tonnage)) {
                return Integer.parseInt(tonnage);
            } else {
                System.out.println("Enter again");
            }
        }
    }

    public static int wattage() {
        while (true) {
            System.out.println("Enter bike wattage");
            String wattage = scanner.nextLine();
            if (isStringIntPositiveNumbers(wattage)) {
                return Integer.parseInt(wattage);
            } else {
                System.out.println("Enter again");
            }
        }
    }

    public static boolean validateIdNumberCar(String idNumber) {
        String regex = "\\d{2}[AB]-\\d{3}.\\d{2}";
        return idNumber.matches(regex);
    }

    public static boolean validateIdNumberBike(String idNumber) {
        String regex = "\\d{2}-[A-Z][0-9]-\\d{3}.\\d{2}";
        return idNumber.matches(regex);
    }

    public static boolean validateIdNumberTruck(String idNumber) {
        String regex = "\\d{2}[C]-\\d{3}.\\d{2}";
        return idNumber.matches(regex);
    }

    public static boolean validateBrand(String brand) {
        String regex = "HSX-\\d{3}";
        return brand.matches(regex);
    }

    public static boolean validateOwnerName(String ownerName) {
        String regex = "[A-Z][a-z]+\\s([A-Z][a-z]*\\s)*[A-Z][a-z]*";
        return ownerName.matches(regex);
    }

    static public boolean isStringIntPositiveNumbers(String s) {
        try {
            if (Integer.parseInt(s) > 0) {
                return true;
            } else {
                return false;
            }
        } catch (NumberFormatException ex) {
            return false;
        }
    }
}
