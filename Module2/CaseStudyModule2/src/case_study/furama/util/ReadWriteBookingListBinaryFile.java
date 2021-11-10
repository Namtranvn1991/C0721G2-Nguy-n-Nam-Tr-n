package case_study.furama.util;

import case_study.furama.model.booking.Booking;

import java.io.*;
import java.util.TreeSet;

public class ReadWriteBookingListBinaryFile {
    public static void writeToFile(String path, TreeSet<Booking> bookings) {
        try {
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(bookings);
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e){

        }
    }

    public static TreeSet<Booking> readDataFromFile(String path){
        TreeSet<Booking> bookings = new TreeSet<>();
        try{
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            bookings = (TreeSet<Booking>) ois.readObject();
            fis.close();
            ois.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return bookings;
    }
}
