package _03_array_and_method_in_java.exercise;

import java.util.Scanner;

public class RemoveElement {
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

        System.out.println("\nEnter the number remove to Array ");
        int removeNunber = input.nextInt();

        int[] newArr = removeAllE(arr, removeNunber);
        System.out.printf("\n%-20s ", "Element in new Array: ");
        for (int a :newArr) {
            System.out.print(a + "\t");
        }

    }

    public static int[] removeFirstE(int[] arr, int number){
        int indexRemove=-1;
        for (int i = 0; i < arr.length; i++){
            if (arr[i]==number){
                indexRemove = i;
                break;
            }
        }
        if (indexRemove==-1){
            int[] newArr = new int[arr.length];
            for (int i=0;i<arr.length;i++){
                newArr[i]=arr[i];
            }
            return newArr;
        } else {
            int[] newArr = new int[arr.length-1];
            for (int i = 0; i < indexRemove; i++){
                newArr[i] = arr[i];
            }
            for (int i = indexRemove; i < arr.length-1; i++){
                newArr[i] = arr[i+1];
            }
            return newArr;
        }

    }
    public static int[] removeAllE(int[] arr, int number){
        int count=0;
        for (int i = 0; i < arr.length; i++){
            if (arr[i]==number){
                count++;
            }
        }
        if (count==0){
            int[] newArr = new int[arr.length];
            for (int i=0;i<arr.length;i++){
                newArr[i]=arr[i];
            }
            return newArr;
        } else {
            int[] newArr = new int[arr.length-count];
            for (int i=0,j=0;i<arr.length&&j<newArr.length;i++){
                if (arr[i] == number){
                    continue;
                } else {
                    newArr[j]= arr[i];
                    j++;
                }
            }
            return newArr;
        }



    }
}
