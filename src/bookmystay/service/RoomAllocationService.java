package bookmystay.service;

import bookmystay.model.Reservation;
import bookmystay.model.RoomInventory;
import java.util.*;

/**
 * Use Case 6: Reservation Confirmation & Room Allocation
 *
 * Confirms booking requests and assigns rooms safely.
 * Ensures:
 * - Each room ID is unique
 * - Inventory is updated immediately
 * - No room is double-booked
 *
 * @author Harshal
 * @version 6.0
 */
public class RoomAllocationService {
    private Set<String> allocatedRoomIds;
    private Map<String, Set<String>> assignedRoomsByType;

    public RoomAllocationService() {
        allocatedRoomIds = new HashSet<>();
        assignedRoomsByType = new HashMap<>();
    }

    /**
     * Confirms a booking request by assigning a unique room ID
     * and updating inventory immediately.
     *
     * @param reservation booking request
     * @param inventory centralized room inventory
     */
    public void allocateRoom(Reservation reservation, RoomInventory inventory) {
        String roomType = reservation.getRoomType();
        Map<String, Integer> availability = inventory.getRoomAvailability();

        if (availability.containsKey(roomType) && availability.get(roomType) > 0) {
            String roomId = generateRoomId(roomType);

            // Ensure uniqueness
            if (!allocatedRoomIds.contains(roomId)) {
                allocatedRoomIds.add(roomId);

                assignedRoomsByType
                        .computeIfAbsent(roomType, k -> new HashSet<>())
                        .add(roomId);

                // Update inventory immediately
                inventory.updateAvailability(roomType, availability.get(roomType) - 1);

                System.out.println("Booking confirmed for Guest: " +
                        reservation.getGuestName() +
                        ", Room ID: " + roomId);
            } else {
                System.out.println("Error: Room ID already allocated!");
            }
        } else {
            System.out.println("Booking failed for Guest: " +
                    reservation.getGuestName() +
                    " - No " + roomType + " rooms available.");
        }
    }

    /** Generates a unique room ID for the given room type. */
    private String generateRoomId(String roomType) {
        int count = assignedRoomsByType.getOrDefault(roomType, new HashSet<>()).size() + 1;
        return roomType + "-" + count;
    }
}
