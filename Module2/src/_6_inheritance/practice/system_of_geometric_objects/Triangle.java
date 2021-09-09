package _6_inheritance.practice.system_of_geometric_objects;

public class Triangle extends Shape {
    private double side1 = 0;
    private double side2 = 0;
    private double side3 = 0;

    public Triangle() {
    }

    public Triangle(double side1, double side2, double side3) {
        if (side1 < (side2 + side3) && side2 < (side1 + side3) && side3 < (side1 + side2)) {
            this.side1 = side1;
            this.side2 = side2;
            this.side3 = side3;
        } else {
            System.out.println("Triangle with 3 side (" + side1 + "," + side2 + "," + side3 + ") inst exist");
        }
    }

    public Triangle(String color, boolean filled, double side1, double side2, double side3) {
        super(color, filled);
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public double getSide1() {
        return side1;
    }

    public void setSide1(double side1) {
        this.side1 = side1;
    }

    public double getSide2() {
        return side2;
    }

    public void setSide2(double side2) {
        this.side2 = side2;
    }

    public double getSide3() {
        return side3;
    }

    public void setSide3(double side3) {
        this.side3 = side3;
    }

    public double getPerimeter() {
        return side1 + side2 + side3;
    }

    public double getArea() {
        double p = getPerimeter();
        return Math.pow(p * (p - side1) * (p - side2) * (p - side3), 0.5);
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "side1=" + side1 +
                ", side2=" + side2 +
                ", side3=" + side3 +
                '}';
    }

    public static void main(String[] args) {
        Triangle triangle = new Triangle(1, 2, 3);
        System.out.println(triangle);
        System.out.println(triangle.getArea());
    }
}
