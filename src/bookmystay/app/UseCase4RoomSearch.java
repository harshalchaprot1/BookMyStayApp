package bookmystay.app;

import bookmystay.model.*;
import bookmystay.service.RoomSearchService;

/**
 * Use Case 4: Room Search & Availability Check
 *
 * Demonstrates how guests can view available rooms without modifying inventory data.
 * Enforces read-only access by design.
 *
 * @author Harshal
 * @version 4.0
 */
public class UseCase4RoomSearch {
    public static void main(String[] args) {
        Room single = new SingleRoom();
        Room doubleRoom = new DoubleRoom();
        Room suite = new SuiteRoom();

        RoomInventory inventory = new RoomInventory();
        RoomSearchService searchService = new RoomSearchService();

        searchService.searchAvailableRooms(inventory, single, doubleRoom, suite);
    }
}
