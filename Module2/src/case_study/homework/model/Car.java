package case_study.homework.model;

public class Car extends Vehicle {
    private int seats;
    private String type;
    public static final String TRAVEL = "travel";
    public static final String BUS = "bus";

    public Car() {
    }

    public Car(String numberID, String brand, int yearOfManufacture, String owner, int seats, String type) {
        super(numberID, brand, yearOfManufacture, owner);
        this.seats = seats;
        this.type = type;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return super.toString() + "Car{" +
                "seats=" + seats +
                ", type='" + type + '\'' +
                '}';
    }


    public String toStringToFile() {
        return super.toStringToFile() + seats;
    }

}
