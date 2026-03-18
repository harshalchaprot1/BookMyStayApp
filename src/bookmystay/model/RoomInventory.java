package bookmystay.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Use Case 3: Centralized Room Inventory Management
 *
 * Acts as the single source of truth for room availability.
 * Room characteristics remain in Room classes; only availability is tracked here.
 *
 * @author Harshal
 * @version 3.0
 */
public class RoomInventory {
    /** Centralized map of room type to available count. */
    private Map<String, Integer> roomAvailability;

    /** Constructor initializes the inventory with default availability values. */
    public RoomInventory() {
        roomAvailability = new HashMap<>();
        initializeInventory();
    }

    /** Initializes room availability data. */
    private void initializeInventory() {
        roomAvailability.put("SingleRoom", 5);
        roomAvailability.put("DoubleRoom", 3);
        roomAvailability.put("SuiteRoom", 2);
    }

    /** Returns the current availability map. */
    public Map<String, Integer> getRoomAvailability() {
        return roomAvailability;
    }

    /** Updates availability for a specific room type. */
    public void updateAvailability(String roomType, int count) {
        roomAvailability.put(roomType, count);
    }
}
