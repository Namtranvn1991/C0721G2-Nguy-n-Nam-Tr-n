package test;

import java.util.Arrays;
import java.util.Scanner;

public class test123 {
    public static void main(String[] args) {
        String str = "asdqweasd";
        char[] arr = new char[str.length()];
        boolean flag = false;
        int count =0;
        for (int i = 0; i < str.length(); i++) {
            flag = false;
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(i) == arr[j]) {
                    flag = true;
                    break;
                }
            }
            if (!flag){
                arr[i] = str.charAt(i);
                count++;
            }

        }
        System.out.println(count);

    }


}

