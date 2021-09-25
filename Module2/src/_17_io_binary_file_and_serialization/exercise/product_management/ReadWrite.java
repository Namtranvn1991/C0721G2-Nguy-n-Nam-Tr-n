package _17_io_binary_file_and_serialization.exercise.product_management;

import java.io.*;
import java.util.TreeSet;

public class ReadWrite {
    public static void writeToFile(String path, TreeSet<Product> products) {
        try {
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(products);
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static TreeSet<Product> readDataFromFile(String path){
        TreeSet<Product> products = new TreeSet<Product>();
        try{
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            products = (TreeSet<Product>) ois.readObject();
            fis.close();
            ois.close();
        } catch (EOFException e){
            System.out.println("File is blank");
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return products;
    }
}
