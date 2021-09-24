package case_study.furama.util;

import _17_io_binary_file_and_serialization.practice.readAndWriteStudentList.Student;
import case_study.furama.model.booking.Booking;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
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
