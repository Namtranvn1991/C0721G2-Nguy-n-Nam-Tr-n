package util;

import model.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;

public class ReadListAndWriteToCSV {
    static final String PATH = "";
    private static LinkedList<Test> tests = getTestListFromCSV();

    public static LinkedList<Test> getTests() {
        return tests;
    }

    public static void writeToCSV(LinkedList<Test> tests){
        File file = new File(PATH);
        try {
            FileWriter fileWriter = new FileWriter(file,false);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Test test : tests){
                bufferedWriter.write(test.toStringToFile());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static LinkedList<Test> getTestListFromCSV(){
        LinkedList<Test> tests = new LinkedList<>();
        File file = new File(PATH);
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line="";
            String[] array =null;
            String[] arrayDate =null;
            while ((line=bufferedReader.readLine())!=null){
                array = line.split(",");
                String name = array[0];
                arrayDate = array[1].split("/");
                Date date = new Date(Integer.parseInt(arrayDate[2])-1990,Integer.parseInt(arrayDate[1])-1,Integer.parseInt(arrayDate[0]));
                int number = Integer.parseInt(array[2]);
                Test test = new Test(name,date,number);
                tests.add(test);
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error");
        } catch (Exception e){
            System.out.println("File is empty");
        }
        return tests;
    }
}
