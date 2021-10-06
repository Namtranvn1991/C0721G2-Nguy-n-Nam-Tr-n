package case_study.homework.model;

public class Truck extends Vehicle {
    private int tonnage;

    public Truck() {
    }

    public Truck(String numberID, String brand, int yearOfManufacture, String owner, int tonnage) {
        super(numberID, brand, yearOfManufacture, owner);
        this.tonnage = tonnage;
    }

    public double getTonnage() {
        return tonnage;
    }

    public void setTonnage(int tonnage) {
        this.tonnage = tonnage;
    }

    @Override
    public String toString() {
        return super.toString() + "Truck{" +
                "tonnage=" + tonnage +
                '}';
    }
    public String toStringToFile() {
        return super.toStringToFile()+ tonnage;
    }
}
