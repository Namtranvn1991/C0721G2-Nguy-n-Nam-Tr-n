package util;


public class Validate {

    public static boolean validateBorrowCode(String code) {
        String regex = "MS-\\d{4}";
        return code.matches(regex);
    }






    public static boolean validatePositiveDouble(double number){
        return number>=0;
    }

    public static boolean validatePositiveInt(int number){
        return number>=0;
    }



}
