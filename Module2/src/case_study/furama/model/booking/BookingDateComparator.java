package case_study.furama.model.booking;

import java.util.Comparator;

public class BookingDateComparator implements Comparator<Booking> {
    @Override
    public int compare(Booking o1, Booking o2) {
        return o1.getBookingDate().compareTo(o2.getBookingDate());
    }
}
