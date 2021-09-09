package _6_inheritance.exercise.class_point_and_moveable_point;

public class MoveablePoint extends Point {
    private float xSpeed = 0f;
    private float ySpeed = 0f;

    public MoveablePoint() {
    }

    public MoveablePoint(float xSpeed, float ySpeed) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public MoveablePoint(float x, float y, float xSpeed, float ySpeed) {
        super(x, y);
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public float getXSpeed() {
        return xSpeed;
    }

    public void setXSpeed(float xSpeed) {
        this.xSpeed = xSpeed;
    }

    public float getYSpeed() {
        return ySpeed;
    }

    public void setYSpeed(float ySpeed) {
        this.ySpeed = ySpeed;
    }

    public void setSpeed(float xSpeed, float ySpeed) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public float[] getSpeed() {
        float[] xySpeed = {xSpeed, ySpeed};
        return xySpeed;
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + "),speed=(" + xSpeed + "," + ySpeed + ")";
    }

    public void move() {
        x += xSpeed;
        y += ySpeed;
    }
}
