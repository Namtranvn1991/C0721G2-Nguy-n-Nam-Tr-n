package controller;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        displayMainMenu();
    }

    static void displayMainMenu() {
        while (true) {
            System.out.println("*************************");
            System.out.println("Main Menu\n" +
                    "1. Employee Management " +
                    "2. Customer Management " +
                    "3  Facility Management " +
                    "4. Booking Management " +
                    "5. Promotion Management " +
                    "6. Exit \n");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":

                    break;
                case "2":

                    break;
                case "3":

                    break;
                case "4":

                    break;
                case "5":

                    break;
                case "6":
                    return;
                default:
                    System.out.println("Please enter again");
            }
        }
    }
}
