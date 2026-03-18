package bookmystay.app;

import bookmystay.model.Reservation;
import bookmystay.service.BookingRequestQueue;

/**
 * Use Case 5: Booking Request (First-Come-First-Served)
 *
 * Demonstrates how booking requests are accepted and queued
 * in a fair and predictable order.
 * No room allocation or inventory update is performed here.
 *
 * @author Harshal
 * @version 5.0
 */
public class UseCase5BookingRequestQueue {
    public static void main(String[] args) {
        BookingRequestQueue bookingQueue = new BookingRequestQueue();

        // Create booking requests
        Reservation r1 = new Reservation("Abhi", "Single");
        Reservation r2 = new Reservation("Subha", "Double");
        Reservation r3 = new Reservation("Vanmathi", "Suite");

        // Add requests to the queue
        bookingQueue.addRequest(r1);
        bookingQueue.addRequest(r2);
        bookingQueue.addRequest(r3);

        // Display queued booking requests in FIFO order
        System.out.println("Booking Request Queue:");
        while (bookingQueue.hasPendingRequests()) {
            Reservation next = bookingQueue.getNextRequest();
            System.out.println("Processing booking for Guest: " +
                    next.getGuestName() +
                    ", Room Type: " + next.getRoomType());
        }
    }
}
