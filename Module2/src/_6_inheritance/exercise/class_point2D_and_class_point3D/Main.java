package _6_inheritance.exercise.class_point2D_and_class_point3D;

public class Main {
    public static void main(String[] args) {
        Point3D point3D = new Point3D(1,2,3);
        System.out.println(point3D);
        point3D.setXYZ(3,2,1);
        System.out.println(point3D);
    }
}
