package _17_io_binary_file_and_serialization.exercise.copyFileBinary;

import _17_io_binary_file_and_serialization.exercise.productManagement.Product;

import java.io.*;
import java.util.TreeSet;

public class CopyFile {
    public static void writeToFile(String sourcePath, String targetPath) {
        Object object = readDataFromFile(sourcePath);
        try {
            FileOutputStream fos = new FileOutputStream(targetPath);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(object);
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Object readDataFromFile(String path) {
        Object object = new Object();
        try {
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            object = ois.readObject();
            fis.close();
            ois.close();
        } catch (EOFException e) {
            System.out.println("File is blank");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return object;
    }
}
