package _4_class_and_object_in_java.practice.test_class_rectangle;

import java.util.Scanner;

public class TestClassRectangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the width:");
        double width = scanner.nextDouble();
        System.out.print("Enter the height:");
        double height = scanner.nextDouble();

        Rectangle rectangle1 = new Rectangle(width,height);
        System.out.println(rectangle1.display());
        System.out.printf("Area of rectangle with width %s and height %s is %s \n", rectangle1.width,rectangle1.height,rectangle1.getArea());
        rectangle1.draw();


    }
}
