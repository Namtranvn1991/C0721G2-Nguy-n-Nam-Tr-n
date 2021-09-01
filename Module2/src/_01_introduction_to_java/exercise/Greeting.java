package _01_introduction_to_java.exercise;

import java.util.Scanner;

public class Greeting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Enter your name: ");
        String greeting = scanner.nextLine();
        System.out.printf("Hello: %s", greeting);
    }
}
