package _02_Loop_in_Java.Exercise;

import java.util.Scanner;

public class DrawingMenu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Menu");
        System.out.println("1. Print the rectangle");
        System.out.println("2. Print the square triangle");
        System.out.println("3. Print isosceles triangle");
        System.out.println("4. Exit");
        System.out.println("Enter your choice: ");
        int choice = scanner.nextInt();
        int n = 5;
        switch (choice) {
            case 1:
                System.out.println("Print the rectangle");
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        System.out.print("* ");
                    }
                    System.out.println("");
                }
                break;
            case 2:
                System.out.println("Print the square triangle");
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n - i; j++) {
                        System.out.print("* ");
                    }
                    System.out.println("");
                }
                break;
            case 3:
                System.out.println("Print isosceles triangle");
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n - i - 1; j++) {
                        System.out.print(" ");
                    }
                    for (int j = 0; j < i*2 + 1; j++) {
                        System.out.print("*");
                    }
                    System.out.println("");
                }
                break;
            case 4:
                System.exit(0);
            default:
                System.out.println("No choice!");

        }
    }
}
