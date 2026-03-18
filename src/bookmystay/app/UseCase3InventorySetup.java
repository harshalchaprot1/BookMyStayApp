package bookmystay.app;

import bookmystay.model.*;

/**
 * Use Case 3: Centralized Room Inventory Management
 *
 * Demonstrates how room availability is managed using a centralized inventory.
 * Room objects provide characteristics; inventory provides availability.
 *
 * @author Harshal
 * @version 3.0
 */
public class UseCase3InventorySetup {
    public static void main(String[] args) {
        Room single = new SingleRoom();
        Room doubleRoom = new DoubleRoom();
        Room suite = new SuiteRoom();

        RoomInventory inventory = new RoomInventory();

        System.out.println("Single Room:");
        single.displayRoomDetails();
        System.out.println("Available Rooms: " + inventory.getRoomAvailability().get("SingleRoom"));

        System.out.println("\nDouble Room:");
        doubleRoom.displayRoomDetails();
        System.out.println("Available Rooms: " + inventory.getRoomAvailability().get("DoubleRoom"));

        System.out.println("\nSuite Room:");
        suite.displayRoomDetails();
        System.out.println("Available Rooms: " + inventory.getRoomAvailability().get("SuiteRoom"));
    }
}
