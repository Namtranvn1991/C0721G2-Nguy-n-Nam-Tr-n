package _7_abstract_class_and_interface.exercise.implement_resizeable_colorable_interface_for_geometry_classes;

public class Circle extends Shape{

    private double radius = 1.0;

    public Circle() {
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(double radius, String color, boolean filled) {
        super(color, filled);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        return radius * radius * Math.PI;
    }

    public double getPerimeter() {
        return 2 * radius * Math.PI;
    }

    @Override
    public String toString() {
        return "A Circle with radius="
                + getRadius()
                + " with Area="
                + getArea()
                + ", which is a subclass of "
                + super.toString();
    }

    @Override
    public Circle resize(double percent) {
        Circle circle = new Circle(this.radius*percent/100);
        return circle;
    }

    @Override
    public void resizeItself(double percent) {
        this.radius = this.radius*percent/100;
    }
}
