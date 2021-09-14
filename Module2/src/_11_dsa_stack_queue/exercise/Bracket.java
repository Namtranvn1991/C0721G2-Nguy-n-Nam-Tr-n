package _11_dsa_stack_queue.exercise;

import java.util.Stack;

public class Bracket {
    public static void main(String[] args) {
        String str = "(s * (s – a) * (s – b) * (s – c)) ";
        System.out.println(checkBracket(str));


    }
    static boolean checkBracket(String str){
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i <str.length() ; i++) {
            if (str.charAt(i) == '('){
                stack.push(i);
            } else if( str.charAt(i) == ')'){
                if (!stack.empty()){
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        if (stack.empty()){
            return true;
        } else {
            return false;
        }
    }
}
