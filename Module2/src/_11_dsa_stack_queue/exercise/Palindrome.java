package _11_dsa_stack_queue.exercise;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class Palindrome {
    public static void main(String[] args) {

        System.out.println(isPalindrome("Able was I ere I saw Elba"));

    }

    static boolean isPalindrome(String str) {
        Queue<Character> queue = new ArrayDeque<>();
        Stack<Character> stack = new Stack<>();
        boolean flag = true;
        for (int i = 0; i < str.length(); i++) {
            queue.add(str.toLowerCase().charAt(i));
        }
        for (int i = 0; i < str.length(); i++) {
            stack.add(str.toLowerCase().charAt(i));
        }
        for (int i = 0; i < str.length(); i++) {
            if (queue.remove() != stack.pop()) {
                flag = false;
            }
        }
        return flag;
    }
}
