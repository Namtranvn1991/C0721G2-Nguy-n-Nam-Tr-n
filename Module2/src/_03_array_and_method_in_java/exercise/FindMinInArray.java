package _03_array_and_method_in_java.exercise;

import java.util.Scanner;

public class FindMinInArray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int size;
        do {
            System.out.print("input Array size ");
            size = input.nextInt();
            if (size>10){
                System.out.println("Size does not exceed 10");
            }
        } while (size>10);

        int[] arr = new int[size];
        for (int i = 0; i < arr.length; i++) {
            System.out.print("enter element " + (i + 1) + " : ");
            arr[i] = input.nextInt();
        }

        System.out.printf("\n%-20s%s", "Element in Array: ", "");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }

        System.out.println("\nMin in Array is " + minArr(arr));

    }
    public static int minArr(int[] arr){
        int min = arr[0];
        for (int i = 0; i < arr.length; i++){
            if (min>arr[i]){
                min = arr[i];
            }
        }
        return min;
    }
}
