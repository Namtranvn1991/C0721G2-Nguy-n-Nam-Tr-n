package _01_introduction_to_java.exercise;

import java.util.Scanner;

public class CurrencyConverter {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        double vnd = 23000;
        System.out.printf("input USD ");
        double usd = scanner.nextDouble();
        double result = usd*vnd;
        System.out.printf("%s VND",result);
    }
}
