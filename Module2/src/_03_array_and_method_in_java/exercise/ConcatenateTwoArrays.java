package _03_array_and_method_in_java.exercise;

public class ConcatenateTwoArrays {
    public static void main(String[] args) {
        int [] arr1 = {1,2,3,4,5};
        int [] arr2 = {1,2,3,3,7,4,3};
        int [] newArr = concat(arr1,arr2);
        System.out.printf("\n%-20s%s", "Element in new Array: ", "");
        for (int i = 0; i < newArr.length; i++) {
            System.out.print(newArr[i] + "\t");
        }


    }
    public static int[] concat(int[] arr1, int[] arr2){
        int[] newArr = new int[arr1.length + arr2.length];
        for (int i = 0;i<arr1.length;i++){
            newArr[i]= arr1[i];
        }
        int j = 0;
        for (int i = arr1.length;i<newArr.length;i++){
            newArr[i] = arr2[j];
            j++;
        }
        return newArr;
    }
}
