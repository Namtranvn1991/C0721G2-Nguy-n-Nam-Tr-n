package case_study.furama.services;

import case_study.furama.model.booking.Booking;
import case_study.furama.model.contract.Contract;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class ContactServiceImpl implements ContactService {
    static public List<Contract> contractList = new LinkedList<>();
    static Scanner scanner = new Scanner(System.in);


    public static void add() {
        System.out.println(BookingServiceImpl.bookingList.first());
        int contractID = inputContractID();
        int deposit = inputDeposit();
        int totalPayment = inputTotalPayment();
        Contract contract = new Contract(contractID, BookingServiceImpl.bookingList.first(), deposit, totalPayment);
        System.out.println(contract);
        System.out.println("Do you want to create this contract. Y/N");
        String choice = scanner.nextLine();
        switch (choice) {
            case "y":
                contractList.add(contract);
                String facilityName = contract.getBooking().getFacility().getFacilityName();
                FacilityServiceImpl.usedAFacility(facilityName);
                BookingServiceImpl.bookingList.pollFirst();
            default:
                return;
        }
    }

    public static void display() {
        for (Contract contract : contractList) {
            System.out.println(contract);
        }
    }

    public static void edit() {
        while (true){
            System.out.println("Enter Contract ID to edit. 0/Return");
            String contractID = scanner.nextLine();
            if (contractID.equals("0")){
                return;
            }
            for (Contract contract:contractList) {
                if (contractID.equals(contract.getContractID()+"")){
                    int newDeposit = inputDeposit();
                    int newTotalPayment = inputTotalPayment();
                    contract.setDeposit(newDeposit);
                    contract.setTotalPayment(newTotalPayment);
                }
                return;
            }
            System.out.println("Contract ID is not found");
        }
    }


    static int inputContractID() {
        while (true) {
            System.out.println("Enter Contract ID");
            String contractID = scanner.nextLine();
            if (isStringInt(contractID)) {
                return Integer.parseInt(contractID);
            } else {
                System.out.println("Enter again");
            }
        }
    }

    static int inputDeposit() {
        while (true) {
            System.out.println("Enter Deposit");
            String deposit = scanner.nextLine();
            if (isStringInt(deposit)) {
                return Integer.parseInt(deposit);
            } else {
                System.out.println("Enter again");
            }
        }
    }

    static int inputTotalPayment() {
        while (true) {
            System.out.println("Enter TotalPayment");
            String totalPayment = scanner.nextLine();
            if (isStringInt(totalPayment)) {
                return Integer.parseInt(totalPayment);
            } else {
                System.out.println("Enter again");
            }
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
}
