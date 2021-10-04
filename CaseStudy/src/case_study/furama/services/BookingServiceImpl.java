package case_study.furama.services;

import case_study.furama.model.booking.Booking;
import case_study.furama.model.facility.Facility;
import case_study.furama.model.facility.House;
import case_study.furama.model.facility.Villa;
import case_study.furama.model.person.Customer;
import case_study.furama.util.ReadBookingListAndWriteToCSV;
import case_study.furama.util.ReadWriteBookingListBinaryFile;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.TreeSet;

public class BookingServiceImpl implements BookingService {
    static final String BOOKING_LIST_PATH = "src\\case_study\\furama\\data\\BookingList.dat";
    static final String ALL_BOOKING_LIST_PATH = "src\\case_study\\furama\\data\\AllBookingList.dat";
    static final String ALL_BOOKING_LIST_CSV_PATH = "src\\case_study\\furama\\data\\BookingList.csv";
    static Scanner scanner = new Scanner(System.in);
    static TreeSet<Booking> bookingList = ReadWriteBookingListBinaryFile.readDataFromFile(BOOKING_LIST_PATH);
    static TreeSet<Booking> allBookingList = ReadWriteBookingListBinaryFile.readDataFromFile(ALL_BOOKING_LIST_PATH);
    static TreeSet<Booking> allBookingListCsv = ReadBookingListAndWriteToCSV.getListBookingFromCSV(ALL_BOOKING_LIST_CSV_PATH);

    static {
//        Facility facility1 = null;
//        Facility facility2 = null;
//        Facility facility3 = null;
//        for (Facility facility: FacilityServiceImpl.facilityList.keySet()) {
//            if (facility.getFacilityName().equals("Villa A")){
//                facility1 = facility;
//            }
//            if (facility.getFacilityName().equals("Room101")){
//                facility2 = facility;
//            }
//            if (facility.getFacilityName().equals("Room103")){
//                facility3 = facility;
//            }
//        }
//        bookingList.add(new Booking(10001,CustomerServiceImpl.customersList.get(1),facility1,new Date(2020,5,4),new Date(2020,5,4)));
//        bookingList.add(new Booking(10002,CustomerServiceImpl.customersList.get(0),facility2,new Date(2020,5,4),new Date(2020,5,4)));
//        bookingList.add(new Booking(10003,CustomerServiceImpl.customersList.get(3),facility2,new Date(2020,5,4),new Date(2020,5,4)));
//        ReadWriteBookingListBinaryFile.writeToFile("src\\case_study\\furama\\data\\BookingList.dat",bookingList);
    }

    public static void display(){
        for (Booking booking: bookingList) {
            System.out.println(booking);
        }
    }

    public static void add(){
        int bookingID = inputBookingID();
        Customer customer = null;
        try {
            customer = inputCustomer();
        } catch (Exception e) {
            return;
        }

        Facility facility = null;
        try {
            facility = inputFacility();
        } catch (Exception e) {
            return;
        }
        Date booking = inputBookingDate();
        Date checkout = inputCheckoutDate();

        bookingList.add(new Booking(bookingID,customer,facility,booking,checkout));
        allBookingList.add(new Booking(bookingID,customer,facility,booking,checkout));
        ReadWriteBookingListBinaryFile.writeToFile(BOOKING_LIST_PATH,bookingList);
        ReadWriteBookingListBinaryFile.writeToFile(ALL_BOOKING_LIST_PATH,allBookingList);
        ReadBookingListAndWriteToCSV.readEmployeeListAndWriteToCSV(allBookingList,ALL_BOOKING_LIST_CSV_PATH);
    }

    static int inputBookingID() {
        while (true) {
            System.out.println("Enter Booking ID");
            String bookingID = scanner.nextLine();
            if (isStringInt(bookingID)) {
                return Integer.parseInt(bookingID);
            } else {
                System.out.println("Enter again");
            }
        }
    }



    public static Customer inputCustomer() throws Exception {
        while (true){
            System.out.println("Enter customer ID. 0/ return");
            String customerID = scanner.nextLine();
            for (Customer customer: CustomerServiceImpl.customersList) {
                if (customerID.equals(customer.getCustomerID()+"")){
                    return customer;
                }
            }
            if(customerID.equals("0")){
                throw new Exception("Return");
            }
            System.out.println("Enter customer ID again");
        }

    }


    public static Facility inputFacility() throws Exception {
        while (true){
            System.out.println("Enter facility name. 0/ return");
            String facilityName = scanner.nextLine();
            for (Facility facility: FacilityServiceImpl.facilityList.keySet()) {
                if (facilityName.equals(facility.getFacilityName())){
                    return facility;
                }
            }
            if(facilityName.equals("0")){
                throw new Exception("return");
            }
            System.out.println("Enter facility name again");
        }
    }

    public static Date inputBookingDate() {
        while (true) {
            System.out.println("Enter Booking Date (dd/MM/yyyy) ");
            String bookingDate = scanner.nextLine();
            if (validateJavaDate(bookingDate)) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
                try {
                    return simpleDateFormat.parse(bookingDate);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("Please enter Booking Date again");
            }
        }
    }

    public static Date inputCheckoutDate() {
        while (true) {
            System.out.println("Enter Checkout Date (dd/MM/yyyy) ");
            String checkoutDate = scanner.nextLine();
            if (validateJavaDate(checkoutDate)) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
                try {
                    return simpleDateFormat.parse(checkoutDate);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("Please enter Checkout Date again");
            }
        }
    }


    public static boolean validateJavaDate(String strDate) {
        if (strDate.trim().equals("")) {
            return false;
        } else {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
            simpleDateFormat.setLenient(false);
            try {
                Date javaDate = simpleDateFormat.parse(strDate);
                System.out.println(strDate + " is valid date format");
            } catch (ParseException e) {
                System.out.println(strDate + " is Invalid Date format");
                return false;
            }
            return true;
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
        for (Booking b: allBookingListCsv) {
            System.out.println(b);
        }
    }
}
