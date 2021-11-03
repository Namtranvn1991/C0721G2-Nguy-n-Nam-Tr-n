package model;

public class TypeOfService {
    private int idTypeOfService;
    private String typeOfService;

    public TypeOfService() {
    }

    public TypeOfService(int idTypeOfService) {
        this.idTypeOfService = idTypeOfService;
    }

    public TypeOfService(int id_type_of_service, String type_of_service) {
        this.idTypeOfService = id_type_of_service;
        this.typeOfService = type_of_service;
    }

    public TypeOfService(String type_of_service) {
        this.typeOfService = type_of_service;
    }

    public int getIdTypeOfService() {
        return idTypeOfService;
    }

    public void setIdTypeOfService(int idTypeOfService) {
        this.idTypeOfService = idTypeOfService;
    }

    public String getTypeOfService() {
        return typeOfService;
    }

    public void setTypeOfService(String typeOfService) {
        this.typeOfService = typeOfService;
    }

    @Override
    public String toString() {
        return "TypeOfService{" +
                "id_type_of_service=" + idTypeOfService +
                ", type_of_service='" + typeOfService + '\'' +
                '}';
    }
}
