package bookmystay.service;

import bookmystay.model.Reservation;
import bookmystay.model.RoomInventory;

/**
 * Use Case 11: Concurrent Booking Simulation
 *
 * Represents a booking processor that can be executed by multiple threads.
 * Demonstrates how shared resources (booking queue, inventory) must be accessed
 * in a thread-safe manner.
 *
 * @author Harshal
 * @version 11.0
 */
public class ConcurrentBookingProcessor implements Runnable {
    private BookingRequestQueue bookingQueue;
    private RoomInventory inventory;
    private RoomAllocationService allocationService;

    public ConcurrentBookingProcessor(BookingRequestQueue bookingQueue,
                                      RoomInventory inventory,
                                      RoomAllocationService allocationService) {
        this.bookingQueue = bookingQueue;
        this.inventory = inventory;
        this.allocationService = allocationService;
    }

    @Override
    public void run() {
        while (bookingQueue.hasPendingRequests()) {
            Reservation reservation;

            // Synchronize queue access
            synchronized (bookingQueue) {
                reservation = bookingQueue.getNextRequest();
            }

            if (reservation != null) {
                // Synchronize inventory allocation
                synchronized (inventory) {
                    allocationService.allocateRoom(reservation, inventory);
                }
            }
        }
    }
}
