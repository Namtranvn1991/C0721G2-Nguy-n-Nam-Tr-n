package _03_array_and_method_in_java.practice;

import java.util.Arrays;
import java.util.Scanner;

public class NumberOfStudentsPassExam {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int size;
        do {
            System.out.println("Enter size of class ");
            size = input.nextInt();
            if (size > 30 || size <= 0) {
                System.out.println("Size less than 30 and more than 0");
            }
        } while (size > 30 || size <= 0);
        int[] array = new int[size];

        for (int i = 0; i < array.length; i++) {
            System.out.println("Enter mark of student " + (i + 1) + " : ");
            array[i] = input.nextInt();
        }
        int count = 0;
        System.out.print("List of mark: ");
        for (int a:array) {
            System.out.print(a + " ");
            if (a >= 5){
                count++;
            }
        }
        System.out.println("\nThe number of students passing the exam is " + count);
    }
}
