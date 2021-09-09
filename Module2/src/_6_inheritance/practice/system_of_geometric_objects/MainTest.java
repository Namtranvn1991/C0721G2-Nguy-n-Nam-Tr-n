package _6_inheritance.practice.system_of_geometric_objects;

public class MainTest {
    public static void main(String[] args) {
        Circle circle = new Circle(6.9);
        System.out.println(circle.getColor());

        Square square = new Square();
        System.out.println(square);

        square = new Square(6.9);
        System.out.println(square);

        square = new Square(13.69, "blue", false);
        System.out.println(square);
    }
}
