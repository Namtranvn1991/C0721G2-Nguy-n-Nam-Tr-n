package _03_array_and_method_in_java.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class SumOfCol {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        System.out.println(Arrays.deepToString(matrix));
        System.out.println("Enter the column you want to sum ");
        int column = input.nextInt();
        System.out.println("Result is " + sumOfCol(matrix, column));

        System.out.println("Enter the row: ");
        int row = input.nextInt();
        System.out.println("Enter the column: ");
        int col = input.nextInt();
        int[][] newMatrix = new int[row][col];
        System.out.println("Enter " + row + " rows and " +
                col + " columns: ");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.printf("[%s,%s] = ", i, j);
                newMatrix[i][j] = input.nextInt();
            }
        }
        System.out.println("Matrix");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(newMatrix[i][j] + " ");
            }
            System.out.printf("\n");
        }
        System.out.println("Enter the column you want to sum ");
        int newCol = input.nextInt();
        System.out.println("Result is " + sumOfCol(newMatrix, newCol));


    }

    public static int sumOfCol(int[][] matrix, int col) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (j == col) {
                    sum += matrix[i][j];
                }
            }
        }
        return sum;
    }
}
