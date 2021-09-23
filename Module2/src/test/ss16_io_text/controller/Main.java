package test.ss16_io_text.controller;



import test.ss16_io_text.service.StudentServiceImpl;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentServiceImpl managerStudent = new StudentServiceImpl();
        boolean flag=true;
        while (flag) {
            System.out.println("Chọn chức năng\n" +
                    "1.Add\n" +
                    "2.show\n" +
                    "3.delete\n" +
                    "4.edit\n" +
                    "5.search\n" +
                    "6.Exti");
            System.out.println("Chọn");
            Scanner scanner = new Scanner(System.in);
            int choose = Integer.parseInt(scanner.nextLine());
            switch (choose) {
                case 1:
                    managerStudent.add();
                    break;
                case 2:
                    managerStudent.showList();
                    // hiện thị
                    break;
                case 3:
                    // xóa
                    managerStudent.delete();
                    break;
                case 4:
                    managerStudent.edit();
                    break;
                case 5:
                    // search
                case 6:
                    flag=false;
            }
        }
    }
}
