package bookmystay.app;

import bookmystay.model.Reservation;
import bookmystay.model.RoomInventory;
import bookmystay.service.BookingRequestQueue;
import bookmystay.service.RoomAllocationService;

/**
 * Use Case 6: Reservation Confirmation & Room Allocation
 *
 * Demonstrates how booking requests are confirmed and rooms allocated safely.
 * Consumes booking requests in FIFO order and updates inventory immediately.
 *
 * @author Harshal
 * @version 6.0
 */
public class UseCase6RoomAllocation {
    public static void main(String[] args) {
        RoomInventory inventory = new RoomInventory();
        BookingRequestQueue bookingQueue = new BookingRequestQueue();
        RoomAllocationService allocationService = new RoomAllocationService();

        // Create and enqueue booking requests
        bookingQueue.addRequest(new Reservation("Abhi", "SingleRoom"));
        bookingQueue.addRequest(new Reservation("Subha", "SingleRoom"));
        bookingQueue.addRequest(new Reservation("Vanmathi", "SuiteRoom"));

        System.out.println("Room Allocation Processing:");
        while (bookingQueue.hasPendingRequests()) {
            Reservation next = bookingQueue.getNextRequest();
            allocationService.allocateRoom(next, inventory);
        }
    }
}
