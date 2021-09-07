package _4_class_and_object_in_java.execise.testQuadraticEquation;

import java.util.Scanner;

public class TestQuadraticEquation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Quadratic equation: ax2 + bx + x = 0");
        System.out.println("Enter a, b, c");
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();
        QuadraticEquation quadraticEquation1 = new QuadraticEquation(a, b, c);
        System.out.println(quadraticEquation1.equal());

    }
}
