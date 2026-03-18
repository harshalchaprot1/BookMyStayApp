package bookmystay.service;

import bookmystay.model.RoomInventory;
import java.util.*;

/**
 * Use Case 10: Booking Cancellation & Inventory Rollback
 *
 * Handles booking cancellations safely.
 * Tracks cancelled room IDs and restores inventory correctly.
 *
 * @author Harshal
 * @version 10.1
 */
public class CancellationService {
    private Map<String, String> reservationRoomTypeMap;
    private Stack<String> rollbackStack;

    public CancellationService() {
        reservationRoomTypeMap = new HashMap<>();
        rollbackStack = new Stack<>();
    }

    /** Registers a confirmed booking for future cancellation. */
    public void registerBooking(String reservationId, String roomType) {
        reservationRoomTypeMap.put(reservationId, roomType);
    }

    /** Cancels a confirmed booking and restores inventory safely. */
    public void cancelBooking(String reservationId, RoomInventory inventory) {
        if (!reservationRoomTypeMap.containsKey(reservationId)) {
            System.out.println("Cancellation failed: Reservation ID not found.");
            return;
        }

        String roomType = reservationRoomTypeMap.get(reservationId);

        // Restore inventory
        int currentAvailability = inventory.getRoomAvailability().get(roomType);
        inventory.updateAvailability(roomType, currentAvailability + 1);

        // Track rollback with both reservationId and roomType
        rollbackStack.push(reservationId + ":" + roomType);

        // Remove from active reservations
        reservationRoomTypeMap.remove(reservationId);

        System.out.println("Booking cancelled successfully. Inventory restored for room type: " + roomType);
    }

    /** Displays recently cancelled reservations in rollback order. */
    public void showRollbackHistory(RoomInventory inventory) {
        System.out.println("\nRollback History (Most Recent First):");
        while (!rollbackStack.isEmpty()) {
            String entry = rollbackStack.pop();
            String[] parts = entry.split(":");
            String reservationId = parts[0];
            String roomType = parts[1];

            System.out.println("Released Reservation ID: " + reservationId);
            System.out.println("Updated " + roomType + " Availability: " +
                    inventory.getRoomAvailability().get(roomType));
        }
    }
}
