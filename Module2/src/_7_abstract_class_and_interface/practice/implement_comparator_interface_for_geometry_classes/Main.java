package _7_abstract_class_and_interface.practice.implement_comparator_interface_for_geometry_classes;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Circle[] circles = new Circle[3];
        circles[0] = new Circle(3);
        circles[1] = new Circle(2);
        circles[2] = new Circle(4);
        System.out.println("After-sorted:");
        for (Circle circle: circles) {
            System.out.println(circle);
        }
        CircleComparator circleComparator = new CircleComparator();
        Arrays.sort(circles,circleComparator);
        System.out.println("Pre-sorted:");
        for (Circle circle: circles) {
            System.out.println(circle);
        }
    }
}
