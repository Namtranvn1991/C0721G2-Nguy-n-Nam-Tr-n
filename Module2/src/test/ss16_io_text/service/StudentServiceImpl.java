package test.ss16_io_text.service;

import _11_dsa_stack_queue.exercise.data_organization.Person;

import test.ss16_io_text.model.Student;
import test.ss16_io_text.util.ReadAndWriteToCSV;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentServiceImpl implements StudentService {

    private static final String PATH_STUDENT ="src\\ss16_io_text\\data\\student.csv";
    static List<Student> studentList = ReadAndWriteToCSV.getListStudentFromCSV(PATH_STUDENT);
    @Override

    public void add() {
        // code thêm mới
        Scanner scanner = new Scanner(System.in);
        System.out.println("nhập tên");
        String name = scanner.nextLine();
        System.out.println("nhập tuổi");
        int age = Integer.parseInt(scanner.nextLine());
        System.out.println("nhập địa chỉ");
        String address = scanner.nextLine();
        System.out.println("nhập môn học");
        String subject = scanner.nextLine();
        Student student1 = new Student(name, age, address, subject);
        List<Student> list = new ArrayList<>();
        list.add(student1);//
        ReadAndWriteToCSV.writeListStudentToCSV(list,PATH_STUDENT,true);
        // gọi hàm ghi csv


    }

    @Override
    public void showList() {

        for (int i = 0; i < studentList.size(); i++) {
            System.out.println((i + 1) + ">" + studentList.get(i));
        }
    }

    public void edit() {
//        List<Student> studentList = ReadAndWriteToCSV.getListStudentFromCSV(PATH_STUDENT);
//        showList();
//        Scanner scanner = new Scanner(System.in);
//        System.out.println(" chọn sv cần edit");
//        int chooseEdit = Integer.parseInt(scanner.nextLine());
//        System.out.println("nhập tên cần sửa");
//        studentList.get(chooseEdit - 1).setName(scanner.nextLine());
    }

    @Override
    public void delete() {
        showList();
        Scanner scanner = new Scanner(System.in);
        System.out.println(" chọn sv cần xóa");
        int chooseDelete = Integer.parseInt(scanner.nextLine());
        studentList.remove(chooseDelete - 1);
        ReadAndWriteToCSV.writeListStudentToCSV(studentList,PATH_STUDENT,false);
    }

    @Override
    public void search() {

    }


    @Override
    public void findByName() {


    }
}
