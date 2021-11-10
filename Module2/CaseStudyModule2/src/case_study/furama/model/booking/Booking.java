package case_study.furama.model.booking;

import case_study.furama.model.facility.Facility;
import case_study.furama.model.person.Customer;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Booking implements Comparable<Booking>, Serializable {
    private int bookingID;
    private Customer customer;
    private Facility facility;
    private Date bookingDate;
    private Date checkoutDate;


    public Booking() {
    }

    public Booking(int bookingID, Customer customer, Facility facility, Date bookingDate, Date checkoutDate) {
        this.bookingID = bookingID;
        this.customer = customer;
        this.facility = facility;
        this.bookingDate = bookingDate;
        this.checkoutDate = checkoutDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Facility getFacility() {
        return facility;
    }

    public void setFacility(Facility facility) {
        this.facility = facility;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    public Date getCheckoutDate() {
        return checkoutDate;
    }

    public void setCheckoutDate(Date checkoutDate) {
        this.checkoutDate = checkoutDate;
    }

    public int getBookingID() {
        return bookingID;
    }

    public void setBookingID(int bookingID) {
        this.bookingID = bookingID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Booking booking = (Booking) o;
        return bookingID == booking.bookingID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookingID);
    }

    public String toStringToFile(){
        return  bookingID +
                "," + customer.getCustomerID() +
                "," + facility.getFacilityName() +
                "," + bookingDate.getDate() + "/" + (bookingDate.getMonth()+1) + "/" + (bookingDate.getYear()+1900) +
                "," + checkoutDate.getDate() + "/" + (checkoutDate.getMonth()+1) + "/" + (checkoutDate.getYear()+1900);
    }

    @Override
    public String toString() {
        return "Booking{" +
                "Booking ID=" + bookingID +
                ", customer=" + customer.getName() +
                ", facility=" + facility.getFacilityName() +
                ", bookingDate=" + bookingDate.getDate() + "/" + (bookingDate.getMonth()+1) + "/" + (bookingDate.getYear()+1900) +
                ", checkoutDate=" + checkoutDate.getDate() + "/" + (checkoutDate.getMonth()+1) + "/" + (checkoutDate.getYear()+1900) +
                '}';
    }

    @Override
    public int compareTo(Booking o) {
        if (this.bookingID == o.bookingID){
            return this.bookingID - o.bookingID;
        }

        if (this.bookingDate.compareTo(o.bookingDate)==0){
            if (this.checkoutDate.compareTo(o.getCheckoutDate())==0){
                if (this.getCustomer().getCustomerID()==o.getCustomer().getCustomerID()){
                    return this.getFacility().getFacilityName().compareTo(o.getFacility().getFacilityName());
                } return this.getCustomer().getCustomerID()-o.getCustomer().getCustomerID();
            }else {
                return this.checkoutDate.compareTo(o.getCheckoutDate());
            }
        } else {
            return this.bookingDate.compareTo(o.bookingDate);
        }
    }
}
