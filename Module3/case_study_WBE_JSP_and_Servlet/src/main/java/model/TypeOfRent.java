package model;

public class TypeOfRent {
    private int idTypeOfRent;
    private String typeOfRent;
    private double price;

    public TypeOfRent() {
    }

    public TypeOfRent(int idTypeOfRent) {
        this.idTypeOfRent = idTypeOfRent;
    }

    public TypeOfRent(int id_type, String type, double price) {
        this.idTypeOfRent = id_type;
        this.typeOfRent = type;
        this.price = price;
    }

    public TypeOfRent(String type, double price) {
        this.typeOfRent = type;
        this.price = price;
    }

    public int getIdTypeOfRent() {
        return idTypeOfRent;
    }

    public void setIdTypeOfRent(int idTypeOfRent) {
        this.idTypeOfRent = idTypeOfRent;
    }

    public String getTypeOfRent() {
        return typeOfRent;
    }

    public void setTypeOfRent(String typeOfRent) {
        this.typeOfRent = typeOfRent;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "TypeOfRent{" +
                "id_type_of_rent=" + idTypeOfRent +
                ", type_of_rent='" + typeOfRent + '\'' +
                ", price=" + price +
                '}';
    }
}
