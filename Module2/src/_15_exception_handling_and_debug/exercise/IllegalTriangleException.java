package _15_exception_handling_and_debug.exercise;

import java.util.Scanner;

public class IllegalTriangleException {
    public static void main(String[] args) {
        boolean flag = true;
        while (flag){
            flag = true;
            System.out.println("Enter side of triangle a, b, c ");
            Scanner scanner = new Scanner(System.in);
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();
            try {
                illegalTriangle(a, b, c);
                System.out.println("Triangle with 3 side: " + a + ", " + b + ", " + c);
                flag = false;
            } catch (TriangleException e) {
                e.printStackTrace();
            }
        }
    }

    static void illegalTriangle(int a, int b, int c) throws TriangleException {
        int a1 = b + c;
        int b1 = a + c;
        int c1 = a + b;
        if (a <= 0 || b <= 0 || c <= 0) {
            throw new TriangleException("Side of triangle cant be less than or equal to 0");
        } else if (a1 <= a || b1 <= b || c1 <= c) {
            throw new TriangleException("Any two sides of triangle needs to be greater than the other side");
        }
    }
}
