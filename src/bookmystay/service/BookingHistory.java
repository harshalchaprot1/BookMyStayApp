package bookmystay.service;

import bookmystay.model.Reservation;
import java.util.ArrayList;
import java.util.List;

/**
 * Use Case 8: Booking History & Reporting
 *
 * Maintains a record of confirmed reservations.
 * Provides ordered storage for historical and reporting purposes.
 *
 * @author Harshal
 * @version 8.0
 */
public class BookingHistory {
    private List<Reservation> confirmedReservations;

    /** Initializes an empty booking history. */
    public BookingHistory() {
        confirmedReservations = new ArrayList<>();
    }

    /** Adds a confirmed reservation to booking history. */
    public void addReservation(Reservation reservation) {
        confirmedReservations.add(reservation);
    }

    /** Returns all confirmed reservations. */
    public List<Reservation> getConfirmedReservations() {
        return confirmedReservations;
    }
}
