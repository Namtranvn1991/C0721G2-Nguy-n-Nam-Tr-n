package _13_search_algorithm.exercise;

import javax.xml.bind.annotation.XmlID;

public class BinarySearchUseRecursive {
    public static void main(String[] args) {
        int[] list = {2, 4, 7, 10, 11, 45, 50, 59, 60, 66, 69, 70, 79};
        System.out.println(binarySearch(list,66,0,list.length-1));
    }
    static int binarySearch(int array[], int x, int low, int high) {

        if (high >= low) {
            int mid = low + (high - low) / 2;
            if (array[mid] == x) return mid;
            if (array[mid] > x) return binarySearch(array, x, low, mid - 1);
            return binarySearch(array, x, mid + 1, high);
        }
        return -1;
    }
}
