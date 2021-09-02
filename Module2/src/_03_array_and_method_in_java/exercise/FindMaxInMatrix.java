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
        System.out.println("Max in the Matrix is = " + max);

//        int max = matrix[findMax(matrix)[0]][findMax(matrix)[1]];
//        System.out.println("Max in the Matrix is " + "[" + findMax(matrix)[0] + "," + findMax(matrix)[1] + "] = " + max);

    }

    public static int findMax(int[][] matrix) {
        int max = matrix[0][0];
//        int[] indexMax = new int[2];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (max < matrix[i][j]) {
                    max = matrix[i][j];
//                    indexMax[0] = i;
//                    indexMax[1] = j;
                }
            }
        }
        return max;
    }
}
