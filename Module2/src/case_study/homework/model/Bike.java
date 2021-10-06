package case_study.homework.model;

public class Bike extends Vehicle {
    int wattage;

    public Bike() {
    }

    public Bike(String numberID, String brand, int yearOfManufacture, String owner, int wattage) {
        super(numberID, brand, yearOfManufacture, owner);
        this.wattage = wattage;
    }

    public double getWattage() {
        return wattage;
    }

    public void setWattage(int wattage) {
        this.wattage = wattage;
    }

    @Override
    public String toString() {
        return super.toString() + "Bike{" +
                "wattage=" + wattage +
                '}';
    }

    public String toStringToFile() {
        return super.toStringToFile() + wattage;
    }
}
