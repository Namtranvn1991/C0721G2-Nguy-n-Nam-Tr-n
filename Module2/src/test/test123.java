package test;

import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class test123 {
    public static void main(String[] args) {
        int[][] matrix = new int[3][3];
        java.util.Scanner input = new Scanner(System.in);
        System.out.println("Enter " + matrix.length + " rows and " +
                matrix[0].length + " columns: ");
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++) {
                matrix[row][column] = input.nextInt();
            }
        }

    }
}
