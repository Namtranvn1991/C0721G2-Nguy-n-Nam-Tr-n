package _4_class_and_object_in_java.execise;

import java.util.Scanner;

public class TestQuadraticEquation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Quadratic equation: ax2 + bx + x = 0");
        System.out.println("Eter a, b, c");
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();
        QuadraticEquation quadraticEquation1 = new QuadraticEquation(a, b, c);
        System.out.println(quadraticEquation1.equal());

    }
}

class QuadraticEquation {
    private double a;
    private double b;
    private double c;

    QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    double getDiscriminant() {
        return Math.pow(b, 2) - 4 * a * c;
    }

    double getRoot1() {
        if (this.getDiscriminant() >= 0) {
            return (-b + Math.pow(b * b - 4 * a * c, 0.5)) / (2 * a);
        } else {
            return 0;
        }
    }

    double getRoot2() {
        if (this.getDiscriminant() >= 0) {
            return (-b - Math.pow(b * b - 4 * a * c, 0.5)) / (2 * a);
        } else {
            return 0;
        }
    }

    String equal() {
        if (this.getDiscriminant() > 0) {
            return "The equation has two roots " + this.getRoot1() + " and " + this.getRoot2();
        } else if (this.getDiscriminant() == 0) {
            return "The equation has one root " + this.getRoot1();
        } else {
            return "The equation has no real roots";
        }

    }
}