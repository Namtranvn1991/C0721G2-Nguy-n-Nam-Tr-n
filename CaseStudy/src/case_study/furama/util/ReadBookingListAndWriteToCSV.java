package case_study.furama.util;


import case_study.furama.model.booking.Booking;
import case_study.furama.model.facility.Facility;
import case_study.furama.model.facility.House;
import case_study.furama.model.facility.Room;
import case_study.furama.model.facility.Villa;
import case_study.furama.model.person.Customer;
import case_study.furama.services.CustomerServiceImpl;

import java.io.*;
import java.util.Date;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeSet;

public class ReadBookingListAndWriteToCSV {
    public static void readEmployeeListAndWriteToCSV(TreeSet<Booking> allBookingList, String pathFile){
        File file = new File(pathFile);
        try {
            FileWriter fileWriter = new FileWriter(file,false);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Booking booking : allBookingList){
                bufferedWriter.write(booking.toStringToFile());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e){

        }
    }

    public static TreeSet<Booking> getListBookingFromCSV(String pathFile){
        TreeSet<Booking> bookings = new TreeSet<>();
        final String CUSTOMER_LIST_PATH = "src\\case_study\\furama\\data\\CustomerList.csv";
        LinkedList<Customer> customersList = ReadCustomerListAndWriteToCSV.getListCustomerFromCSV(CUSTOMER_LIST_PATH);
        final String FACILITY_LIST_PATH = "src\\case_study\\furama\\data\\FacilityList.csv";
        Map<Facility, Integer> facilityList = ReadFacilityListAndWriteToCSV.getListEmployeeFromCSV(FACILITY_LIST_PATH);


        File file = new File(pathFile);
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line="";
            String[] array =null;
            String[] arrayDate =null;
            while ((line=bufferedReader.readLine())!=null){
                array = line.split(",");
                int bookingID = Integer.parseInt(array[0]);
                int customerID = Integer.parseInt(array[1]);
                Customer customer = new Customer();
                for (Customer c : customersList) {
                    if (customerID == c.getCustomerID()){
                        customer = c;
                    }
                }
                Facility facility = null;
                String facilityName = array[2];
                for (Facility f:facilityList.keySet()) {
                    if (facilityName.equals(f.getFacilityName())){
                        facility = f;
                    }
                }
                arrayDate = array[3].split("/");
                Date bookingDate = new Date(Integer.parseInt(arrayDate[2])-1990,Integer.parseInt(arrayDate[1])-1,Integer.parseInt(arrayDate[0]));
                arrayDate = array[4].split("/");
                Date checkoutDate = new Date(Integer.parseInt(arrayDate[2])-1990,Integer.parseInt(arrayDate[1])-1,Integer.parseInt(arrayDate[0]));
                Booking booking = new Booking(bookingID,customer,facility,bookingDate,checkoutDate);
                bookings.add(booking);
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error");
        } catch (Exception e){
        }
        return bookings;
    }
}
