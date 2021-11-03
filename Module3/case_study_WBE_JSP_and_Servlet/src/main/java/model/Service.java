package model;

public class Service {
    private int id_service;
    private String name_service;
    private int area;
    private int floor;
    private int max_people;
    private String status;
    private TypeOfRent typeOfRent;
    private TypeOfService typeOfService;

    public Service() {
    }

    public Service(int id_service, String name_service, int area, int floor, int max_people, String status, TypeOfRent typeOfRent, TypeOfService typeOfService) {
        this.id_service = id_service;
        this.name_service = name_service;
        this.area = area;
        this.floor = floor;
        this.max_people = max_people;
        this.status = status;
        this.typeOfRent = typeOfRent;
        this.typeOfService = typeOfService;
    }

    public Service(String name_service, int area, int floor, int max_people, String status, TypeOfRent typeOfRent, TypeOfService typeOfService) {
        this.name_service = name_service;
        this.area = area;
        this.floor = floor;
        this.max_people = max_people;
        this.status = status;
        this.typeOfRent = typeOfRent;
        this.typeOfService = typeOfService;
    }

    public int getId_service() {
        return id_service;
    }

    public void setId_service(int id_service) {
        this.id_service = id_service;
    }

    public String getName_service() {
        return name_service;
    }

    public void setName_service(String name_service) {
        this.name_service = name_service;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getMax_people() {
        return max_people;
    }

    public void setMax_people(int max_people) {
        this.max_people = max_people;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public TypeOfRent getTypeOfRent() {
        return typeOfRent;
    }

    public void setTypeOfRent(TypeOfRent typeOfRent) {
        this.typeOfRent = typeOfRent;
    }

    public TypeOfService getTypeOfService() {
        return typeOfService;
    }

    public void setTypeOfService(TypeOfService typeOfService) {
        this.typeOfService = typeOfService;
    }
}
