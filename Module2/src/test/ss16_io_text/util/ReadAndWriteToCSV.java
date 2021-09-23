package test.ss16_io_text.util;


import test.ss16_io_text.model.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteToCSV {

    public static void writeListStudentToCSV(List<Student> studentList,String pathFile, boolean append){
        File file = new File(pathFile);
        try {
            FileWriter fileWriter = new FileWriter(file,append);// append: true // cho phép ghi tiếp/ false nghi đề
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Student student : studentList){
                bufferedWriter.write(student.getInfoToCSV());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static List<Student> getListStudentFromCSV(String pathFile){
        List<Student> studentList = new ArrayList<>();
        File file = new File(pathFile);
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line="";
            String[] array =null;
            while ((line=bufferedReader.readLine())!=null){
                array = line.split(",");
                Student student = new Student(array[0],Integer.parseInt(array[1]),array[2],array[3]);
                studentList.add(student);
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Lỗi đọc file");
        }
        return studentList;
    }

    public static void main(String[] args) {

        // demo đọc ghi file
        File file = new File("src\\ss16_io_text\\data\\file.txt");
        try {
            FileWriter fileWriter = new FileWriter(file,true);// append: true // cho phép ghi tiếp/ false nghi đề
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write("Hello World2");
            bufferedWriter.newLine();
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line="";
            while ((line=bufferedReader.readLine())!=null){
                System.out.println(line);
            }
           bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Lỗi đọc file");
        }
    }
}
