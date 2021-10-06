package case_study.homework.model;

public abstract class Vehicle {
    private String numberID;
    private String brand;
    private int yearOfManufacture;
    private String owner;

    public Vehicle() {
    }

    public Vehicle(String numberID, String brand, int yearOfManufacture, String owner) {
        this.numberID = numberID;
        this.brand = brand;
        this.yearOfManufacture = yearOfManufacture;
        this.owner = owner;
    }

    public String getNumberID() {
        return numberID;
    }

    public void setNumberID(String numberID) {
        this.numberID = numberID;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getYearOfManufacture() {
        return yearOfManufacture;
    }

    public void setYearOfManufacture(int yearOfManufacture) {
        this.yearOfManufacture = yearOfManufacture;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "numberID=" + numberID +
                ", brand='" + brand + '\'' +
                ", yearOfManufacture=" + yearOfManufacture +
                ", owner='" + owner + '\'' +
                '}';
    }

    public String toStringToFile() {
        return numberID +
                "," + brand +
                "," + yearOfManufacture +
                "," + owner + ",";
    }
}
