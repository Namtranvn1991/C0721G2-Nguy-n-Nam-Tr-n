package _03_array_and_method_in_java.practice;

public class FindMinElement {
    public static void main(String[] args) {
        int []arr = {4, 12, 7, 8, 5, 6, 9};
        int indexMin = findMin(arr);
        System.out.println("The smallest element in the array is: " + arr[indexMin]);
    }
    public static int findMin(int[] array){
        int index =0;
        for (int i =0;i<array.length;i++){
            if (array[index]>array[i]){
                index = i;
            }
        }
        return index;
    }
}
