package _6_inheritance.exercise.class_point2D_and_class_point3D;

public class Point3D extends Point2D {
    private float z = 0f;

    public Point3D() {
    }

    public Point3D(float x, float y, float z) {
        super(x, y);
        this.z = z;
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }

    public void setXYZ(float x, float y, float z) {
        super.setX(x);
        super.setY(y);
        this.z = z;
    }

    public float[] getXY() {
        float[] xyz = {super.getX(), super.getY(), z};
        return xyz;
    }

    @Override
    public String toString() {
        return "(" + super.getX() + "," + super.getY() + "," + z + ")";
    }
}
