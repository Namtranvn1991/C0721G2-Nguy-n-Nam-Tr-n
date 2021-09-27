package case_study.furama.util;

import case_study.furama.model.booking.Booking;
import case_study.furama.model.contract.Contract;

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

public class ReadWriteContractListBinaryFile {
    public static void writeToFile(String path, List<Contract> contractList) {
        try {
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(contractList);
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Contract> readDataFromFile(String path){
        List<Contract> contractList = new LinkedList<>();
        try{
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            contractList = (List<Contract>) ois.readObject();
            fis.close();
            ois.close();
        } catch (EOFException e){
            //do nothing;
        } catch(Exception ex){
            ex.printStackTrace();
        }
        return contractList;
    }
}
