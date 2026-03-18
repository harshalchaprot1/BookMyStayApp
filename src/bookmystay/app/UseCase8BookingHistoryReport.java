package bookmystay.app;

import bookmystay.model.Reservation;
import bookmystay.service.BookingHistory;
import bookmystay.service.BookingReportService;

/**
 * Use Case 8: Booking History & Reporting
 *
 * Demonstrates how confirmed bookings are stored and reported.
 * Maintains an ordered audit trail of reservations.
 *
 * @author Harshal
 * @version 8.0
 */
public class UseCase8BookingHistoryReport {
    public static void main(String[] args) {
        BookingHistory history = new BookingHistory();

        // Simulate confirmed reservations
        history.addReservation(new Reservation("Abhi", "SingleRoom"));
        history.addReservation(new Reservation("Subha", "DoubleRoom"));
        history.addReservation(new Reservation("Vanmathi", "SuiteRoom"));

        // Generate report
        BookingReportService reportService = new BookingReportService();
        System.out.println("Booking History and Reporting\n");
        reportService.generateReport(history);
    }
}
