package model;

public class TypeOfRent {
    private int id_type;
    private String type;
    private double price;

    public TypeOfRent() {
    }

    public TypeOfRent(int id_type, String type, double price) {
        this.id_type = id_type;
        this.type = type;
        this.price = price;
    }

    public TypeOfRent(String type, double price) {
        this.type = type;
        this.price = price;
    }

    public int getId_type() {
        return id_type;
    }

    public void setId_type(int id_type) {
        this.id_type = id_type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
