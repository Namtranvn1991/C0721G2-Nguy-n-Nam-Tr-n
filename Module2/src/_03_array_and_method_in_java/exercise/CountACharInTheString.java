package _03_array_and_method_in_java.exercise;

import com.sun.javaws.IconUtil;

import java.util.Scanner;

public class CountACharInTheString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = "cong hoa xa hoi";
        System.out.println("Enter char you want to count");
        char a = scanner.next().charAt(0);
        System.out.println("Char " + a + " appear " + countChar(str,a)+ " times");

    }
    static int countChar(String str, char a){
        int count = 0;
        for (int i=0;i<str.length();i++){
            if (str.charAt(i)==a){
                count++;
            }
        }
        return count;

    }
}
