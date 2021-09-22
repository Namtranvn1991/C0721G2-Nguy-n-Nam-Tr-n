package case_study.furama.model.contract;

import case_study.furama.model.booking.Booking;
import case_study.furama.model.facility.Facility;

public class Contract {
    private Booking booking;
    private int number;
    private int contractID;
    private String paymentMethod;

    public final String CASH = "cash";
    public final String CREDIT = "credit";

    public Contract() {
    }




    @Override
    public String toString() {
        return "Contract{" +
                "booking=" + booking.getCustomer().getName() + "/" + booking.getFacility().getFacilityName() +

                ", number=" + number + " (" + booking.getFacility().getTypeOfRent() + ")" +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", total=" + number * booking.getFacility().getCost() +
                '}';
    }
}
