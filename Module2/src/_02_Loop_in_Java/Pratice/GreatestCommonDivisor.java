package _02_Loop_in_Java.Pratice;

import java.util.Scanner;

public class GreatestCommonDivisor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("input a nunber: ");
        int a = scanner.nextInt();
        int a1 = a;
        System.out.println("input b nunber: ");
        int b = scanner.nextInt();
        int b1 = b;
        int gcd;
        if (a==0||b==0){
            System.out.printf("No greatest common divisor of %s and %s", a1,b1);
        } else {
            while (a!=b){
                if (a>b)
                    a = a-b;
                if (a<b)
                    b = b-a;
            }
            gcd = a;
            System.out.printf("Greatest common divisor of %s and %s is %s", a1, b1, gcd);
        }
    }
}
