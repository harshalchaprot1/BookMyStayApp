package bookmystay.app;

import bookmystay.model.RoomInventory;
import bookmystay.service.CancellationService;

/**
 * Use Case 10: Booking Cancellation & Inventory Rollback
 *
 * Demonstrates how confirmed bookings can be cancelled safely.
 * Inventory is restored and rollback history is maintained.
 *
 * @author Harshal
 * @version 10.0
 */
public class UseCase10BookingCancellation {
    public static void main(String[] args) {
        RoomInventory inventory = new RoomInventory();
        CancellationService cancellationService = new CancellationService();

        // Simulate confirmed bookings
        cancellationService.registerBooking("SingleRoom-1", "SingleRoom");
        cancellationService.registerBooking("SingleRoom-2", "SingleRoom");
        cancellationService.registerBooking("SuiteRoom-1", "SuiteRoom");

        // Cancel one booking
        System.out.println("Booking Cancellation");
        cancellationService.cancelBooking("SingleRoom-1", inventory);

        // Show rollback history
        cancellationService.showRollbackHistory(inventory);
    }
}
