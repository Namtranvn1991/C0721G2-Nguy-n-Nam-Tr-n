package _03_array_and_method_in_java.exercise;

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

        int[] arr = new int[size+1];
        for (int i = 0; i < arr.length -1; i++) {
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

        add(arr,addNunber,addIndex);

        System.out.printf("\n%-20s%s", "Element in new Array: ", "");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }

    }

    public static int[] add(int[] arr, int number, int index){

        for (int i = index; i < arr.length; i++){
            int temp = arr[i];
            arr[i] = number;
            number = temp;
        }
        return arr;
    }
}
