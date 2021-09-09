package _7_abstract_class_and_interface.practice.implement_comparable_interface_for_geometry_classes;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ComparableCircle[] circles = new ComparableCircle[3];
        circles[0] = new ComparableCircle(3.6);
        circles[1] = new ComparableCircle();
        circles[2] = new ComparableCircle(3.5, "indigo", false);
        System.out.println("Pre-sorted:");
        for (ComparableCircle circle : circles) {
            System.out.println(circle);
        }

        Arrays.sort(circles);

        System.out.println("After-sorted:");
        for (ComparableCircle circle : circles) {
            System.out.println(circle);
        }

        ComparableRectangle[] rectangles = new ComparableRectangle[3];
        rectangles[0] = new ComparableRectangle(3,2);
        rectangles[1] = new ComparableRectangle("blue",false,2,2);
        rectangles[2] = new ComparableRectangle(2,3);
        System.out.println("Pre-sorted:");
        for (ComparableRectangle rectangle: rectangles) {
            System.out.println(rectangle);
        }

        Arrays.sort(rectangles);

        System.out.println("After-sorted:");
        for (ComparableRectangle rectangle: rectangles) {
            System.out.println(rectangle);
        }


    }
}
