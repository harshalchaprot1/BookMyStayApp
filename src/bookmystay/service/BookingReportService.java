package bookmystay.service;

/**
 * Use Case 8: Booking Report Service
 *
 * Generates reports from booking history data.
 * Reporting logic is separated from data storage.
 *
 * @author Harshal
 * @version 8.0
 */
public class BookingReportService {

    /** Displays a summary report of all confirmed bookings. */
    public void generateReport(BookingHistory history) {
        System.out.println("Booking History Report:");
        for (var reservation : history.getConfirmedReservations()) {
            System.out.println("Guest: " + reservation.getGuestName() +
                    ", Room Type: " + reservation.getRoomType());
        }
    }
}
