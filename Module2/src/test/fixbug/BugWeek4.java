package test.fixbug;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BugWeek4 {

    static List<Student> studentList = new ArrayList<>();

    static {
        studentList.add(new Student(1, "John", 5.6));
        studentList.add(new Student(2, "David", 7.6));
        studentList.add(new Student(3, "Katherine", 8));
        studentList.add(new Student(4, "Sally", 2.0));
        studentList.add(new Student(5, "Banana", 7.0));
    }

    public static void main(String[] args) {
        File file = new File("src\\test\\fixbug\\data_student.csv");
        try {
            FileWriter fileWriter = new FileWriter(file);
            for (Student studentObj: studentList) {
                if (studentObj.getName().contains("i")) {
                    fileWriter.write(studentObj.toString());
                    fileWriter.write("\r\n");
                }
            }
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
