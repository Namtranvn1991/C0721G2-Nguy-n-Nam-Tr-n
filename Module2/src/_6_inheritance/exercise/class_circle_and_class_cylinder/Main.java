package _6_inheritance.exercise.class_circle_and_class_cylinder;

public class Main {
    public static void main(String[] args) {
        Cylinder cylinder = new Cylinder(5,5,"blue");
        System.out.println(cylinder);
//        System.out.println(cylinder.getArea());
//        System.out.println(cylinder.getVolume());

        Circle circle = new Circle(2,"blue");
        System.out.println(circle.getArea());

    }
}
