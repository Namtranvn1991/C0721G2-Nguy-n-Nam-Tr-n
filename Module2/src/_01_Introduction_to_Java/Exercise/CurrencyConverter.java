package _01_Introduction_to_Java.Exercise;

import java.util.Scanner;

public class CurrencyConverter {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        double VND = 23000;
        System.out.printf("input USD ");
        double USD = scanner.nextDouble();
        double result = USD*VND;
        System.out.printf("%s VND",result);
    }
}
