package case_study.furama.model.facility;

public class Villa extends Facility {
    int roomStandard;
    double poolArea;
    int floor;

    public Villa() {
    }

    public Villa(String facilityName, double usingArea, double cost, int maximumPerson, String typeOfRent, int roomStandard, double poolArea, int floor) {
        super(facilityName, usingArea, cost, maximumPerson, typeOfRent);
        this.roomStandard = roomStandard;
        this.poolArea = poolArea;
        this.floor = floor;
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
                super.toString()+
                "roomStandard=" + roomStandard +
                ", poolArea=" + poolArea +
                ", floor=" + floor +
                '}';
    }
}
