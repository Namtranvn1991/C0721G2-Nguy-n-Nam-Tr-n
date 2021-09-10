package _7_abstract_class_and_interface.exercise.implement_resizeable_colorable_interface_for_geometry_classes;

public class Square extends Rectangle implements Colorable {
    public double side;

    public Square() {
    }

    public Square(double side) {
        super(side, side);
        this.side = side;
    }

    public Square(double side, String color, boolean filled) {
        super(side, side, color, filled);
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }


    @Override
    public void setWidth(double side) {
        super.setWidth(side);
        super.setLength(side);
        this.side = side;

    }


    @Override
    public void setLength(double side) {
        super.setWidth(side);
        super.setLength(side);
        this.side = side;
    }


    @Override
    public String toString() {
        return "Square{" +
                "side=" + this.getSide() +
                '}' +
                "area=" + this.getArea() +
                " which is a subclass of " + this.toStr();
    }

    @Override
    public Square resize(double percent) {
        Square square = new Square(this.side * percent / 100);
        return square;
    }

    @Override
    public void resizeItself(double percent) {
        super.resizeItself(percent);
        this.side = this.side * percent / 100;
    }

    public static void main(String[] args) {
        Square square = new Square();
        square.setWidth(3);
        square.resizeItself(300);
        System.out.println(square);
    }

    @Override
    public void howToColor() {
        System.out.println("Color all four sides is " + this.getColor());
    }
}
