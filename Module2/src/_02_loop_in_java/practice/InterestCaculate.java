package _02_loop_in_java.practice;

import java.util.Scanner;

public class InterestCaculate {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter investment amount: ");
        double money = scanner.nextDouble();
        System.out.println("Enter annual interest rate in percentage: ");
        double interestRate = scanner.nextDouble();
        System.out.println("Enter number of months: ");
        int month = scanner.nextInt();
        double interest = 0;
        double totalInterest = 0;
        double totalMoney = money;

        for (int i = 0; i < month; i++) {
            interest = totalMoney * interestRate / 100;
            totalInterest += interest;
            totalMoney += interest;
//          totalInterest += money * (interestRate/100)/12 * month;
        }
        System.out.printf("Total of interest: %.2f ", totalInterest);
    }
}
