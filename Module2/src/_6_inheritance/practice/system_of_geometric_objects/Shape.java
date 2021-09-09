package _6_inheritance.practice.system_of_geometric_objects;

public class Shape {
    protected String color ="green";
    protected boolean filled = true;

    public Shape() {
    }

    public Shape(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    @Override
    public String toString() {
        String status;
        if (this.filled) {
            status = "filled";
        } else {
            status = "not filled";
        }

        return "A Shape with color of " + getColor() + " and " + isFilled();
    }
}
