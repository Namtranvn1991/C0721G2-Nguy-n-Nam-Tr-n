package _19_string_and_regex.exercise;

import java.util.Scanner;

public class ValidateClassName {
    static boolean validateClassName(String className){

        //Tên một lớp học hợp lệ cần đạt các yêu cầu sau:
        //Bắt đầu bằng một ký tự chữ hoa C hoặc A hoặc P
        //Không chứa các ký tự đặc biệt
        //Theo sau ký tự bắt đầu là 4 ký tự số
        //Kết thúc phải là 1 trong những ký tự chữ hoa sau: G, H, I, K, L, M
        String regex = "[ACP]\\d{4}[GHIKLM]";
        return className.matches(regex);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String className = "";
        do{
            className = scanner.nextLine();
            if (!validateClassName(className)){
                System.out.println(className + " is not validate. Enter again");
            } else {
                System.out.println(className + " is validate");
            }
        } while (!validateClassName(className));




    }
}
