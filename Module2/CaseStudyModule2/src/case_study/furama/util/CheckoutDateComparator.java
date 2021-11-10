package case_study.furama.util;

import case_study.furama.model.booking.Booking;

import java.util.Comparator;

public class CheckoutDateComparator implements Comparator<Booking> {
    @Override
    public int compare(Booking o1, Booking o2) {
        return o1.getCheckoutDate().compareTo(o2.getCheckoutDate());
    }
}
