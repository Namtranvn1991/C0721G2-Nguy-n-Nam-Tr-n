package SS1_Introduction_to_Java.Practice;

import java.util.Scanner;

public class DayOfMonth {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("nhập tháng ");
        int month = scanner.nextInt();
        boolean flag=true;
        switch (month){
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                System.out.printf("thang " + month + " co 31 ngay");
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                System.out.printf("thang " + month + " co 30 ngay");
                break;

            case 2:
                System.out.printf("thang " + month + " co 28 hoac 29 ngay");
            default:
                flag =false;
        }
        if (!flag) System.out.printf("Invalid input!");

    }
}