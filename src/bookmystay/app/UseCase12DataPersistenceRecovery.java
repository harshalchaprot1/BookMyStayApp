package bookmystay.app;

import bookmystay.model.RoomInventory;
import bookmystay.service.FilePersistenceService;

/**
 * Use Case 12: Data Persistence & System Recovery
 *
 * Demonstrates how system state can be restored after an application restart.
 * Inventory data is loaded from a file before any booking operations occur.
 *
 * @author Harshal
 * @version 12.0
 */
public class UseCase12DataPersistenceRecovery {
    public static void main(String[] args) {
        RoomInventory inventory = new RoomInventory();
        FilePersistenceService persistenceService = new FilePersistenceService();

        String filePath = "inventory.txt";

        // Load inventory state
        persistenceService.loadInventory(inventory, filePath);

        // Display current inventory
        System.out.println("\nCurrent Inventory:");
        System.out.println("SingleRoom: " + inventory.getRoomAvailability().get("SingleRoom"));
        System.out.println("DoubleRoom: " + inventory.getRoomAvailability().get("DoubleRoom"));
        System.out.println("SuiteRoom: " + inventory.getRoomAvailability().get("SuiteRoom"));

        // Save inventory state
        persistenceService.saveInventory(inventory, filePath);
    }
}
