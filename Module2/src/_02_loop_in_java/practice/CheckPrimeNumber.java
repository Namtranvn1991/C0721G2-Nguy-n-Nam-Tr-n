package _02_loop_in_java.practice;

import java.util.Scanner;

public class CheckPrimeNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("input ");
        int n = scanner.nextInt();
        boolean flag = true;
        if (n<2){
            flag = false;
        } else {
            for (int i=2;i<n;i++){
                flag = true;
                if (n%i==0){
                    flag = false;
                    break;
                }
            }
        }
        if (flag){
            System.out.printf("%s is a Prime number", n);
        } else {
            System.out.printf("%s is not a Prime number", n);
        }
    }
}
