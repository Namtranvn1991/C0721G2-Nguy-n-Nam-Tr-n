package test.ManagerStudent.controller;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


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

                    break;
                case 2:

                    // hiện thị
                    break;
                case 3:
                    // xóa

                case 4:
                    // edit
                case 5:
                    // search
                case 6:
                    flag=false;
            }
        }
    }
}
