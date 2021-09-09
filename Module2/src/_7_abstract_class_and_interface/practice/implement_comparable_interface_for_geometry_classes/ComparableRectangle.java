package _7_abstract_class_and_interface.practice.implement_comparable_interface_for_geometry_classes;

public class ComparableRectangle extends Rectangle implements Comparable<ComparableRectangle> {
    public ComparableRectangle() {
    }

    public ComparableRectangle(double width, double length) {
        super(width, length);
    }

    public ComparableRectangle(String color, boolean filled, double width, double length) {
        super(color, filled, width, length);
    }

    @Override
    public int compareTo(ComparableRectangle o) {
        if (getPerimeter()>=o.getPerimeter()){
            return 1;
        } else {
            return -1;
        }
    }
}
