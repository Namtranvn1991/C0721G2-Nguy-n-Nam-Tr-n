package case_study.furama.model.facility;

import java.io.Serializable;
import java.util.Objects;

public class Facility implements Comparable<Facility>, Serializable {
    private String facilityName;
    private double usingArea;
    private double cost;
    private int maximumPerson;
    private String typeOfRent;


    public static final String HOURLY_RENTAL = "Hourly Rental";
    public static final String DAILY_RENTAL = "Daily Rental";
    public static final String MONTHLY_RENTAL = "Monthly Rental";
    public static final String YEARLY_RENTAL = "Yearly Rental";


    public Facility() {
    }

    public Facility(String facilityName, double usingArea, double cost, int maximumPerson, String typeOfRent) {
        this.facilityName = facilityName;
        this.usingArea = usingArea;
        this.cost = cost;
        this.maximumPerson = maximumPerson;
        this.typeOfRent = typeOfRent;
    }

    public String getFacilityName() {
        return facilityName;
    }

    public void setFacilityName(String facilityName) {
        this.facilityName = facilityName;
    }

    public double getUsingArea() {
        return usingArea;
    }

    public void setUsingArea(double usingArea) {
        this.usingArea = usingArea;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getMaximumPerson() {
        return maximumPerson;
    }

    public void setMaximumPerson(int maximumPerson) {
        this.maximumPerson = maximumPerson;
    }

    public String getTypeOfRent() {
        return typeOfRent;
    }

    public void setTypeOfRent(String typeOfRent) {
        this.typeOfRent = typeOfRent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Facility facility = (Facility) o;
        return facilityName.equals(facility.facilityName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(facilityName);
    }

    @Override
    public String toString() {
        return "facilityName='" + facilityName + '\'' +
                ", usingArea=" + usingArea +
                ", cost=" + cost +
                ", maximumPerson=" + maximumPerson +
                ", typeOfRent=" + typeOfRent + ", ";
    }

    public String toStringToFile() {
        return facilityName +
                "," + usingArea +
                "," + cost +
                "," + maximumPerson +
                "," + typeOfRent;
    }


    @Override
    public int compareTo(Facility o) {
        return this.getFacilityName().compareTo(o.getFacilityName());
    }
}
