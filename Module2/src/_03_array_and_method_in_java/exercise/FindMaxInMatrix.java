package _03_array_and_method_in_java.exercise;

import java.util.Scanner;

public class FindMaxInMatrix {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the row: ");
        int row = input.nextInt();
        System.out.println("Enter the column: ");
        int col = input.nextInt();
        int[][] matrix = new int[row][col];

        System.out.println("Enter " + row + " rows and " +
                col + " columns: ");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.printf("[%s,%s] = ", i, j);
                matrix[i][j] = input.nextInt();
            }
        }
        System.out.println("Matrix");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.printf("\n");
        }
        int max = findMax(matrix);
        System.out.print("Max in the Matrix is: ");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == max)
                    System.out.print("[" + i + "," + j + "] ");
            }
        }
        System.out.println("= " + max);


    }

    public static int findMax(int[][] matrix) {
        int max = matrix[0][0];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (max < matrix[i][j]) {
                    max = matrix[i][j];
                }
            }
        }
        return max;
    }
}
