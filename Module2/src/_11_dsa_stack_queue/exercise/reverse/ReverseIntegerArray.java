package _11_dsa_stack_queue.exercise.reverse;

import java.util.Arrays;
import java.util.Stack;

public class ReverseIntegerArray {
    public static void main(String[] args) {
        int [] arr = new int[]{1,2,3,4,5};
        arr = reverse(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static int[] reverse(int[] arr){
        Stack<Integer> stack = new Stack<>();
        for (int i=0; i<arr.length;i++){
            stack.push(arr[i]);
        }
        for (int i=0; i<arr.length;i++){
            arr[i] = stack.pop();
        }
        return arr;
    }
}
