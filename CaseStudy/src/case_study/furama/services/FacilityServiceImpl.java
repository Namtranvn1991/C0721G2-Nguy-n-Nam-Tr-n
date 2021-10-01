package case_study.furama.services;

import case_study.furama.util.FacilityInput;
import case_study.furama.model.facility.Facility;
import case_study.furama.model.facility.House;
import case_study.furama.model.facility.Room;
import case_study.furama.model.facility.Villa;
import case_study.furama.util.ReadFacilityListAndWriteToCSV;

import java.util.Map;
import java.util.Scanner;

public class FacilityServiceImpl implements FacilityService {
    static Map<Facility, Integer> facilityList = ReadFacilityListAndWriteToCSV.getListEmployeeFromCSV("src\\case_study\\furama\\data\\FacilityList.csv");
    static Scanner scanner = new Scanner(System.in);
    static int count;

    static {
//        Facility villa1 = new Villa("Villa A", 300, 2000, 10, Facility.DAILY_RENTAL, 1, 2, 50);
//        Facility villa2 = new Villa("Villa A", 300, 2000, 10, Facility.DAILY_RENTAL, 1, 2, 50);
//        Facility house1 = new House("House A", 100, 3000, 6, Facility.MONTHLY_RENTAL, 1, 1);
//        Facility room1 = new Room("Room101", 30, 20, 2, Facility.HOURLY_RENTAL, Room.FREE_DRINK);
//        Facility room2 = new Room("Room102", 30, 20, 2, Facility.HOURLY_RENTAL, Room.FREE_GAMING);
//        Facility room3 = new Room("Room103", 30, 20, 2, Facility.HOURLY_RENTAL, Room.FREE_SPA);
//        facilityList.put(villa1, 0);
//        facilityList.put(villa2, 3);
//        facilityList.put(house1, 5);
//        facilityList.put(room1, 0);
//        facilityList.put(room2, 3);
//        facilityList.put(room3, 1);
//        ReadFacilityListAndWriteToCSV.readFacilityListAndWriteToCSV(facilityList,"src\\case_study\\furama\\data\\FacilityList.csv",true);
    }

    public static void usedAFacility(String facilityName){
        for (Map.Entry<Facility, Integer> facility : facilityList.entrySet()) {
            if (facility.getKey().getFacilityName().equals(facilityName)){
                facility.setValue(facility.getValue()+1);
            }
        }
    }


    public static void add() {
        System.out.println("1.Add New Villa 2.Add New House 3.Add New Room 4.Back to menu");
        String choice = scanner.nextLine();
        switch (choice) {
            case "1":
                addVilla();
                return;
            case "2":
                addHouse();
                return;
            case "3":
                addRoom();
                return;
            case "4":
                return;
            default:
                return;
        }
    }

    public static void displayFacility() {
        for (Map.Entry<Facility, Integer> facility : facilityList.entrySet()) {
            System.out.println(facility.toString());
        }

    }

    public static void displayListFacilityMaintenance() {
        for (Map.Entry<Facility, Integer> facility : facilityList.entrySet()) {
            if (facility.getValue() >= 5) {
                System.out.println(facility.toString());
            }
        }
    }


    private static void addVilla() {
        String facilityName = FacilityInput.inputName();
        double usingArea = FacilityInput.inputUsingArea();
        double cost = FacilityInput.inputCost();
        int maximumPerson = FacilityInput.inputMaximumPerson();
        String typeOfRent = FacilityInput.inputTypeOfRent();

        int roomStandard = inputRoomStandard();
        int floor = inputFloor();
        double poolArea = inputPoolArea();

        Villa villa = new Villa(facilityName, usingArea, cost, maximumPerson, typeOfRent, roomStandard, floor, poolArea);
        facilityList.put(villa, 0);
        ReadFacilityListAndWriteToCSV.readFacilityListAndWriteToCSV(facilityList,"src\\case_study\\furama\\data\\FacilityList.csv");
    }


    private static void addHouse() {
        String facilityName = FacilityInput.inputName();
        double usingArea = FacilityInput.inputUsingArea();
        double cost = FacilityInput.inputCost();
        int maximumPerson = FacilityInput.inputMaximumPerson();
        String typeOfRent = FacilityInput.inputTypeOfRent();

        int roomStandard = inputRoomStandard();
        int floor = inputFloor();

        House house = new House(facilityName, usingArea, cost, maximumPerson, typeOfRent, roomStandard, floor);
        facilityList.put(house, 0);
        ReadFacilityListAndWriteToCSV.readFacilityListAndWriteToCSV(facilityList,"src\\case_study\\furama\\data\\FacilityList.csv");
    }

    private static void addRoom() {
        String facilityName = FacilityInput.inputName();
        double usingArea = FacilityInput.inputUsingArea();
        double cost = FacilityInput.inputCost();
        int maximumPerson = FacilityInput.inputMaximumPerson();
        String typeOfRent = FacilityInput.inputTypeOfRent();

        String freeService = inputFreeService();

        Room room = new Room(facilityName, usingArea, cost, maximumPerson, typeOfRent, freeService);
        facilityList.put(room, 0);
        ReadFacilityListAndWriteToCSV.readFacilityListAndWriteToCSV(facilityList,"src\\case_study\\furama\\data\\FacilityList.csv");
    }


    private static int inputRoomStandard() {
        while (true) {
            System.out.println("Room Standard 1-3");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    return 1;
                case "2":
                    return 2;
                case "3":
                    return 3;
                default:
                    System.out.println("Enter again");
            }
        }
    }

    public static double inputPoolArea() {
        while (true) {
            System.out.println("Enter pool Area");
            String poolArea = scanner.nextLine();
            if (isStringDouble(poolArea)) {
                if (Double.parseDouble(poolArea)>=30){
                    return Double.parseDouble(poolArea);
                }else {
                    System.out.println("Enter again");
                }
            } else {
                System.out.println("Enter again");
            }
        }
    }

    public static int inputFloor() {
        while (true) {
            System.out.println("Enter floors");
            String floor = scanner.nextLine();
            if (isStringInt(floor)) {
                if (Integer.parseInt(floor)>0){
                    return Integer.parseInt(floor);
                }else {
                    System.out.println("Enter again");
                }
            } else {
                System.out.println("Enter again");
            }
        }
    }

    public static String inputFreeService() {
        while (true) {
            System.out.println("Enter Free Service 1.free spa 2.free gaming 3.free drink");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    return Room.FREE_SPA;
                case "2":
                    return Room.FREE_GAMING;
                case "3":
                    return Room.FREE_DRINK;
                default:
                    System.out.println("Enter again");
            }
        }
    }


    static public boolean isStringDouble(String s) {
        try {
            Double.parseDouble(s);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    static public boolean isStringInt(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    public static void main(String[] args) {
        displayFacility();
        displayListFacilityMaintenance();
    }

}
