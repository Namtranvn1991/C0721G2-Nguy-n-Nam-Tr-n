package _11_dsa_stack_queue.exercise;

import java.util.Stack;

public class ConvertDecimalToBinary {
    public static void main(String[] args) {
        System.out.println(convertDecimalToBinary(44));

    }

    static String convertDecimalToBinary(int number) {
        Stack<Integer> stack = new Stack<>();
        if (number==0){
            return 0+"";
        } else if (number<0){
            throw new RuntimeException("input cant < 0");
        }else {
            while (number!= 0){
                int remainder = number % 2;
                stack.push(remainder);
                number = number / 2;
            }
            String str= "";
            while (!stack.empty()){
                str += stack.pop();
            }
            return str;
        }
    }
}
