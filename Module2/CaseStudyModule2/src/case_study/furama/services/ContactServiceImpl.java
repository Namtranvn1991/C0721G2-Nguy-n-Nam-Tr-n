package case_study.furama.services;

import case_study.furama.model.booking.Booking;
import case_study.furama.model.contract.Contract;
import case_study.furama.util.ReadWriteBookingListBinaryFile;
import case_study.furama.util.ReadWriteContractListBinaryFile;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class ContactServiceImpl implements ContactService {
    static final String CONTRACT_LIST_PATH = "src\\case_study\\furama\\data\\ContractList.dat";
    static final String BOOKING_LIST_PATH = "src\\case_study\\furama\\data\\BookingList.dat";
    static public List<Contract> contractList = ReadWriteContractListBinaryFile.readDataFromFile(CONTRACT_LIST_PATH);
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
            case "Y":
            case "y":
                contractList.add(contract);
                String facilityName = contract.getBooking().getFacility().getFacilityName();
                FacilityServiceImpl.usedAFacility(facilityName);
                BookingServiceImpl.bookingList.pollFirst();
                ReadWriteBookingListBinaryFile.writeToFile(BOOKING_LIST_PATH,BookingServiceImpl.bookingList);
                ReadWriteContractListBinaryFile.writeToFile(CONTRACT_LIST_PATH,contractList);
            default:
                System.out.println("contract is canceled");
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
                    ReadWriteContractListBinaryFile.writeToFile(CONTRACT_LIST_PATH,contractList);
                    return;
                }
            }
            System.out.println("Contract ID is not found");
            return;
        }
    }


    static int inputContractID() {
        while (true) {
            System.out.println("Enter Contract ID");
            String contractID = scanner.nextLine();
            if (isStringInt(contractID)) {
                for (Contract contract: contractList) {
                    if (contract.getContractID()==Integer.parseInt(contractID)){
                        System.out.println("Contract ID is already exist. Enter again");
                        continue;
                    }
                }
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

    public static void main(String[] args) {
//        contractList.remove(contractList.get(0));
//        ReadWriteContractListBinaryFile.writeToFile(CONTRACT_LIST_PATH,contractList);
//        display();
    }
}
