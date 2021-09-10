package test.ManagerStudent.service;


import java.util.Scanner;

public class Manager {
    // quản lý sinh viên
    // thêm, hiện thi, sửa, xóa, search;

    static {
//        studentList[0]=new Student("chanh",23,"DN");
//        studentList[1]=new Student("chanh2",23,"DN");
//        studentList[2]=new Student("chanh3",23,"DN");
//        studentList[3]=new Student("chanh4",23,"DN");

    }
    public static void add(){
        // code thêm mới
        Scanner scanner = new Scanner(System.in);
        System.out.println("nhập tên");
        String name = scanner.nextLine();
        System.out.println("nhập tuổi");
        int age = Integer.parseInt(scanner.nextLine());
        System.out.println("nhập địa chỉ");
        String address = scanner.nextLine();

    }

    public static void showList(){

    }
}
