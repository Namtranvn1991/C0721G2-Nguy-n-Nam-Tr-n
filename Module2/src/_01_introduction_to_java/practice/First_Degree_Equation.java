package _01_introduction_to_java.practice;

import java.util.Scanner;

public class First_Degree_Equation {
    public static void main(String[] args) {
        System.out.println("Linear Equation Resolver");
        System.out.println("Given a equation as 'a * x + b = c', please enter constants:");
        Scanner scanner = new Scanner(System.in);

        System.out.print("a: ");
        double a = scanner.nextDouble();

        System.out.print("b: ");
        double b = scanner.nextDouble();

        System.out.print("c: ");
        double c = scanner.nextDouble();

        double x;

        if (a == 0) {
            if (b == c) {
                System.out.printf("phuong trinh vo so nghiem");
            } else {
                System.out.printf("phuong trinh vo nghiem");
            }
        } else {
            x = (c - b) / a;
            System.out.printf("phuong trinh co 1 nghiem la x = %f\n", x );
        }
    }
}
