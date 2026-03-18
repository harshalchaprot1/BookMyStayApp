package bookmystay.service;

import bookmystay.model.AddOnService;
import bookmystay.model.Reservation;
import java.util.*;

/**
 * Use Case 7: Add-On Service Manager
 *
 * Manages association between reservations and selected services.
 * Supports multiple services per reservation.
 *
 * @author Harshal
 * @version 7.0
 */
public class AddOnServiceManager {
    private Map<String, List<AddOnService>> reservationServices;

    public AddOnServiceManager() {
        reservationServices = new HashMap<>();
    }

    /** Attach a service to a reservation. */
    public void addServiceToReservation(Reservation reservation, AddOnService service) {
        reservationServices
                .computeIfAbsent(reservation.getGuestName(), k -> new ArrayList<>())
                .add(service);
    }

    /** Get all services for a reservation. */
    public List<AddOnService> getServicesForReservation(Reservation reservation) {
        return reservationServices.getOrDefault(reservation.getGuestName(), Collections.emptyList());
    }

    /** Calculate total additional cost for a reservation. */
    public double calculateTotalServiceCost(Reservation reservation) {
        return getServicesForReservation(reservation)
                .stream()
                .mapToDouble(AddOnService::getServiceCost)
                .sum();
    }
}
