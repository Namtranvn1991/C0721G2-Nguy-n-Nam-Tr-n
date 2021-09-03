package _03_array_and_method_in_java.exercise;

import java.util.Scanner;

public class SumOfLeftDiagonal {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the side of square: ");
        int side = input.nextInt();
        int[][] matrix = new int[side][side];
        System.out.println("Enter element of Matrix " +side+"x"+side );
        for (int i = 0; i < side; i++) {
            for (int j = 0; j < side; j++) {
                System.out.printf("[%s,%s] = ", i, j);
                matrix[i][j] = input.nextInt();
            }
        }
        System.out.println("Matrix");
        for (int i = 0; i < side; i++) {
            for (int j = 0; j < side; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.printf("\n");
        }
        System.out.println("Sum of left Diagonal is " + sumOfLeftDiagonal(matrix));
    }
    static int sumOfLeftDiagonal(int[][] matrix){
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
               if (i==j){
                   sum +=matrix[i][j];
               };
            }

        }
        return sum;
    }

}
