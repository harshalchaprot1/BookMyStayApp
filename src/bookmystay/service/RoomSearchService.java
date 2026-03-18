package bookmystay.service;

import bookmystay.model.Room;
import bookmystay.model.RoomInventory;
import java.util.Map;

/**
 * Use Case 4: Room Search & Availability Check
 *
 * Provides search functionality for guests to view available rooms.
 * Performs read-only access to inventory and room data.
 * No inventory mutation or booking logic is performed here.
 *
 * @author Harshal
 * @version 4.0
 */
public class RoomSearchService {

    /**
     * Displays available rooms along with their details and pricing.
     * Only rooms with availability > 0 are shown.
     *
     * @param inventory centralized room inventory
     * @param singleRoom single room definition
     * @param doubleRoom double room definition
     * @param suiteRoom suite room definition
     */
    public void searchAvailableRooms(RoomInventory inventory,
                                     Room singleRoom,
                                     Room doubleRoom,
                                     Room suiteRoom) {
        Map<String, Integer> availability = inventory.getRoomAvailability();

        if (availability.get("SingleRoom") != null && availability.get("SingleRoom") > 0) {
            System.out.println("Single Room:");
            singleRoom.displayRoomDetails();
            System.out.println("Available: " + availability.get("SingleRoom"));
        }

        if (availability.get("DoubleRoom") != null && availability.get("DoubleRoom") > 0) {
            System.out.println("\nDouble Room:");
            doubleRoom.displayRoomDetails();
            System.out.println("Available: " + availability.get("DoubleRoom"));
        }

        if (availability.get("SuiteRoom") != null && availability.get("SuiteRoom") > 0) {
            System.out.println("\nSuite Room:");
            suiteRoom.displayRoomDetails();
            System.out.println("Available: " + availability.get("SuiteRoom"));
        }
    }
}
