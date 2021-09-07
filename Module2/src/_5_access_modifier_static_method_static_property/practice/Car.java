package _5_access_modifier_static_method_static_property.practice;

public class Car {

    private String name;

    private String engine;

    private static int numberOfCars;

    public Car(String name, String engine) {

        this.name = name;

        this.engine = engine;

        numberOfCars++;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public static int getNumberOfCars() {
        return numberOfCars;
    }
}
