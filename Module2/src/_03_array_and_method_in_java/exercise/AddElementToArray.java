package _03_array_and_method_in_java.exercise;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;


public class AddElementToArray {
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
        System.out.println("\nEnter the number add to Array ");
        int addNunber = input.nextInt();
        System.out.println("Enter the index add to Array ");
        int addIndex = input.nextInt();

        int[] newArr = add(arr,addNunber,addIndex);

        System.out.printf("\n%s ", "Element in new Array: ");
        System.out.print(Arrays.toString(newArr));

    }

    public static int[] add(int[] arr, int number, int index){
        if (index<arr.length&&index>=0){
            int [] newArr = new int[arr.length+1];
            for (int i = 0; i < index; i++){
                newArr[i] = arr [i];
            }
            newArr[index] = number;
            for (int i = index+1; i < newArr.length; i++){
                newArr[i] = arr[i-1];
            }
            return newArr;
        }
        else {
            int [] newArr = new int[arr.length];
            for (int i = 0; i < arr.length; i++){
                newArr[i] = arr [i];
            }
            return  newArr;
        }

    }
}
