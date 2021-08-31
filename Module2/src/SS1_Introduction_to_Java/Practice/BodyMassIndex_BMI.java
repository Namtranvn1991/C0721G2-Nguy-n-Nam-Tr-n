package SS1_Introduction_to_Java.Practice;

import java.util.Scanner;

public class BodyMassIndex_BMI {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Your weight (kg) ");
        double weight = scanner.nextDouble();
        System.out.printf("Your height (meter) ");
        double height = scanner.nextDouble();
        double bmi = weight/Math.pow(height,2);
        System.out.printf("%-20s%s", "bmi", "Interpretation\n");
        if (bmi < 18)
            System.out.printf("%-20.2f%s", bmi, "Underweight");
        else if (bmi < 25.0)
            System.out.printf("%-20.2f%s", bmi, "Normal");
        else if (bmi < 30.0)
            System.out.printf("%-20.2f%s", bmi, "Overweight");
        else
            System.out.printf("%-20.2f%s", bmi, "Obese");


    }
}
