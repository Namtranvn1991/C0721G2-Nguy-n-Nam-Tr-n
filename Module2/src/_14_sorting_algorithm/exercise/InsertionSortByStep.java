package _14_sorting_algorithm.exercise;

import java.util.Arrays;

public class InsertionSortByStep {
    public static void main(String args[]) {
        int arr[] = {12, 11, 13, 5, 6};
        System.out.println("before" + Arrays.toString(arr));
        sort(arr);
        System.out.println("after" + Arrays.toString(arr));
    }

    static void sort(int arr[]) {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int temp = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > temp) {

                arr[j + 1] = arr[j];
                j--;
            }
            System.out.println("Swap " + temp + " with " + arr[j + 1]);
            arr[j + 1] = temp;
            System.out.println(Arrays.toString(arr));
        }
    }



}
