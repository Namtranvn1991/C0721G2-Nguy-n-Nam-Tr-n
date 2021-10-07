package case_study.practice.main;

import case_study.practice.service.Service;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        displayMainMenu();
    }

    static void displayMainMenu() {
        while (true) {
            System.out.println("1. Danh sách toàn bộ suất chiếu của rạp.\n" +
                    "2. Thêm mới một suất chiếu\n" +
                    "3. Xoá suất chiếu bất kì theo Mã suất chiếu, trước khi xoá thì cần hiển thị confirm.\n" +
                    "4. Thoát");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    Service.display();
                    break;
                case "2":
                    Service.add();
                    break;
                case "3":
                    Service.remove();
                    break;
                case "4":
                    return;
                default:
                    System.out.println("Please enter again");
            }
        }
    }
}
