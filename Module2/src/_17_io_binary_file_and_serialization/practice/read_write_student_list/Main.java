package _17_io_binary_file_and_serialization.practice.read_write_student_list;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Vũ Kiều Anh", "Hà Nội",new Car("mer")));
        students.add(new Student(2, "Nguyễn Minh Quân", "Hà Nội",new Car("BMW")));
        students.add(new Student(3, "Đặng Huy Hoà", "Đà Nẵng", new Car("Honda")));
        students.add(new Student(4, "Nguyễn Khánh Tùng", "Hà Nội",new Car("audi")));
        students.add(new Student(5, "Nguyễn Khắc Nhật", "Hà Nội",new Car("lamboghini")));
        writeToFile("src\\_17_io_binary_file_and_serialization\\practice\\readAndWriteStudentList\\student.txt", students);
        List<Student> studentDataFromFile = readDataFromFile("src\\_17_io_binary_file_and_serialization\\practice\\readAndWriteStudentList\\student.txt");
        for (Student student : studentDataFromFile){
            System.out.println(student);
        }
        System.out.println("123");
    }

    public static void writeToFile(String path, List<Student> students) {
        try {
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(students);
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Student> readDataFromFile(String path){
        List<Student> students = new ArrayList<>();
        try{
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            students = (List<Student>) ois.readObject();
            fis.close();
            ois.close();
        } catch (EOFException e){
            System.out.println("File is blank");
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return students;
    }
}