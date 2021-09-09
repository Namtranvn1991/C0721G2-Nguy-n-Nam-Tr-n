package _6_inheritance.exercise.class_point_and_moveable_point;

public class Point {
    private float x = 0f;
    private float y = 0f;

    public Point() {
    }

    public Point(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void setXY(float x, float y) {
        this.y = y;
        this.x = x;
    }

    public float[] getXY() {
        float[] xy = {x, y};
        return xy;
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }
}
