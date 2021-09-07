package _5_access_modifier_static_method_static_property.exercise;

import com.sun.javaws.IconUtil;

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

class Circle{
    private double radius;
    private String color = "red";
    Circle (){
        this.radius = 1.0d;
        this.color = "red";
    }
    Circle (double radius){
        this.radius = radius;
    }
    Circle(String color){
        this();
        this.color = color;
    }
    Circle (double radius, String color){
        this.radius = radius;
        this.color = color;
    }

    public String getColor(){
        return color;
    }
    public double getRadius(){
        return radius;
    }
    public double getArea(){
        return Math.pow(radius,2)*Math.PI;
    }
}