package _5_access_modifier_static_method_static_property.exercise.test_access_modifier;

public class TestAccessModifier {
    public static void main(String[] args) {
        Circle circle;
        circle = new Circle(3);
        System.out.println(circle.getRadius());
        System.out.println(circle.getArea());
        Circle circle1 = new Circle("blue");
        System.out.println(circle1.getColor());
    }
}

