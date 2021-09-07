package _4_class_and_object_in_java.execise;


public class TestFan {
    public static void main(String[] args) {
        Fan fan1 = new Fan();
        Fan fan2 = new Fan(Fan.MEDIUM,true,10,"yellow");
        System.out.println(fan1.display());
        System.out.println(fan2.display());
        fan1.status = true;
        System.out.println(fan1.display());

    }
}

class Fan {
    public static final int SLOW = 1;
    public static final int MEDIUM = 2;
    public static final int FAST = 3;
    int speed = SLOW;
    String speedDisplay;
    boolean status = false;
    private int radius = 5;
    private String color = "blue";

    Fan(){
        speed = SLOW;
        status = false;
        int radius = 5;
        String color = "blue";
    }

    Fan(int speed, boolean status, int radius, String color){
        this.speed = speed;
        this.status = status;
        this.radius = radius;
        this.color = color;
    }

    public String getSpeed() {
        String temp;
        switch (speed){
            case 1: temp = "Slow"; break;
            case 2: temp = "Medium"; break;
            case 3:
            default:
                temp = "Fast";
//                throw new IllegalStateException("Unexpected value: " + speed);
        }
        return temp;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    String display(){
        if (status){
            return "Fan// Color: " + color + ". Radius: " + radius + ". Fan is on. Speed " + this.getSpeed();
        } else {
            return "Fan// Color: " + color + ". Radius: " + radius + ". Fan is off";
        }
    }
}
