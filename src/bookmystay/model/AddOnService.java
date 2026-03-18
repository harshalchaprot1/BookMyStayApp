package bookmystay.model;

/**
 * Use Case 7: Add-On Service
 *
 * Represents an optional service that can be attached to a reservation.
 * Examples: Breakfast, Airport Pickup, Spa Access.
 *
 * @author Harshal
 * @version 7.0
 */
public class AddOnService {
    private String serviceName;
    private double serviceCost;

    public AddOnService(String serviceName, double serviceCost) {
        this.serviceName = serviceName;
        this.serviceCost = serviceCost;
    }

    public String getServiceName() {
        return serviceName;
    }

    public double getServiceCost() {
        return serviceCost;
    }

    @Override
    public String toString() {
        return serviceName + " (₹" + serviceCost + ")";
    }
}
