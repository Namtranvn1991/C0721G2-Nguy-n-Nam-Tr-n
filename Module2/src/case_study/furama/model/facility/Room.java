package case_study.furama.model.facility;

public class Room extends Facility {
    private String freeService;

    public static final String FREE_SPA = "free spa";
    public static final String FREE_GAMING = "free gaming";
    public static final String FREE_DRINK = "free drink";

    public Room() {
    }

    public Room(String facilityName, double usingArea, double cost, int maximumPerson, String typeOfRent, String freeService) {
        super(facilityName, usingArea, cost, maximumPerson, typeOfRent);
        this.freeService = freeService;
    }

    public String getFreeService() {
        return freeService;
    }

    public void setFreeService(String freeService) {
        this.freeService = freeService;
    }

    @Override
    public String toString() {
        return "Room{" +
                super.toString() +
                "freeService='" + freeService + '\'' +
                '}';
    }
}
