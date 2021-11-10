package case_study.furama.model.facility;

public class Villa extends Facility {
    int roomStandard;
    int floor;
    double poolArea;


    public Villa() {
    }

    public Villa(String facilityName, double usingArea, double cost, int maximumPerson, String typeOfRent, int roomStandard, int floor, double poolArea) {
        super(facilityName, usingArea, cost, maximumPerson, typeOfRent);
        this.roomStandard = roomStandard;
        this.floor = floor;
        this.poolArea = poolArea;
    }

    public int getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(int roomStandard) {
        this.roomStandard = roomStandard;
    }

    public double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(double poolArea) {
        this.poolArea = poolArea;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }


    @Override
    public String toString() {
        return "Villa{" +
                super.toString() +
                "roomStandard=" + roomStandard +
                ", floor=" + floor +
                ", poolArea=" + poolArea +
                '}';
    }

    @Override
    public String toStringToFile() {
        return "Villa," + super.toStringToFile() +
                "," + roomStandard +
                "," + floor +
                "," + poolArea;
    }
}
