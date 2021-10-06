package case_study.homework2.model;

public class Customer {
    private String ID;
    private String name;

    public Customer() {
    }

    public Customer(String ID, String name) {
        this.ID = ID;
        this.name = name;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "ID='" + ID + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public String toStringToFile() {
        return ID + "," + name;
    }
}
