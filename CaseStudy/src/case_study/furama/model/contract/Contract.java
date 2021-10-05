package case_study.furama.model.contract;

import case_study.furama.model.booking.Booking;
import case_study.furama.model.facility.Facility;

import java.io.Serializable;

public class Contract implements Serializable {

    private int contractID;
    private Booking booking;
    private int deposit;
    private int totalPayment;

    public Contract() {
    }

    public Contract(int contractID, Booking booking, int deposit, int totalPayment) {
        this.contractID = contractID;
        this.booking = booking;
        this.deposit = deposit;
        this.totalPayment = totalPayment;
    }

    public int getContractID() {
        return contractID;
    }

    public void setContractID(int contractID) {
        this.contractID = contractID;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public int getDeposit() {
        return deposit;
    }

    public void setDeposit(int deposit) {
        this.deposit = deposit;
    }

    public int getTotalPayment() {
        return totalPayment;
    }

    public void setTotalPayment(int totalPayment) {
        this.totalPayment = totalPayment;
    }

    @Override
    public String toString() {
        return "Contract{" +
                "contractID=" + contractID +
                ", bookingID=" + booking.getBookingID() +
                ", customerID=" + booking.getCustomer().getCustomerID() +
                ", facilityName=" + booking.getFacility().getFacilityName() +
                ", deposit=" + deposit +
                ", totalPayment=" + totalPayment +
                '}';
    }

    public String toStringToFile() {
        return  contractID +
                "," + booking.getBookingID() +
                "," + booking.getCustomer().getCustomerID() +
                "," + booking.getFacility().getFacilityName() +
                "," + deposit +
                "," + totalPayment;
    }
}
