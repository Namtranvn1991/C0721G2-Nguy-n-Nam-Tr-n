package _11_dsa_stack_queue.exercise.reverse;

import java.util.Arrays;
import java.util.Stack;

public class ReverseString {
    public static void main(String[] args) {
        String string = "hello";
        string = reverse(string);
        System.out.println(string);
    }

    public static String reverse(String str){
        Stack<Character> stack = new Stack<>();
        for (int i=0; i<str.length();i++){
            stack.push(str.charAt(i));
        }
        char[] chars = new char[str.length()];
        for (int i=0; i<str.length();i++){
            chars[i] = stack.pop();
        }
        str = String.valueOf(chars);
        return str;
    }
}
