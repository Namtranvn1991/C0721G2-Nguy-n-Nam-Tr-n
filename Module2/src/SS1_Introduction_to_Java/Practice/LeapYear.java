package SS1_Introduction_to_Java.Practice;

import java.util.Scanner;

public class LeapYear {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("nhap nam can kiem tra ");
        int year = scanner.nextInt();
        boolean flag = true;
        if (year%4==0){
            if (year%100==0){
                if (year%400!=0){
                    flag = false;
                }
            }
        } else {
            flag = false;
        }
        if (flag){
            System.out.printf("nam " + year + " la nam nhuan");
        } else {
            System.out.printf("nam " + year + " khong phai la nam nhuan");
        }
    }
}
