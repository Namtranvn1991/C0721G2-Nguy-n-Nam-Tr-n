package case_study.furama.services;

import case_study.furama.model.booking.Booking;
import case_study.furama.model.voucher.Voucher;
import case_study.furama.util.ReadWriteBookingListBinaryFile;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;
import java.util.TreeSet;

public class PromotionServiceImpl {
    static final String ALL_BOOKING_LIST_PATH = "src\\case_study\\furama\\data\\AllBookingList.dat";
    static Scanner scanner = new Scanner(System.in);
    static TreeSet<Booking> allBookingList = ReadWriteBookingListBinaryFile.readDataFromFile(ALL_BOOKING_LIST_PATH);
    static TreeSet<Booking> bookingsThisMonth = new TreeSet<>();
    static List<Voucher> vouchers = new Stack<>();

    public static void display() {
        while (true) {
            boolean flag = true;
            System.out.println("Enter years. 0/ display all.");
            String years = scanner.nextLine();
            if (years.equals("0")) {
                for (Booking booking : allBookingList) {
                    System.out.println(booking);
                }
                return;
            }
            if (isStringInt(years)) {
                int yearsInt = Integer.parseInt(years);
                for (Booking booking : allBookingList) {
                    if (yearsInt == (LocalDate.now().getYear() - booking.getBookingDate().getYear() - 1900)) {
                        System.out.println(booking);
                        flag = false;
                    }
                }
                if (flag) {
                    System.out.println("not found");
                    return;
                }
            } else {
                return;
            }
        }
    }


    private static void bookingsThisMonth (){
        for (Booking booking:allBookingList) {
            if (booking.getBookingDate().getYear()+1900==LocalDate.now().getYear()&&booking.getBookingDate().getMonth()+1==LocalDate.now().getMonthValue()){
                bookingsThisMonth.add(booking);
            }
        }
        for (Booking b: bookingsThisMonth) {
            System.out.println(b);
        }
    }

    public static void inputAllVoucher(){
        System.out.println("add voucher 10%");
        int voucher10 = addVoucher();
        for (int i = 0; i < voucher10; i++) {
            Voucher voucher = new Voucher(Voucher.VOUCHER_10);
            vouchers.add(voucher);
        }
        System.out.println("add voucher 20%");
        int voucher20 = addVoucher();
        for (int i = 0; i < voucher20; i++) {
            Voucher voucher = new Voucher(Voucher.VOUCHER_20);
            vouchers.add(voucher);
        }
        System.out.println("add voucher 50%");
        int voucher50 = addVoucher();
        for (int i = 0; i < voucher50; i++) {
            Voucher voucher = new Voucher(Voucher.VOUCHER_50);
            vouchers.add(voucher);
        }
    }

     private static int addVoucher(){
        while (true){
            String voucher = scanner.nextLine();
            if (isStringInt(voucher)){
                if (Integer.parseInt(voucher)>0){
                    return Integer.parseInt(voucher);
                } else {
                    System.out.println("Enter again");
                }
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
        inputAllVoucher();
        for (Voucher v:vouchers) {
            System.out.println(v);
        }
    }
}
