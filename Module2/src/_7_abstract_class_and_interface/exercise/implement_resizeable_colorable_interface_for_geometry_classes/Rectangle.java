package _7_abstract_class_and_interface.exercise.implement_resizeable_colorable_interface_for_geometry_classes;

public class Rectangle extends Shape {
    private double width;
    private double length;

    public Rectangle() {
    }

    public Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }

    public Rectangle(double width, double length, String color, boolean filled) {
        super(color, filled);
        this.width = width;
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getArea() {
        return this.width * this.length;
    }

    public double getPerimeter() {
        return (this.width + this.length) * 2;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "width=" + this.width +
                ", length=" + this.length +
                '}' + " area=" + this.getArea() +
                " which is a subclass of " + super.toString();
    }

    @Override
    public Rectangle resize(double percent) {
        Rectangle rectangle = new Rectangle(this.width * percent / 100, this.length * percent / 100);
        return rectangle;
    }

    @Override
    public void resizeItself(double percent) {
        this.width = this.width * percent / 100;
        this.length = this.length * percent / 100;
    }
}
