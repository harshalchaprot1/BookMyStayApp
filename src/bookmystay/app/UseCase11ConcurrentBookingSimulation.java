package bookmystay.app;

import bookmystay.model.Reservation;
import bookmystay.model.RoomInventory;
import bookmystay.service.BookingRequestQueue;
import bookmystay.service.ConcurrentBookingProcessor;
import bookmystay.service.RoomAllocationService;

/**
 * Use Case 11: Concurrent Booking Simulation
 *
 * Simulates multiple users attempting to book rooms at the same time.
 * Highlights race conditions and demonstrates how synchronization
 * prevents inconsistent allocations.
 *
 * @author Harshal
 * @version 11.0
 */
public class UseCase11ConcurrentBookingSimulation {
    public static void main(String[] args) {
        RoomInventory inventory = new RoomInventory();
        BookingRequestQueue bookingQueue = new BookingRequestQueue();
        RoomAllocationService allocationService = new RoomAllocationService();

        // Add booking requests
        bookingQueue.addRequest(new Reservation("Abhi", "SingleRoom"));
        bookingQueue.addRequest(new Reservation("Vanmathi", "DoubleRoom"));
        bookingQueue.addRequest(new Reservation("Kural", "SuiteRoom"));
        bookingQueue.addRequest(new Reservation("Subha", "SingleRoom"));

        // Create processors
        Thread t1 = new Thread(new ConcurrentBookingProcessor(bookingQueue, inventory, allocationService));
        Thread t2 = new Thread(new ConcurrentBookingProcessor(bookingQueue, inventory, allocationService));

        // Start concurrent processing
        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            System.out.println("Thread execution interrupted.");
        }

        // Show remaining inventory
        System.out.println("\nRemaining Inventory:");
        System.out.println("SingleRoom: " + inventory.getRoomAvailability().get("SingleRoom"));
        System.out.println("DoubleRoom: " + inventory.getRoomAvailability().get("DoubleRoom"));
        System.out.println("SuiteRoom: " + inventory.getRoomAvailability().get("SuiteRoom"));
    }
}
