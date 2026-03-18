package bookmystay.app;

import bookmystay.model.Reservation;
import bookmystay.model.AddOnService;
import bookmystay.service.AddOnServiceManager;

/**
 * Use Case 7: Reservation with Optional Services
 *
 * Demonstrates how guests can select optional services
 * without modifying booking or inventory state.
 *
 * @author Harshal
 * @version 7.0
 */
public class UseCase7AddOnServices {
    public static void main(String[] args) {
        Reservation r1 = new Reservation("Abhi", "SingleRoom");
        Reservation r2 = new Reservation("Subha", "DoubleRoom");

        AddOnService breakfast = new AddOnService("Breakfast", 500.0);
        AddOnService airportPickup = new AddOnService("Airport Pickup", 1200.0);
        AddOnService spaAccess = new AddOnService("Spa Access", 2000.0);

        AddOnServiceManager manager = new AddOnServiceManager();

        // Attach services
        manager.addServiceToReservation(r1, breakfast);
        manager.addServiceToReservation(r1, spaAccess);
        manager.addServiceToReservation(r2, airportPickup);

        // Display services and costs
        System.out.println("Reservation for " + r1.getGuestName() + ":");
        System.out.println("Selected Services: " + manager.getServicesForReservation(r1));
        System.out.println("Total Additional Cost: ₹" + manager.calculateTotalServiceCost(r1));

        System.out.println("\nReservation for " + r2.getGuestName() + ":");
        System.out.println("Selected Services: " + manager.getServicesForReservation(r2));
        System.out.println("Total Additional Cost: ₹" + manager.calculateTotalServiceCost(r2));
    }
}
