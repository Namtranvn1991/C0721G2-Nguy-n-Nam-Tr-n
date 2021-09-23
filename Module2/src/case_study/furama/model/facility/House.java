package case_study.furama.model.facility;

public class House extends Facility {
    int roomStandard;
    int floor;

    public House() {
    }

    public House(String facilityName, double usingArea, double cost, int maximumPerson, String typeOfRent, int roomStandard, int floor) {
        super(facilityName, usingArea, cost, maximumPerson, typeOfRent);
        this.roomStandard = roomStandard;
        this.floor = floor;
    }

    public int getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(int roomStandard) {
        this.roomStandard = roomStandard;
    }


    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    @Override
    public String toString() {
        return "House{" +
                super.toString() +
                "roomStandard=" + roomStandard +
                ", floor=" + floor +
                '}';
    }

    @Override
    public String toStringToFile() {
        return "House," + super.toStringToFile() +
                "," + roomStandard +
                "," + floor;
    }


}
