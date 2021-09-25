package _17_io_binary_file_and_serialization.exercise.product_management;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        displayMainMenu();
    }

    static void displayMainMenu() {
        boolean flag = true;
        while (flag) {
            System.out.println("Main Menu\n" +
                    "1. Display Product " +
                    "2. Add Product " +
                    "3. Search Product " +
                    "4. Remove Product " +
                    "5. Exit \n");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    ProductManagement.display();
                    break;
                case "2":
                    ProductManagement.add();
                    break;
                case "3":
                    ProductManagement.search();
                    break;
                case "4":
                    ProductManagement.remove();
                    break;
                case "5":
                    flag = false;
                    break;
                default:
                    System.out.println("Please enter again");
            }
        }
    }
}
