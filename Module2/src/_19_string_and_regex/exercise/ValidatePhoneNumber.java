package _19_string_and_regex.exercise;

import java.util.Scanner;

public class ValidatePhoneNumber {
    static boolean validatePhoneNumber (String phoneNumber){
        String regex = "[(]\\d{2}[)][-][(][0]\\d{9}[)]";
        return phoneNumber.matches(regex);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String phoneNumber = "";
        do{
            phoneNumber = scanner.nextLine();
            if (!validatePhoneNumber(phoneNumber)){
                System.out.println(phoneNumber + " is not validate. Enter again");
            } else {
                System.out.println(phoneNumber + " is validate");
            }
        } while (!validatePhoneNumber(phoneNumber));
    }
}
